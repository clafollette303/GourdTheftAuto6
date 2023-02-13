import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements Runnable
{
    private GameWindow gameWindow;
    private Thread thread;

    public UI playerHouseUI, playerBathroomUI, playerBedroomUI, spaceTrainUI, funkySpaceBarUI, finalLocationUI;
    public StoryLocation START_MENU, PLAYER_HOUSE, PLAYER_BATHROOM, PLAYER_BEDROOM, SPACE_TRAIN, FUNKY_SPACE_BAR, FINAL_LOCATION;
    public String choiceOne, choiceTwo, choiceThree, choiceFour;
    public TitleScreen startMenu;

    //game constructor creates a universal game window, creates a thread, and then calls loadUI method
    public Game()
    {
        thread = new Thread(this);
        gameWindow = new GameWindow();

        loadUI();
    }

    //method for creating story location objects and UI objects
    public void loadUI()
    {
        START_MENU = new StartMenu(this);
        startMenu = new TitleScreen(new ChoiceHandler(START_MENU), gameWindow);
        choiceOne = "Start";

        PLAYER_HOUSE = new PlayerHouse(this);
        playerHouseUI = new UI(new ChoiceHandler(PLAYER_HOUSE), gameWindow);

        PLAYER_BATHROOM = new PlayerBathroom(this);
        playerBathroomUI = new UI(new ChoiceHandler(PLAYER_BATHROOM), gameWindow);

        PLAYER_BEDROOM = new PlayerBedroom(this);
        playerBedroomUI = new UI(new ChoiceHandler(PLAYER_BEDROOM), gameWindow);

        SPACE_TRAIN = new SpaceTrain(this);
        spaceTrainUI = new UI(new ChoiceHandler(SPACE_TRAIN), gameWindow);

        FUNKY_SPACE_BAR = new FunkySpaceBar(this);
        funkySpaceBarUI = new UI(new ChoiceHandler(FUNKY_SPACE_BAR), gameWindow);

        FINAL_LOCATION = new FinalLocation(this);
        finalLocationUI = new UI(new ChoiceHandler(FINAL_LOCATION), gameWindow);
    }

    //starts game in new thread
    public void startGame()
    {
        thread.start();
    }

    //this is the method called by thread.start()
    public void run()
    {
        startMenu.createTitleScreen();
        gameWindow.setVisible(true);
    }

    //closes thread and ends game
    public void endGame()
    {
        System.exit(0);
    }

    //action listener to handle player choices. uses an implementation of the StoryLocation interface so that all
    //classes that implement it can use the same action listener
    private class ChoiceHandler implements ActionListener
    {
        private StoryLocation location;

        public ChoiceHandler(StoryLocation location)
        {
            this.location = location;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String playerChoice = e.getActionCommand();

            switch(playerChoice)
            {
                case "choiceOne" :
                    location.setPlayerChoice(choiceOne); break;
                case "choiceTwo" :
                    location.setPlayerChoice(choiceTwo); break;
                case "choiceThree" :
                    location.setPlayerChoice(choiceThree); break;
                case "choiceFour" :
                    location.setPlayerChoice(choiceFour); break;
            }
        }
    }
}