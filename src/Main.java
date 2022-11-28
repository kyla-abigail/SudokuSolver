import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private static final long serialVersionUID = 1L;

    Panel board = new Panel();
    JButton NewGame = new JButton("New Game");

    public Main() throws HeadlessException {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(board,BorderLayout.CENTER);

        //board.Refreshing();

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}