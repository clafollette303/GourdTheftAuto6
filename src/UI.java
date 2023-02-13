import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class UI
{
    //fields for the game window stuff
    private ActionListener choiceHandler;
    private Font mainFont = new Font("Times New Roman", Font.PLAIN, 32);
    private GameWindow gameWindow;
    private JButton choiceButtonOne, choiceButtonTwo, choiceButtonThree, choiceButtonFour;
    private JLabel playerLocationLabel, gourdImageLabel, gourdImageLabel2, gourdImageLabel3;
    private JPanel mainGamePanel, playerStatsPanel, choiceButtonPanel, gourdPanel;
    private JTextArea mainTextArea;

    //these control the letter by letter text
    private Timer timer = new Timer(18, new CharacterTimer());
    private String displayText;
    private char[] displayTextAsArray;
    private int currentChar;

    //controls gourd trip
    private Timer gourdTimer = new Timer(200, new GourdTimer());
    private Color[] colors;
    private int currentColor;
    private int gourdX, gourdY;

    //constructor that needs an action listener and a game window
    public UI(ActionListener choiceHandler, GameWindow gameWindow)
    {
        this.choiceHandler = choiceHandler;
        this.gameWindow = gameWindow;
    }

    //this will be what creates the UI panels for every area.
    //this method also adds the panels to the game window.
    public void createUI()
    {
        //creates a central panel for the game
        mainGamePanel = new JPanel();
        mainGamePanel.setBackground(Color.BLACK);
        mainGamePanel.setForeground(Color.WHITE);
        mainGamePanel.setLayout(new BorderLayout());

        //creates text area to add to main text panel
        mainTextArea = new JTextArea();
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(mainFont);
        mainTextArea.setEditable(false);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setHighlighter(null);
        mainTextArea.setMargin(new Insets(10,10,10,10));
        mainTextArea.addMouseListener(new MouseInput());

        //creates panel to show player their current stats, which is just their location for now
        playerStatsPanel = new JPanel();
        playerStatsPanel.setBackground(new Color(0x252525));
        playerStatsPanel.setBorder(BorderFactory.createEtchedBorder(Color.GREEN, Color.BLACK));
        playerStatsPanel.setLayout(new GridLayout(1, 0));

        //creates text label to show player where they are.
        playerLocationLabel = new JLabel();
        playerLocationLabel.setForeground(Color.GREEN);
        playerLocationLabel.setFont(mainFont);

        //creates panel to display players current choices
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBackground(new Color(0x252525));
        choiceButtonPanel.setForeground(Color.GREEN);
        choiceButtonPanel.setBorder(BorderFactory.createEtchedBorder(Color.GREEN, Color.BLACK));
        choiceButtonPanel.setLayout(new GridLayout(0,1));

        //creates button for choice one
        choiceButtonOne = new JButton("Choice 1");
        choiceButtonOne.setBackground(Color.BLACK);
        choiceButtonOne.setForeground(Color.GREEN);
        choiceButtonOne.setFont(mainFont);
        choiceButtonOne.setFocusPainted(false);
        choiceButtonOne.setBorderPainted(false);
        choiceButtonOne.setContentAreaFilled(false);
        choiceButtonOne.addActionListener(choiceHandler);
        choiceButtonOne.setActionCommand("choiceOne");
        choiceButtonOne.setHorizontalAlignment(SwingConstants.LEFT);
        choiceButtonOne.addMouseListener(new MouseDetector(choiceButtonOne));

        //creates button for choice two
        choiceButtonTwo = new JButton("Choice 2");
        choiceButtonTwo.setBackground(Color.BLACK);
        choiceButtonTwo.setForeground(Color.GREEN);
        choiceButtonTwo.setFont(mainFont);
        choiceButtonTwo.setFocusPainted(false);
        choiceButtonTwo.setBorderPainted(false);
        choiceButtonTwo.setContentAreaFilled(false);
        choiceButtonTwo.addActionListener(choiceHandler);
        choiceButtonTwo.setActionCommand("choiceTwo");
        choiceButtonTwo.setHorizontalAlignment(SwingConstants.LEFT);
        choiceButtonTwo.addMouseListener(new MouseDetector(choiceButtonTwo));

        //creates button for choice three
        choiceButtonThree = new JButton("Choice 3");
        choiceButtonThree.setBackground(Color.BLACK);
        choiceButtonThree.setForeground(Color.GREEN);
        choiceButtonThree.setFont(mainFont);
        choiceButtonThree.setFocusPainted(false);
        choiceButtonThree.setBorderPainted(false);
        choiceButtonThree.setContentAreaFilled(false);
        choiceButtonThree.addActionListener(choiceHandler);
        choiceButtonThree.setActionCommand("choiceThree");
        choiceButtonThree.setHorizontalAlignment(SwingConstants.LEFT);
        choiceButtonThree.addMouseListener(new MouseDetector(choiceButtonThree));

        //creates button for choice four
        choiceButtonFour = new JButton("Choice 4");
        choiceButtonFour.setBackground(Color.BLACK);
        choiceButtonFour.setForeground(Color.GREEN);
        choiceButtonFour.setFont(mainFont);
        choiceButtonFour.setFocusPainted(false);
        choiceButtonFour.setBorderPainted(false);
        choiceButtonFour.setContentAreaFilled(false);
        choiceButtonFour.addActionListener(choiceHandler);
        choiceButtonFour.setActionCommand("choiceFour");
        choiceButtonFour.setHorizontalAlignment(SwingConstants.LEFT);
        choiceButtonFour.addMouseListener(new MouseDetector(choiceButtonFour));

        //adds text area to main game panel
        mainGamePanel.add(mainTextArea, BorderLayout.CENTER);

        //adds player location label to player stats panel
        playerStatsPanel.add(playerLocationLabel);

        //adds choice buttons to choice button panel
        choiceButtonPanel.add(choiceButtonOne);
        choiceButtonPanel.add(choiceButtonTwo);
        choiceButtonPanel.add(choiceButtonThree);
        choiceButtonPanel.add(choiceButtonFour);

        //adds everything to game window
        gameWindow.add(mainGamePanel, BorderLayout.CENTER);
        gameWindow.add(choiceButtonPanel, BorderLayout.SOUTH);
        gameWindow.add(playerStatsPanel, BorderLayout.NORTH);
    }

    //this method removes panels from game window to clear space when moving from one location to the next
    public void deleteUI()
    {
        gameWindow.remove(mainGamePanel);
        gameWindow.remove(choiceButtonPanel);
        gameWindow.remove(playerStatsPanel);
    }

    //method used to change the text that is displayed in the main area.
    //it hides buttons until all text is displayed, clears any text previously on screen, sets "currentChar" to 0 to avoid overlap, and then starts the timer.
    public void setMainTextArea(String s)
    {
        hideChoiceButtons();
        mainTextArea.setText("");
        currentChar = 0;
        displayText = s;
        displayTextAsArray = s.toCharArray();
        timer.start();
    }

    //creates an array of colors to cycle through, creates labels to set images as gourds, and then starts gourd timer
    public void gourdTrip()
    {
        colors = new Color[11];
        colors[0] = Color.RED;
        colors[1] = new Color(0xdc340a);
        colors[2] = Color.ORANGE;
        colors[3] = new Color(0xe2a708);
        colors[4] = Color.YELLOW;
        colors[5] = new Color(0xb4e208);
        colors[6] = Color.GREEN;
        colors[7] = new Color(0x08e2c0);
        colors[8] = Color.BLUE;
        colors[9] = new Color(0x4008e2);
        colors[10] = new Color(0x8800c7);

        gourdPanel = new JPanel();
        gourdPanel.setBackground(new Color(0X8800c7));

        gourdX = gameWindow.getX() / 2;
        gourdY = gameWindow.getY() / 2;

        gourdImageLabel = new JLabel();
        gourdImageLabel.setIcon(new ImageIcon("Pictures/Gourd.png"));
        gourdImageLabel.setLocation(gourdX, gourdY);

        gourdImageLabel2 = new JLabel();
        gourdImageLabel2.setIcon(new ImageIcon("Pictures/Gourd.png"));
        gourdImageLabel2.setLocation(gourdX + 50, gourdY + 50);

        gourdImageLabel3 = new JLabel();
        gourdImageLabel3.setIcon(new ImageIcon("Pictures/Gourd.png"));
        gourdImageLabel3.setLocation(gourdX + 100, gourdY + 100);

        gourdPanel.add(gourdImageLabel);
        gourdPanel.add(gourdImageLabel2);
        gourdPanel.add(gourdImageLabel3);

        gameWindow.remove(mainGamePanel);
        gameWindow.add(gourdPanel, BorderLayout.CENTER);

        gourdTimer.start();
    }

    public void endGourdTrip()
    {
        gourdTimer.stop();
        gameWindow.remove(gourdPanel);
        gameWindow.add(mainGamePanel, BorderLayout.CENTER);
    }

    //method used to update the players location
    public void setLocationText(String s)
    {
        playerLocationLabel.setText(" Current Location: " + s);
    }

    //methods to change text on choice buttons
    public void setButtonOneText(String s)
    {
        choiceButtonOne.setText(s);
    }
    public void setButtonTwoText(String s)
    {
        choiceButtonTwo.setText(s);
    }
    public void setButtonThreeText(String s)
    {
        choiceButtonThree.setText(s);
    }
    public void setButtonFourText(String s)
    {
        choiceButtonFour.setText(s);
    }

    //method we can use so that we don't have to set each button whenever we want to have a continue section
    public void setContinueState()
    {
        this.setButtonOneText("Continue");
        this.setButtonTwoText("");
        this.setButtonThreeText("");
        this.setButtonFourText("");
    }

    //used to hide buttons until all text is displayed
    public void hideChoiceButtons()
    {
        choiceButtonOne.setVisible(false);
        choiceButtonTwo.setVisible(false);
        choiceButtonThree.setVisible(false);
        choiceButtonFour.setVisible(false);
    }

    //used to reveal buttons once text has finished
    public void showChoiceButtons()
    {
        choiceButtonOne.setVisible(true);
        choiceButtonTwo.setVisible(true);
        choiceButtonThree.setVisible(true);
        choiceButtonFour.setVisible(true);
    }

    //this creates a character array from a string, and then adds that character to the screen for every interval that is set in the timer object
    //the timer stops when the currentChar int is equal to the length of the text that is passed as a string
    private class CharacterTimer implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String text = String.valueOf(displayTextAsArray[currentChar]);

            mainTextArea.append(text);

            currentChar++;

            if(currentChar == displayTextAsArray.length)
            {
                showChoiceButtons();
                timer.stop();
            }
        }
    }

    //cycles through the colors in the color array, and randomizes a location on the screen for each of the gourd labels
    private class GourdTimer implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Random random = new Random();

            gourdPanel.setBackground(colors[currentColor]);

            currentColor++;

            gourdImageLabel.setLocation(random.nextInt(800) + 1, random.nextInt(400) + 1);
            gourdImageLabel2.setLocation(random.nextInt(800) + 1, random.nextInt(400) + 1);
            gourdImageLabel3.setLocation(random.nextInt(800) + 1, random.nextInt(400) + 1);

            if(currentColor == colors.length)
            {
                currentColor = 0;
            }
        }
    }

    //mouse listener that is used to immediately display text and choices when player clicks screen
    private class MouseInput implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            timer.stop();
            showChoiceButtons();
            mainTextArea.setText(displayText);
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            choiceButtonOne.setForeground(Color.GREEN);
        }
    }

    //this changes the colors of the choices when the player hovers over them or clicks one of them
    private class MouseDetector implements MouseListener
    {
        private JButton b;

        public MouseDetector(JButton b)
        {
            this.b = b;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            b.setForeground(Color.WHITE);
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            b.setForeground(Color.GREEN);
        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
            b.setForeground(Color.YELLOW);
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            b.setForeground(Color.GREEN);
        }
    }
}