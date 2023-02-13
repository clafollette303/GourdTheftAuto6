public class SpaceTrain implements StoryLocation
{
    private Game game;
    private int trainLoop = 0;

    public static boolean didGiveUpSeat;

    public SpaceTrain(Game game)
    {
        this.game = game;
    }

    public void setPlayerChoice(String playerChoice)
    {
        switch(playerChoice)
        {
            //** - separates rooms
            //-- - separates decisions within rooms

            //***************************************
            case "Move to train station." : trainStation(); break;
            case "Start Train." : startTrain(); break;
            case "Cubby One." : cubbyOne(); break;
            case "Move To Cubby Two." : moveToCubbyTwo(); break;
            case "Cubby Two." : cubbyTwo(); break;
            case "Move To Cubby Three." : moveToCubbyThree(); break;
            case "Cubby Three." : cubbyThree(); break;
            //---------------------------------------
            case "Give Up Seat." : giveUpSeat(); break;
            case "Tell Him To Get Lost." : getLost(); break;
            case "Let Man Sit." : letManSit(); break;
            case "Tell Him To Get Lost Two." : getLostTwo(); break;
            case "Gourd Trip." : gourdTrip(); break;
            case "End Gourd Trip." : endGourdTrip(); break;
            //---------------------------------------
            case "Arrive." : arriveAtSpaceBar(); break;
            //****************************************
        }
    }

    public void trainStation()
    {
        game.spaceTrainUI.setMainTextArea("As you wait in line to buy your train ticket, you think that it might have been faster to walk.\n\n" +
                                          "How fast does a \"gourd-speed\" train go, anyways?\n\n" +
                                          "Oh well, doesn't matter now, you're next in line.");

        game.spaceTrainUI.setLocationText("Standing in line.");

        game.spaceTrainUI.setButtonOneText("Buy ticket and get on the train.");
        game.spaceTrainUI.setButtonTwoText("");
        game.spaceTrainUI.setButtonThreeText("");
        game.spaceTrainUI.setButtonFourText("");

        game.choiceOne = "Start Train.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    public void startTrain()
    {
        if(!didGiveUpSeat && trainLoop < 3)
        {
            game.spaceTrainUI.setMainTextArea("The first train car is almost completely full, but there is one spot left.\n\n" +
                    "You can sit here, or move to a more available section.");

            game.spaceTrainUI.setLocationText("Exploring Train Car 1.");

            game.spaceTrainUI.setButtonOneText("Sit here.");
            game.spaceTrainUI.setButtonTwoText("Move to the next train car.");
            game.spaceTrainUI.setButtonThreeText("");
            game.spaceTrainUI.setButtonFourText("");

            game.choiceOne = "Cubby One.";
            game.choiceTwo = "Move To Cubby Two.";
            game.choiceThree = "";
            game.choiceFour = "";
        }
        else if(trainLoop < 3)
        {
            game.spaceTrainUI.setMainTextArea("Since you gave up your seat, the first train car is no longer an option.\n\n" +
                    "What will you do now?");

            game.spaceTrainUI.setLocationText("Struggling to find a seat.");

            game.spaceTrainUI.setButtonOneText("Sit in the second train car.");
            game.spaceTrainUI.setButtonTwoText("Move to the next train car.");
            game.spaceTrainUI.setButtonThreeText("");
            game.spaceTrainUI.setButtonFourText("");

            game.choiceOne = "Cubby Two.";
            game.choiceTwo = "Move To Cubby Three.";
            game.choiceThree = "";
            game.choiceFour = "";
        }
        else
        {
            game.spaceTrainUI.setMainTextArea("Come on man, we don't have all day. Pick a seat so we can get moving.");

            game.spaceTrainUI.setLocationText("Not picking a seat.");

            game.spaceTrainUI.setButtonOneText("Sit here.");
            game.spaceTrainUI.setButtonTwoText("Move to the next train car.");
            game.spaceTrainUI.setButtonThreeText("");
            game.spaceTrainUI.setButtonFourText("");

            game.choiceOne = "Cubby One.";
            game.choiceTwo = "Move To Cubby Two.";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void cubbyOne()
    {
        game.spaceTrainUI.setMainTextArea("You squish yourself in between two people into the last available seat.\n\n" +
                "A tough-looking fellow approaches you asks if he can have your seat.\n\nHow do you want to respond?");

        game.spaceTrainUI.setLocationText("Sitting in Train Car 1.");

        game.spaceTrainUI.setButtonOneText("Give up your seat.");
        game.spaceTrainUI.setButtonTwoText("Tell him to get lost.");
        game.spaceTrainUI.setButtonThreeText("");
        game.spaceTrainUI.setButtonFourText("");

        game.choiceOne = "Give Up Seat.";
        game.choiceTwo = "Tell Him To Get Lost.";
        game.choiceThree = "";
        game.choiceFour = "";
    }
    public void giveUpSeat()
    {
        game.spaceTrainUI.setMainTextArea("Wow, you really gave up that easy? This journey won't last long.\n\n" +
                "Looks like you'll have to find another seat.");

        game.spaceTrainUI.setLocationText("Standing in Train Car 1.");

        game.spaceTrainUI.setButtonOneText("Move to the next train car.");
        game.spaceTrainUI.setButtonTwoText("");
        game.spaceTrainUI.setButtonThreeText("");
        game.spaceTrainUI.setButtonFourText("");

        game.choiceOne = "Move To Cubby Two.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";

        didGiveUpSeat = true;
    }
    public void getLost()
    {
        game.spaceTrainUI.setMainTextArea("Turns out, that guy wasn't tough at all.\n\nTelling him to get lost was all it took for him to burst into tears.\n\n" +
                "You've secured your seat in the first train car, and spend the entire train ride smushed between two strangers.");

        game.spaceTrainUI.setLocationText("Sitting in Train Car 1.");

        game.spaceTrainUI.setButtonOneText("Wait to arrive.");
        game.spaceTrainUI.setButtonTwoText("");
        game.spaceTrainUI.setButtonThreeText("");
        game.spaceTrainUI.setButtonFourText("");

        game.choiceOne = "Arrive.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }
    public void moveToCubbyTwo()
    {
        game.spaceTrainUI.setMainTextArea("The second train car is less crowded, but it's not empty.\n\n" +
                "Everyone in here seems to be wearing a pin that says \"gourd activist\", whatever that means.");

        game.spaceTrainUI.setLocationText("Exploring Train Car 2.");

        game.spaceTrainUI.setButtonOneText("Sit here.");
        game.spaceTrainUI.setButtonTwoText("Move to the next train car.");
        game.spaceTrainUI.setButtonThreeText("");
        game.spaceTrainUI.setButtonFourText("");

        game.choiceOne = "Cubby Two.";
        game.choiceTwo = "Move To Cubby Three.";
        game.choiceThree = "";
        game.choiceFour = "";
    }
    public void cubbyTwo()
    {
        game.spaceTrainUI.setMainTextArea("You find a comfortable seat in the second train car. A strange man, presumably one of the gourd activists, sits next to you.");

        game.spaceTrainUI.setLocationText("Sitting in Train Car 2.");

        game.spaceTrainUI.setButtonOneText("Ask the man about \"gourd activism\".");
        game.spaceTrainUI.setButtonTwoText("Ignore the man and keep quiet.");
        game.spaceTrainUI.setButtonThreeText("");
        game.spaceTrainUI.setButtonFourText("");

        game.choiceOne = "Let Man Sit.";
        game.choiceTwo = "Tell Him To Get Lost Two.";
        game.choiceThree = "";
        game.choiceFour = "";
    }
    public void letManSit()
    {
        game.spaceTrainUI.setMainTextArea("You begin talking to the strange man, and he tells you his name is Gourdon. You point out the \"gourd activism\" pin on his shirt, " +
                " and ask him what gourd activism is.\n\nHe tells you that he doesn't even know, he's just in the club for the free pizza.\n\n" +
                "The two of you continue to chat for the rest of the train ride.");

        game.spaceTrainUI.setLocationText("Conversing with Gourdon in Train Car 2");

        game.spaceTrainUI.setContinueState();

        game.choiceOne = "Arrive.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }
    public void getLostTwo()
    {
        game.spaceTrainUI.setMainTextArea("You keep to yourself for the entire train ride. You are unable to determine the meaning of \"gourd activism\"," +
                " and you get a strange feeling that you missed on making a friend.\n\n" +
                "You continue the rest of your train ride trying to peek into the \"gourd activism\" discussions, trying to put a finger on what it might mean.");

        game.spaceTrainUI.setLocationText("Sitting in Train Car 2.");

        game.spaceTrainUI.setContinueState();

        game.choiceOne = "Arrive.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }
    public void moveToCubbyThree()
    {
        game.spaceTrainUI.setMainTextArea("The final train car is completely empty. You might be able to have some alone time in here.");

        game.spaceTrainUI.setLocationText("Exploring Train Car 3.");

        game.spaceTrainUI.setButtonOneText("Sit here.");
        game.spaceTrainUI.setButtonTwoText("Go back to the front of the train.");
        game.spaceTrainUI.setButtonThreeText("");
        game.spaceTrainUI.setButtonFourText("");

        game.choiceOne = "Cubby Three.";
        game.choiceTwo = "Start Train.";
        game.choiceThree = "";
        game.choiceFour = "";

        trainLoop++;
    }
    public void cubbyThree()
    {
        if(PlayerBathroom.hasGourd)
        {
            game.spaceTrainUI.setMainTextArea("There's no one to talk to in here. " +
                    "You feel a gourd-sized lump in your pocket, and feel an urge to take the psychedelic gourd you found earlier.");

            game.spaceTrainUI.setLocationText("Sitting in Train Car 3.");

            game.spaceTrainUI.setButtonOneText("Take psychedelic gourd.");
            game.spaceTrainUI.setButtonTwoText("Wait without taking it.");
            game.spaceTrainUI.setButtonThreeText("");
            game.spaceTrainUI.setButtonFourText("");

            game.choiceOne = "Gourd Trip.";
            game.choiceTwo = "Arrive.";
            game.choiceThree = "";
            game.choiceFour = "";
        }
        else
        {
            game.spaceTrainUI.setMainTextArea("You are completely alone without anything to do to pass the time. Looks like you're gonna have to stare out the window for a bit." +
                                              "\n\nMaybe you should have explored your house more.");

            game.spaceTrainUI.setLocationText("Sitting in Train Car 3.");

            game.spaceTrainUI.setButtonOneText("Wait to arrive.");
            game.spaceTrainUI.setButtonTwoText("");
            game.spaceTrainUI.setButtonThreeText("");
            game.spaceTrainUI.setButtonFourText("");

            game.choiceOne = "Arrive.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }
    public void gourdTrip()
    {
        game.spaceTrainUI.setLocationText("Somewhere in the Gourd Universe.");

        game.spaceTrainUI.setButtonOneText("End Gourd Trip.");
        game.spaceTrainUI.setButtonTwoText("");
        game.spaceTrainUI.setButtonThreeText("");
        game.spaceTrainUI.setButtonFourText("");

        game.spaceTrainUI.gourdTrip();

        game.choiceOne = "End Gourd Trip.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";

        PlayerBathroom.hasGourd = false;
    }

    public void endGourdTrip()
    {
        game.spaceTrainUI.endGourdTrip();

        game.spaceTrainUI.setMainTextArea("Well that was... interesting to say the least.\n\nBut the good news is that you've arrived at your next destination.");

        game.spaceTrainUI.setLocationText("Mentally Recovering");

        game.spaceTrainUI.setContinueState();

        game.choiceOne = "Arrive.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }
    public void arriveAtSpaceBar()
    {
        game.spaceTrainUI.deleteUI();
        game.funkySpaceBarUI.createUI();

        game.funkySpaceBarUI.setMainTextArea("You've arrived at the best known location for picking up chicks: the bar.\n\nThe DJ is playing gourd-themed dubstep so loudly that you can barely think.\n\n" +
                                             "What do you want to do first?");

        game.funkySpaceBarUI.setLocationText("The Bar");


        game.funkySpaceBarUI.setButtonOneText("Approach the bartender.");
        game.funkySpaceBarUI.setButtonTwoText("Ask the DJ to stop playing so loudly.");
        game.funkySpaceBarUI.setButtonThreeText("Try to find your date.");
        game.funkySpaceBarUI.setButtonFourText("Go dance your pants off.");

        game.choiceOne = "Approach bartender.";
        game.choiceTwo = "Talk to band.";
        game.choiceThree = "Search for date without help.";
        game.choiceFour = "Go dance.";
    }
}
