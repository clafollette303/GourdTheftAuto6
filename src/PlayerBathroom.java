public class PlayerBathroom implements StoryLocation
{
    private Game game;

    public static boolean hasGourd, faceWashed, teethBrushed;

    public PlayerBathroom(Game game)
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
            case "Check medicine cabinet." : checkMedicineCabinet();  break;
            case "Wash face." : washFace();  break;
            case "Brush teeth." : brushTeeth();  break;
            case "Leave bathroom." : leaveBathroom();  break;
            //----------------------------------------
            case "Bathroom." : bathroomMenu(); break;
            //**************************************
        }
    }

    public void bathroomMenu()
    {
        if(hasGourd && faceWashed && teethBrushed)
        {
            game.playerBathroomUI.setMainTextArea("You've done all there is to do in the bathroom.");

            game.playerBathroomUI.setLocationText("Bathroom.");

            game.playerBathroomUI.setContinueState();

            game.choiceOne = "Leave bathroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
        else
        {
            game.playerBathroomUI.setMainTextArea("You are still in your bathroom, what next?");

            game.playerBathroomUI.setLocationText("Bathroom.");

            game.playerBathroomUI.setButtonOneText("Search your medicine cabinet.");
            game.playerBathroomUI.setButtonTwoText("Wash your face.");
            game.playerBathroomUI.setButtonThreeText("Brush your teeth.");
            game.playerBathroomUI.setButtonFourText("Leave bathroom.");

            game.choiceOne = "Check medicine cabinet.";
            game.choiceTwo = "Wash face.";
            game.choiceThree = "Brush teeth.";
            game.choiceFour = "Leave bathroom.";
        }
    }

    public void checkMedicineCabinet()
    {
        if(!hasGourd)
        {
            game.playerBathroomUI.setMainTextArea("You open your medicine cabinet and find a gourd labeled \"psychedelic\".\n\nYou slip it into your pocket for later.");

            game.playerBathroomUI.setLocationText("Bathroom.");

            game.playerBathroomUI.setContinueState();

            game.choiceOne = "Bathroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";

            hasGourd = true;
        }
        else
        {
            game.playerBathroomUI.setMainTextArea("You've already looked inside the drawers.");

            game.playerBathroomUI.setLocationText("Bathroom.");

            game.playerBathroomUI.setContinueState();

            game.choiceOne = "Bathroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void washFace()
    {
        if(!faceWashed)
        {
            game.playerBathroomUI.setMainTextArea("You manage to scrub off most of the dirt on your face.");

            game.playerBathroomUI.setLocationText("Bathroom.");

            game.playerBathroomUI.setContinueState();

            game.choiceOne = "Bathroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";

            faceWashed = true;
        }
        else
        {
            game.playerBathroomUI.setMainTextArea("You washed your face already. I know it hurts to be that ugly, but soap and water isn't going to fix it.");

            game.playerBathroomUI.setLocationText("Bathroom.");

            game.playerBathroomUI.setContinueState();

            game.choiceOne = "Bathroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void brushTeeth()
    {
        if(!teethBrushed)
        {
            game.playerBathroomUI.setMainTextArea("You brush your teeth, and now your breath smells nice.");

            game.playerBathroomUI.setLocationText("Bathroom.");

            game.playerBathroomUI.setContinueState();

            game.choiceOne = "Bathroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";

            teethBrushed = true;
        }
        else
        {
            game.playerBathroomUI.setMainTextArea("You already brushed your teeth once.");

            game.playerBathroomUI.setLocationText("Bathroom.");

            game.playerBathroomUI.setContinueState();

            game.choiceOne = "Bathroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void leaveBathroom()
    {
        game.playerBathroomUI.deleteUI();
        game.playerHouseUI.createUI();

        if(PlayerHouse.isBedroomExplored && PlayerHouse.isBathroomExplored && PlayerHouse.isKitchenExplored)
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
}

