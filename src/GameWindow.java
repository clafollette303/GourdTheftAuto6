import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame
{
    private final int SCREEN_WIDTH = 1280;
    private final int SCREEN_HEIGHT = 720;

    //constructor for universal game window
    public GameWindow()
    {
        //generates game window
        this.setTitle("Gourd Theft Auto 6");
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(0X8800c7));
        this.setLayout(new BorderLayout());
        this.setIconImage(new ImageIcon("Pictures/side_logo.jpg").getImage());
    }
}
