public class FinalLocation implements StoryLocation
{
    private Game game;

    public FinalLocation(Game game)
    {
        this.game = game;
    }

    public void setPlayerChoice(String playerChoice)
    {
        switch(playerChoice)
        {
            //***************************************
            //these all lead to ending two
            case "Music stops." : musicStops(); break;
            case "Propose to them." : proposeToThem(); break;
            case "Ghosted" : ghosted(); break;
            //---------------------------------------
            //continuation to true ending
            case "Take date home." : takeDateHome(); break;
            case "Date is at your place." : dateIsAtYourPlace(); break;
            case "Smooch time!" : smoochTime(); break;
            //---------------------------------------
            case "Ending one." : endingOne(); break;
            case "Ending two." : endingTwo(); break;
            case "Ending three." : endingThree(); break;
            case "Ending four." : endingFour(); break;
            case "Ending five." : endingFive(); break;
            //---------------------------------------
            case "Exit game." : game.endGame(); break;
            //***************************************
        }
    }

    //only plays when you ask to stop the music
    public void musicStops()
    {
        game.finalLocationUI.setLocationText("Loser much?");

        game.finalLocationUI.setMainTextArea("The DJ cuts the beat and everyone in the bar turns towards you.\n\n" +
                "How lame do you have to be to ask a DJ to turn off the music? \n\nA group of club-goers, including " +
                "your date, throw you out of the building. You did deserve it. \n\nBut really, what is your problem? ");

        game.finalLocationUI.setContinueState();

        game.choiceOne = "Ending two.";
    }

    //an epic fail
    public void proposeToThem()
    {
        game.finalLocationUI.setLocationText("What is wrong with you?");

        game.finalLocationUI.setMainTextArea("All this adrenaline got you too excited because before you realized, " +
                "you went to the stage, and through the mic, asked everyone for their silence and attention. \n\n" +
                "You then proceeded to do the most embarrassing thing anyone has ever done. \n\nYou called out your " +
                "date and popped the question. \n\nYour poor date, after only knowing you for an hour, was so " +
                "shocked they ran out of the building. Their face was as red as a tomato. This was not your best move.");

        game.finalLocationUI.setContinueState();

        game.choiceOne = "Ending two.";
    }

    public void ghosted()
    {
        game.finalLocationUI.setLocationText("Alone");

        game.finalLocationUI.setMainTextArea("Your date didn't seem to be enjoying themselves. They went to the " +
                "bathroom and they've been in there for a while now. 2 hours and 3 minutes, to be exact.\n\nI'm going" +
                " to give you a big hint and tell you they actually never went to the bathroom and just walked out " +
                "the door a while ago.\n\n2 hours ago, to be exact.");

        game.finalLocationUI.setContinueState();

        game.choiceOne = "Ending two.";
    }

    public void takeDateHome()
    {
        game.finalLocationUI.setLocationText("Back at the house ;)");

        game.finalLocationUI.setMainTextArea("Your date agreed to go back to your place, lucky you."); //sexee time

        if(!PlayerHouse.isKitchenExplored)
        {
            game.finalLocationUI.setContinueState();
            game.choiceOne = "Ending one.";
        }
        else
        {
            game.finalLocationUI.setContinueState();
            game.choiceOne = "Date is at your place.";
        }
    }

    //we can expand this further, but I thought this would be a good spot
    //for the player to wake up from the dream
    public void dateIsAtYourPlace()
    {
        game.finalLocationUI.setLocationText("Under the moonlight.");

        game.finalLocationUI.setMainTextArea("After such a great night, why should the fun stop?\n\nYou guys are " +
                "sitting on your porch swing listening to the calm night enjoying the scenery.");

        game.finalLocationUI.setButtonOneText("Smooch time! (consensually ofc)");
        game.finalLocationUI.setButtonTwoText("");
        game.finalLocationUI.setButtonThreeText("");
        game.finalLocationUI.setButtonFourText("");

        game.choiceOne = "Ending five.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    public void smoochTime()
    {
        //if brushed teeth or chewing gum -> smooch is successful
        //else -> date straight up gags & leaves
    }

    //house burned down ending
    public void endingOne()
    {
        game.finalLocationUI.setLocationText("What's left of your house.");

        game.finalLocationUI.setMainTextArea(GameEnding.ENDING_ONE.getDescription() +
                                             "\n\nEnding " + GameEnding.ENDING_ONE.getEndingNum() + " of " + GameEnding.values().length);

        game.finalLocationUI.setButtonOneText("Exit Game");
        game.finalLocationUI.setButtonTwoText("");
        game.finalLocationUI.setButtonThreeText("");
        game.finalLocationUI.setButtonFourText("");

        game.choiceOne = "Exit game.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    //player fails date ending
    public void endingTwo()
    {
        game.finalLocationUI.setLocationText("Being a complete and total loser.");

        game.finalLocationUI.setMainTextArea(GameEnding.ENDING_TWO.getDescription() +
                "\n\nEnding " + GameEnding.ENDING_TWO.getEndingNum() + " of " + GameEnding.values().length);

        game.finalLocationUI.setButtonOneText("Exit Game");
        game.finalLocationUI.setButtonTwoText("");
        game.finalLocationUI.setButtonThreeText("");
        game.finalLocationUI.setButtonFourText("");

        game.choiceOne = "Exit game.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    //Tengen Uzui Ending
    public void endingThree()
    {
        game.finalLocationUI.setLocationText("Tengen Uzui Mode");

        game.finalLocationUI.setMainTextArea(GameEnding.ENDING_THREE.getDescription() +
                "\n\nEnding " + GameEnding.ENDING_THREE.getEndingNum() + " of " + GameEnding.values().length);

        game.finalLocationUI.setButtonOneText("Exit Game");
        game.finalLocationUI.setButtonTwoText("");
        game.finalLocationUI.setButtonThreeText("");
        game.finalLocationUI.setButtonFourText("");

        game.choiceOne = "Exit game.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    public void endingFour()
    {
        game.finalLocationUI.setLocationText("Mentally Recovering");

        game.finalLocationUI.setMainTextArea(GameEnding.ENDING_FOUR.getDescription() +
                "\n\nEnding " + GameEnding.ENDING_FOUR.getEndingNum() + " of " + GameEnding.values().length);

        game.finalLocationUI.setButtonOneText("Exit Game");
        game.finalLocationUI.setButtonTwoText("");
        game.finalLocationUI.setButtonThreeText("");
        game.finalLocationUI.setButtonFourText("");

        game.choiceOne = "Exit game.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    //true ending
    public void endingFive()
    {
        game.finalLocationUI.setLocationText("CSCI 1260");

        game.finalLocationUI.setMainTextArea(GameEnding.ENDING_FIVE.getDescription() +
                "\n\nEnding " + GameEnding.ENDING_FIVE.getEndingNum() + " of " + GameEnding.values().length);

        game.finalLocationUI.setButtonOneText("Exit Game");
        game.finalLocationUI.setButtonTwoText("");
        game.finalLocationUI.setButtonThreeText("");
        game.finalLocationUI.setButtonFourText("");

        game.choiceOne = "Exit game.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    /*final part of true ending ideas:
        - ed hal is secretly date in disguise
        - it was a daydream & wake up in 1260
        - hall mentions something about or in the dream letting player wonder if it was real or not
     */
}