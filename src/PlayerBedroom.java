public class PlayerBedroom implements StoryLocation
{
    private Game game;

    public static boolean laptopClosed, nightStandSearched, catPet;

    public PlayerBedroom(Game game)
    {
        this.game = game;
    }

    public void setPlayerChoice(String playerChoice)
    {
        switch(playerChoice)
        {
            //**************************************
            case "Close laptop." : closeLaptop(); break;
            case "Search nightstand." : searchNightstand(); break;
            case "Pet cat." : petCat(); break;
            case "Leave bedroom." : leaveBedroom(); break;
            //----------------------------------------
            case "Bedroom." : bedroomMenu(); break;
            //**************************************
        }
    }

    public void bedroomMenu()
    {
        if(laptopClosed && nightStandSearched && catPet)
        {
            game.playerBedroomUI.setMainTextArea("You've done all you need to do in your bedroom for now.");

            game.playerBedroomUI.setLocationText("Bedroom.");

            game.playerBedroomUI.setContinueState();

            game.choiceOne = "Leave bedroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
        else
        {
            game.playerBedroomUI.setMainTextArea("You are still in your bedroom, what do you want to do next?");

            game.playerBedroomUI.setLocationText("Bedroom.");

            game.playerBedroomUI.setButtonOneText("Close laptop.");
            game.playerBedroomUI.setButtonTwoText("Search your nightstand.");
            game.playerBedroomUI.setButtonThreeText("Pet your cat.");
            game.playerBedroomUI.setButtonFourText("Leave bedroom.");

            game.choiceOne = "Close laptop.";
            game.choiceTwo = "Search nightstand.";
            game.choiceThree = "Pet cat.";
            game.choiceFour = "Leave bedroom.";
        }
    }

    public void closeLaptop()
    {
        if(!laptopClosed)
        {
            game.playerBedroomUI.setMainTextArea("You close your Stack Overflow tabs and shut your laptop.\n\n" +
                                                 "Programming might not be for you.");

            game.playerBedroomUI.setLocationText("Bedroom.");

            game.playerBedroomUI.setContinueState();

            game.choiceOne = "Bedroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";

            laptopClosed = true;
        }
        else
        {
            game.playerBedroomUI.setMainTextArea("Your laptop is already closed.");

            game.playerBedroomUI.setLocationText("Bedroom.");

            game.playerBedroomUI.setContinueState();

            game.choiceOne = "Bedroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void searchNightstand()
    {
        if(!nightStandSearched)
        {
            game.playerBedroomUI.setMainTextArea("You rummage through the drawers of your nightstand.\n\n" +
                                                 "You find a crumpled $20 bill, and put it into your wallet for later.");

            game.playerBedroomUI.setLocationText("Bedroom.");

            game.playerBedroomUI.setContinueState();

            game.choiceOne = "Bedroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";

            nightStandSearched = true;
        }
        else
        {
            game.playerBedroomUI.setMainTextArea("You've already searched your nightstand.");

            game.playerBedroomUI.setLocationText("Bedroom.");

            game.playerBedroomUI.setContinueState();

            game.choiceOne = "Bedroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void petCat()
    {
        if(!catPet)
        {
            game.playerBedroomUI.setMainTextArea("Your cat hisses at you as you try to pet him. Try taking better care of him.");

            game.playerBedroomUI.setLocationText("Bedroom.");

            game.playerBedroomUI.setContinueState();

            game.choiceOne = "Bedroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";

            catPet = true;
        }
        else
        {
            game.playerBedroomUI.setMainTextArea("If you try to pet him again, he's going to bite you.");

            game.playerBedroomUI.setLocationText("Bedroom.");

            game.playerBedroomUI.setContinueState();

            game.choiceOne = "Bedroom.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void leaveBedroom()
    {
        game.playerBedroomUI.deleteUI();
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
