import javax.swing.*;
import java.awt.*;

public class Design extends JTextField {
    private static final long serialVersionUID = 1L;

    public static final Color given = new Color(240,240,240);
    public static final Color given_f = Color.BLACK;
    public static final Color not_given = Color.DARK_GRAY;
    public static final Color to_guess = Color.YELLOW;
    public static final Color correct_guess = new Color(0,216,0);
    public static final Color wrong_guess = new Color(216,0,0);
    public static final Font FONT_NUMBERS = new Font("OCR A Extended", Font.PLAIN, 28);

    int row,col;
    int num;
    Puzzle puzzle;
    public CellStatus status;

    public Design(int row, int col) {
        this.row = row;
        this.col = col;
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(FONT_NUMBERS);
    }
    public void Refresh(int num,boolean isGiven){
        this.num = num;

    }
    public void paint(){
        if(status == CellStatus.GIVEN){
            super.setText(num + "");
            super.setEditable(false);
            super.setBackground(given);
            super.setForeground(given_f);

        }
        else if(status == CellStatus.TO_GUESS){
            super.setText("");
            super.setEditable(true);
            super.setBackground(given);
            super.setForeground(not_given);
        } else if (status == CellStatus.CORRECT_GUESS) {
            super.setBackground(correct_guess);
        } else if (status == CellStatus.WRONG_GUESS) {
            super.setBackground(wrong_guess);
        }

        }
    }

