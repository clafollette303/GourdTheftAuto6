public class StartMenu implements StoryLocation
{
    private Game game;

    public StartMenu(Game game)
    {
        this.game = game;
    }

    public void setPlayerChoice(String playerChoice)
    {
        switch(playerChoice)
        {
            case "Start" : startGame(); break;
        }
    }

    public void startGame()
    {
        game.startMenu.deleteTitleScreen();
        game.playerHouseUI.createUI();

        game.playerHouseUI.setMainTextArea("Rockstar Games isn't going to release GTA 6 anytime soon, so we took matters into our own hands.\n\n" +
                                           "In this iteration, you are a citizen in the capital city of Gourdia.\n\nCorruption runs deep, unemployment is at an all-time high, " +
                                           "and depression rates are through the roof.\n\n" +
                                           "Those in power will do all they can to prevent those in love from finding their soulmate, and so it is up to you to defy the " +
                                           "leaders of this cruel city and find your soulmate.");

        game.playerHouseUI.setLocationText("Capital City of Gourdia.");

        game.playerHouseUI.setContinueState();

        game.choiceOne = "Begin Journey";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }
}

