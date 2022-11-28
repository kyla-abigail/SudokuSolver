import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**gui design layout cited from ehchua@ntu.edu.sg
 * Latest version tested: JDK 17.0.1
 * Last modified: May, 2022 *
 * Accessed: 19th November to 29th November*/
public class Panel extends JPanel {
    private static final long serialVersionUID = 1L;
    public static final int input = 9;
    public static final int cell_size = 60;
    public static final int board_width= cell_size*input;
    public static final int board_height= cell_size*input;
    private Design[][] design = new Design[9][9];

    private newPuzzle[][] puzzles = new newPuzzle[9][9];
    private Puzzle puzzle = new Puzzle();

    public Panel() {
        super.setLayout(new GridLayout(9,9));
        for (int row=0;row < input;row++){
            for (int col=0;col<input;col++){
            design[row][col] = new Design(row,col);
            super.add(design[row][col]);
            }
        }
        CellListener listener = new CellListener();
        for (int row=0;row<input;row++){
            for (int col=0;col<input;col++){
                if(design[row][col].isEditable()){
                    design[row][col].addActionListener(listener);
                }
            }
        }
        super.setPreferredSize(new Dimension(board_width,board_height));
    }
   public void Refreshing(){
       puzzles.newPuzzle(2);
       for(int row=0;row<9;++row){
           for(int col=0;col<9;++col){
               design[row][col].Refresh(puzzles.newNumbers[row][col],puzzles.hardIsGiven[row][col]);
           }
       }

    }
    public boolean isSolved(){
        for (int row=0;row<input;row++){
            for (int col=0;col<input;col++){
                if(design[row][col].status == CellStatus.to_guess){
                    return false;
                }
            }
        }
        return true;
    }
    private class CellListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Design design1 = (Design)e.getSource();

            int numGuess = Integer.parseInt(design1.getText());

            System.out.println("You entered"+ numGuess);

            if(numGuess == design1.num){
                design1.status = CellStatus.CORRECT_GUESS;

            }
            else{
                design1.status = CellStatus.WRONG_GUESS;
            }
            design1.paint();;
        }
    }
}
