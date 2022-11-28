public class newPuzzle {
    private static final long serialVersionUID = 1L;
    int[][] newNumbers = new int[9][9];

    boolean[][] isGiven = new boolean[9][9];
    private Puzzle puzzle;
    private int[][] hardNumbers = new int[9][9];

    public newPuzzle() {
        super();
    }




    public void newPuzzle(int cellsToGuess){
        hardNumbers = puzzle.answer();
        for(int row=0;row<9;++row){
            for(int col=0;col<9;++col){
                newNumbers[row][col] = hardNumbers[row][col];
            }
        }

        boolean[][] hardIsGiven = new boolean[9][9];
        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(hardNumbers[i][j] == 0){
                    hardIsGiven[i][j] = true;
                }
                else{
                    hardIsGiven[i][j] = false;
                }
            }
        }

        for(int row =0;row<9;++row){
            for(int col=0;col<9;++col){
                isGiven[row][col] = hardIsGiven[row][col];
            }
        }
    }

}
