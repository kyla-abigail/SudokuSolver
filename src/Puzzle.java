import java.util.Arrays;

public class Puzzle {
    private static final long serialVersionUID = 1L;
    private static final int input = 9;
    private static final int[] fill = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private int[][] board;

    public Puzzle() {
        Filler(input);
        solve(Filler(input));
        if(solve(Filler(input))){
            this.board = Filler(input);
        }
        else{
            this.board = new int[][]{{4, 0, 0, 0, 5, 0, 0, 9, 0},
                    {0, 0, 0, 3, 0, 0, 1, 0, 0},
                    {5, 0, 0, 0, 6, 0, 0, 0, 8},
                    {0, 0, 9, 0, 0, 3, 0, 0, 1},
                    {2, 0, 0, 0, 0, 0, 0, 3, 0},
                    {0, 0, 0, 0, 4, 0, 0, 2, 0},
                    {0, 0, 1, 0, 0, 0, 0, 0, 0},
                    {0, 8, 0, 0, 0, 0, 7, 0, 0},
                    {6, 0, 0, 0, 0, 0, 0, 0, 3},
                    {0, 0, 4, 0, 2, 0, 0, 0, 0}};
            solve(board);
        }
    }


    public int[][] answer(){
            solve(Filler(9));
            return Filler(9);
    }

    public static int[][] Filler(int input) {
        int[][] sudoku = new int[input][input];
        int[] chosen = new int[9];
        int choose = (int) (Math.random() * 9);
        int changeRow = 0;
        int changeCol = 0;

        for (int i = 0; i < input; i++) {
            chosen[i] = choose;
            for (int j = 0; j < input; j++) {
                sudoku[i][j] = fill[choose];
                choose = (int) (Math.random() * 9);
            }
        }
        int[][] blankArray = new int[9][9];
        int blank = (int) (Math.random() * 2);
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                blankArray[i][j] = blank;
                blank = (int) (Math.random() * 2);
            }
        }
        for(int y=0;y<input;y++) {
            for (int p = 0; p < input; p++) {
                if (blankArray[y][p] == 0) {
                    sudoku[y][p] = 0;
                }
            }
        }
        for(int lastRCheck=0;lastRCheck<9;lastRCheck++){
            for (int lastCCheck=0;lastCCheck<9;lastCCheck++){
                if(sudoku[lastRCheck][lastCCheck] == chosen[lastRCheck]){
                    changeRow++;
                    if(changeRow > 1){
                        sudoku[lastRCheck][lastCCheck]=0;
                    }
                }
                if(sudoku[lastCCheck][lastRCheck] == chosen[lastRCheck]){
                    changeCol++;
                    if(changeCol>1){
                        sudoku[lastCCheck][lastRCheck]=0;
                    }
                }
            }
        }
        return sudoku;
    }

   private static boolean solve(int[][] sudoku){
        for(int row = 0; row < 9;row++) {
            for (int col = 0; col < 9; col++) {
                if (sudoku[row][col] == 0) {
                    for(int trying = 1; trying <= 9; trying++){
                        if(isValid(sudoku,trying,row,col)){
                            sudoku[row][col] = trying;

                            if(solve(sudoku)){
                               return true;
                            }
                            else{
                                sudoku[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] values,int number,int row,int col){
        return !RowCheck(values,number,row)&&!colCheck(values,number,col)&&!checkBox(values,number,row,col);
    }
    private static boolean RowCheck(int[][] values,int number,int row) {
        for (int i = 0; i < 9; i++) {
            if (values[row][i] == number) {
                return true;
            }
        }
        return false;
    }
    private static boolean colCheck(int[][] values,int number,int col) {
        for(int i=0;i<9;i++) {
            if(values[i][col] == number){
                return true;
            }
        }
        return false;
    }
    private static boolean checkBox(int[][]values,int number,int row,int col){
        int rowBox = row-(row%3);
        int colBox = col -(col%3);

        for(int i = rowBox;i<rowBox+3;i++){
            for(int j= colBox;j<colBox+3;j++){
                if(values[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }

}


