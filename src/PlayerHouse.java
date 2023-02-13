public class PlayerHouse implements StoryLocation
{
    private Game game;

    public static boolean didSleep, isBathroomExplored, isBedroomExplored, isKitchenExplored;

    public PlayerHouse(Game game)
    {
        this.game = game;
    }

    public void setPlayerChoice(String playerChoice)
    {
        switch(playerChoice)
        {
            //** - separates rooms
            //-- - separates decisions within rooms

            //**************************************
            case "Begin Journey" : beginJourney(); break;
            case "Explore house.": explorePlayerHouse(); break;
            case "Go to sleep.": sleep(); break;
            case "Talk to dad." : talkToDad(); break;
            case "Leave house without exploring.": leaveHouseUnprepared(); break;
            case "House.": houseMenu(); break;
            //----------------------------------------
            case "Explore bedroom.": exploreBedroom(); break;
            case "Explore bathroom.": exploreBathroom(); break;
            case "Explore kitchen.": exploreKitchen(); break;
            //-----------------------------------------
            case "Leave house.": leaveHouse(); break;
            //***************************************
        }
    }

    public void beginJourney()
    {
        game.playerHouseUI.setMainTextArea("Your pursuit of love begins inside your home.\n\nYou've got a date planned with a match you found on space tinder.\n\n" +
                                           "Before you leave, what would you like to do to prepare?");

        game.playerHouseUI.setLocationText("Your house.");

        game.playerHouseUI.setButtonOneText("Explore your house.");
        game.playerHouseUI.setButtonTwoText("Go to sleep.");
        game.playerHouseUI.setButtonThreeText("Ask your dad for advice.");
        game.playerHouseUI.setButtonFourText("Leave house.");

        game.choiceOne = "Explore house.";
        game.choiceTwo = "Go to sleep.";
        game.choiceThree = "Talk to dad.";
        game.choiceFour = "Leave house without exploring.";
    }

    public void houseMenu()
    {
        game.playerHouseUI.setMainTextArea("You are in your living room, what do you want to do next?");

        game.playerHouseUI.setLocationText("Your house.");

        game.playerHouseUI.setButtonOneText("Explore other rooms of house.");
        game.playerHouseUI.setButtonTwoText("Go to sleep.");
        game.playerHouseUI.setButtonThreeText("Leave house.");
        game.playerHouseUI.setButtonFourText("");

        game.choiceOne = "Explore house.";
        game.choiceTwo = "Go to sleep.";
        game.choiceThree = "Leave house without exploring.";
        game.choiceFour = "";
    }

    public void explorePlayerHouse()
    {
        if(isBedroomExplored && isBathroomExplored && isKitchenExplored)
        {
            game.playerHouseUI.setMainTextArea("You've explored your entire house. Good work.\n\n" +
                                               "Get ready to experience the best modern-AAA-open world-text based-turn based-strategy-rpg-rogue like game to come out this year.\n\n" +
                                               "Welcome to GTA 6.");

            game.playerHouseUI.setLocationText("Outside the shack you call a house.");

            game.playerHouseUI.setContinueState();

            game.choiceOne = "Leave house.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
        else
        {
            game.playerHouseUI.setMainTextArea("You are in your house, what room do you want to explore?");

            game.playerHouseUI.setLocationText("Your house.");

            game.playerHouseUI.setButtonOneText("Explore bedroom.");
            game.playerHouseUI.setButtonTwoText("Explore bathroom.");
            game.playerHouseUI.setButtonThreeText("Explore kitchen.");
            game.playerHouseUI.setButtonFourText("Leave house.");

            game.choiceOne = "Explore bedroom.";
            game.choiceTwo = "Explore bathroom.";
            game.choiceThree = "Explore kitchen.";
            game.choiceFour = "Leave house without exploring.";
        }
    }

    public void exploreBedroom()
    {
        if(!isBedroomExplored)
        {
            game.playerHouseUI.deleteUI();
            game.playerBedroomUI.createUI();

            game.playerBedroomUI.setMainTextArea("Jesus christ, how do you live like this? This might be the nastiest room I've ever seen.\n\n" +
                                                 "Your trash hasn't been taken out in weeks, there are used gourd-wrappers everywhere, and worst of all, you left Stack Overflow open on your laptop.\n\n" +
                                                 "You seriously forgot how to write an if-statement?");

            game.playerBedroomUI.setLocationText("Bedroom.");

            game.playerBedroomUI.setButtonOneText("Close laptop.");
            game.playerBedroomUI.setButtonTwoText("Search your nightstand.");
            game.playerBedroomUI.setButtonThreeText("Pet your cat.");
            game.playerBedroomUI.setButtonFourText("Leave bedroom.");

            game.choiceOne = "Close laptop.";
            game.choiceTwo = "Search nightstand.";
            game.choiceThree = "Pet cat.";
            game.choiceFour = "Leave bedroom.";

            isBedroomExplored = true;
        }
        else
        {
            game.playerHouseUI.setMainTextArea("You barely managed to escape that hell-hole you call a room.\n\nYou don't wanna go back in, trust me.");

            game.playerHouseUI.setContinueState();

            game.choiceOne = "Explore house.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void exploreBathroom()
    {
        if(!isBathroomExplored)
        {
            game.playerHouseUI.deleteUI();
            game.playerBathroomUI.createUI();

            game.playerBathroomUI.setMainTextArea("Your bathroom is disgust- oh never mind, you actually keep this clean.\n\n" +
                                                  "Might wanna get a new shower curtain, though.");

            game.playerBathroomUI.setLocationText("Bathroom.");

            game.playerBathroomUI.setButtonOneText("Search your medicine cabinet.");
            game.playerBathroomUI.setButtonTwoText("Wash your face.");
            game.playerBathroomUI.setButtonThreeText("Brush your teeth.");
            game.playerBathroomUI.setButtonFourText("Leave bathroom.");

            game.choiceOne = "Check medicine cabinet.";
            game.choiceTwo = "Wash face.";
            game.choiceThree = "Brush teeth.";
            game.choiceFour = "Leave bathroom.";

            isBathroomExplored = true;
        }
        else
        {
            game.playerHouseUI.setMainTextArea("You already went in there. What, need to take a dump or something?");

            game.playerHouseUI.setContinueState();

            game.choiceOne = "Explore house.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void exploreKitchen()
    {
        //if player doesn't explore kitchen, house will burn down.
        if (!isKitchenExplored)
        {
            game.playerHouseUI.setMainTextArea("You step into your kitchen, and oh - looks like your oven is still on.\n\nMight wanna turn that off.\n\n" +
                                               "You can save that massive pile of dishes for later.");

            game.playerHouseUI.setLocationText("Kitchen.");

            game.playerHouseUI.setContinueState();

            game.choiceOne = "Explore house.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";

            isKitchenExplored = true;
        }
        else
        {
            game.playerHouseUI.setMainTextArea("Why do you wanna go back there? Gonna turn the oven back on?");

            game.playerHouseUI.setContinueState();

            game.choiceOne = "Explore house.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void sleep()
    {
        if(!didSleep)
        {
            game.playerHouseUI.setMainTextArea("Yea, go take a nap to find your soul mate, that will work.\n\nCome back when you are ready to talk business.");

            game.playerHouseUI.setContinueState();

            game.choiceOne = "House.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";

            didSleep = true;
        }
        else
        {
            game.playerHouseUI.setMainTextArea("You already took a nap. This isn't kindergarten class.");

            game.playerHouseUI.setContinueState();

            game.choiceOne = "House.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void leaveHouseUnprepared()
    {
        game.playerHouseUI.setMainTextArea("Are you sure you want to leave without exploring every room?");

        game.playerHouseUI.setButtonOneText("Yes, leave.");
        game.playerHouseUI.setButtonTwoText("Actually, go back.");
        game.playerHouseUI.setButtonThreeText("");
        game.playerHouseUI.setButtonFourText("");

        game.choiceOne = "Leave house.";
        game.choiceTwo = "Explore house.";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    public void talkToDad()
    {
        game.playerHouseUI.setMainTextArea("\"Son, do you have protection? Herpes is for life, you know.\"");

        game.playerHouseUI.setButtonOneText("Thank your dad for the wonderful advice.");
        game.playerHouseUI.setButtonTwoText("");
        game.playerHouseUI.setButtonThreeText("");
        game.playerHouseUI.setButtonFourText("");

        game.choiceOne = "House.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    public void leaveHouse()
    {
        game.playerHouseUI.deleteUI();
        game.spaceTrainUI.createUI();

        game.spaceTrainUI.setMainTextArea("You leave your desolate shack of a house in pursuit of your space tinder match.\n\n" +
                "You head to the gourd-speed train that will take you to the location of your date.\n\n" +
                "You need find a seat before you are left behind.");

        game.spaceTrainUI.setLocationText("Approaching the Gourd-Speed Train Station.");

        game.spaceTrainUI.setContinueState();

        game.choiceOne = "Move to train station.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }
}
