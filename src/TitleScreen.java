import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//this class works similarly to the UI class, but since it has almost completely different panels I thought it would be more organized to make the title screen its own class
public class TitleScreen
{
    private ActionListener choiceHandler;
    private Font mainFont = new Font("Times New Roman", Font.PLAIN, 24);
    private Font titleScreenFont = new Font("Times New Roman", Font.BOLD, 64);
    private GameWindow gameWindow;
    private JButton startButton;
    private JLabel titleLabel, eastTitleLabel, westTitleLabel, playerNameLabel, developerTagLabel;
    private JPanel northTitlePanel, eastTitlePanel, westTitlePanel, southTitlePanel, centerTitlePanel;
    private JTextField playerNameField;

    //constructor that needs an action listener and a game window
    public TitleScreen(ActionListener choiceHandler, GameWindow gameWindow)
    {
        this.choiceHandler = choiceHandler;
        this.gameWindow = gameWindow;
    }

    //creates the title screen for game.
    public void createTitleScreen()
    {
        //generates a panel for the title
        northTitlePanel = new JPanel();
        northTitlePanel.setBackground(Color.BLACK);

        //generates title label to be added to title panel
        titleLabel = new JLabel();
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(titleScreenFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setIcon(new ImageIcon("Pictures/top_logo.jpg"));

        //generates panel for right side of the screen
        eastTitlePanel = new JPanel();
        eastTitlePanel.setBackground(Color.BLACK);

        eastTitleLabel = new JLabel("                  ");
        eastTitleLabel.setForeground(Color.GREEN);
        eastTitleLabel.setFont(titleScreenFont);

        //generates panel for left side of the screen
        westTitlePanel = new JPanel();
        westTitlePanel.setBackground(Color.BLACK);

        westTitleLabel = new JLabel("                  ");
        westTitleLabel.setForeground(Color.GREEN);
        westTitleLabel.setFont(titleScreenFont);

        //generates a panel for the center of title screen
        centerTitlePanel = new JPanel();
        centerTitlePanel.setBackground(Color.black);
        centerTitlePanel.setLayout(new BorderLayout());

        //generates a text field that allows player to enter their name
        playerNameField = new JTextField(48);
        playerNameField.setBackground(Color.BLACK);
        playerNameField.setForeground(Color.GREEN);
        playerNameField.setFont(mainFont);
        playerNameField.setBorder(BorderFactory.createEtchedBorder(Color.GREEN, Color.BLACK));

        //generates a label that tells the player to type in their name and press start
        playerNameLabel = new JLabel();
        playerNameLabel.setForeground(Color.GREEN);
        playerNameLabel.setFont(mainFont);
        playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerNameLabel.setIcon(new ImageIcon("Pictures/side_logo.jpg"));

        //generates a panel for bottom of the screen
        southTitlePanel = new JPanel();
        southTitlePanel.setBackground(Color.BLACK);
        southTitlePanel.setLayout(new GridLayout(1, 0));

        //creates a new button to be used as start button
        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.GREEN);
        startButton.setFont(titleScreenFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(choiceHandler);
        startButton.setActionCommand("choiceOne");

        //thought it would be cool to put our group name on the start menu
        developerTagLabel = new JLabel("Developed by Gamers Against Gourd Puns");
        developerTagLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        developerTagLabel.setForeground(Color.GRAY);

        //adds all panels created above to the JFrame window, which shows title screen, start button, and the text field for the players name
        northTitlePanel.add(titleLabel);
        eastTitlePanel.add(eastTitleLabel);
        westTitlePanel.add(westTitleLabel);
        southTitlePanel.add(developerTagLabel);

        //centerTitlePanel.add(playerNameField, BorderLayout.NORTH);
        centerTitlePanel.add(playerNameLabel, BorderLayout.CENTER);
        centerTitlePanel.add(startButton, BorderLayout.SOUTH);

        gameWindow.add(northTitlePanel, BorderLayout.NORTH);
        gameWindow.add(eastTitlePanel, BorderLayout.EAST);
        gameWindow.add(centerTitlePanel, BorderLayout.CENTER);
        gameWindow.add(westTitlePanel, BorderLayout.WEST);
        gameWindow.add(southTitlePanel, BorderLayout.SOUTH);
    }

    //this method will clear the title screen by removing panels
    public void deleteTitleScreen()
    {
        gameWindow.remove(northTitlePanel);
        gameWindow.remove(southTitlePanel);
        gameWindow.remove(centerTitlePanel);
        gameWindow.remove(eastTitlePanel);
        gameWindow.remove(westTitlePanel);
    }

    //method used to get player name from player name text field
    public String getPlayerName()
    {
        return playerNameField.getText();
    }
}
