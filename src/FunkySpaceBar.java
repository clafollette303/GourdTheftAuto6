public class FunkySpaceBar implements StoryLocation
{
    private Game game;

    private int drinksTaken = 0;
    public static boolean bartenderAsked, DJAsked;

    public FunkySpaceBar(Game game)
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
            case "Start of bar." : startOfBar(); break;
            //---------------------------------------
            case "Approach bartender." : approachBartender(); break;
            case "Talk to band." : talkToDJ(); break;
            //---------------------------------------
            case "Search for date without help." : searchForDateWithoutHelp(); break;
            case "Go dance." : goDance(); break;
            //---------------------------------------
            case "Take drink." : takeDrink(); break;
            case "Get bartender help." : getBartenderHelp(); break;
            //---------------------------------------
            case "Give bartender money." : giveBartenderMoney(); break;
            case "Give DJ gourd." : giveDJGourd(); break;
            case "Yell at band." : yellAtBand(); break;
            //---------------------------------------
            case "Date comes to dance." : dateComesToDance(); break;
            case "Bone town." : boneTown(); break;
            //---------------------------------------
            case "Search for date." : searchForDate(); break;
            //---------------------------------------
            case "Playing it cool." : playingItCool(); break;
            case "Swagger." : swagger(); break;
            case "Date is into you." : dateIsIntoYou(); break;
            //---------------------------------------
            case "Get jiggy with it." : toFinalLocation(0); break;
            case "These babes are my soulmates now." : toFinalLocation(1); break;
            case "Date failed." : toFinalLocation(2); break;
            case "Take date home." : toFinalLocation(3); break;
            case "Ghosted." : toFinalLocation(4); break;
            case "Propose to them." : toFinalLocation(5); break;
            //***************************************
        }
    }

    public void startOfBar()
    {
        if(!bartenderAsked && !DJAsked)
        {
            game.funkySpaceBarUI.setMainTextArea("You are back at the front of the bar.\n\nWhat do you want to do?");

            game.funkySpaceBarUI.setLocationText("The Bar");

            game.funkySpaceBarUI.setButtonOneText("Approach the bartender.");
            game.funkySpaceBarUI.setButtonTwoText("Approach the DJ.");
            game.funkySpaceBarUI.setButtonThreeText("Go dance your pants off.");
            game.funkySpaceBarUI.setButtonFourText("");

            game.choiceOne = "Approach bartender.";
            game.choiceTwo = "Talk to band.";
            game.choiceThree = "Go dance.";
            game.choiceFour = "";
        }
        else if(bartenderAsked && !DJAsked)
        {
            game.funkySpaceBarUI.setMainTextArea("You are back at the front of the bar.\n\nWhat do you want to do?");

            game.funkySpaceBarUI.setLocationText("The Bar");

            game.funkySpaceBarUI.setButtonOneText("Approach the DJ.");
            game.funkySpaceBarUI.setButtonTwoText("Go dance your pants off.");
            game.funkySpaceBarUI.setButtonThreeText("");
            game.funkySpaceBarUI.setButtonFourText("");

            game.choiceOne = "Talk to band.";
            game.choiceTwo = "Go dance.";
            game.choiceThree = "";
            game.choiceFour = "";
        }
        else if(!bartenderAsked && DJAsked)
        {
            game.funkySpaceBarUI.setMainTextArea("You are back at the front of the bar.\n\nWhat do you want to do?");

            game.funkySpaceBarUI.setLocationText("The Bar");

            game.funkySpaceBarUI.setButtonOneText("Approach the bartender.");
            game.funkySpaceBarUI.setButtonTwoText("Go dance your pants off.");
            game.funkySpaceBarUI.setButtonThreeText("");
            game.funkySpaceBarUI.setButtonFourText("");

            game.choiceOne = "Approach bartender.";
            game.choiceTwo = "Go dance.";
            game.choiceThree = "";
            game.choiceFour = "";
        }
        else
        {
            game.funkySpaceBarUI.setMainTextArea("You've tried asking for help and you've gotten nowhere.\n\nNow you've only got one thing left to do: dance.");

            game.funkySpaceBarUI.setLocationText("The Bar");

            game.funkySpaceBarUI.setButtonOneText("Go dance your pants off.");
            game.funkySpaceBarUI.setButtonTwoText("");
            game.funkySpaceBarUI.setButtonThreeText("");
            game.funkySpaceBarUI.setButtonFourText("");

            game.choiceOne = "Go dance.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void approachBartender()
    {
        game.funkySpaceBarUI.setMainTextArea("You sit at the bar next to a tired and weary professor, looming over a" +
                " large pile of half graded papers.\n\n" +
                "You manage to grab the bartender's attention.\n\n" +
                "The bartender approaches you and says:\n\n" + "\"Can I get you something to drink?\"" + "\n\n" +
                "How do you respond?");

        game.funkySpaceBarUI.setLocationText("The Bar");

        game.funkySpaceBarUI.setButtonOneText("\"Sure I'll have a drink.\"");
        game.funkySpaceBarUI.setButtonTwoText("\"Actually, I was wondering if you'd seen someone who looks like this picture.\"");
        game.funkySpaceBarUI.setButtonThreeText("");
        game.funkySpaceBarUI.setButtonFourText("");

        game.choiceOne = "Take drink.";
        game.choiceTwo = "Get bartender help.";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    public void talkToDJ()
    {
        game.funkySpaceBarUI.setMainTextArea("You approach the DJ, who's wearing a gourd as a helmet.\n\nHow do you want to get his attention?");

        game.funkySpaceBarUI.setLocationText("Stage");

        if(PlayerBathroom.hasGourd)
        {
            game.funkySpaceBarUI.setButtonOneText("*Offer DJ the psychedelic gourd.*");
            game.funkySpaceBarUI.setButtonTwoText("");
            game.funkySpaceBarUI.setButtonThreeText("");
            game.funkySpaceBarUI.setButtonFourText("");

            game.choiceOne = "Give DJ gourd.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
        else
        {
            game.funkySpaceBarUI.setButtonOneText("\"COULD YOU PLEASE TURN THAT DOWN?\"");
            game.funkySpaceBarUI.setButtonTwoText("");
            game.funkySpaceBarUI.setButtonThreeText("");
            game.funkySpaceBarUI.setButtonFourText("");

            game.choiceOne = "Yell at band.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void searchForDateWithoutHelp()
    {
        game.funkySpaceBarUI.setMainTextArea("The loud music is making you lose your ability to think, and you" +
                " have no clue where your date might be.\n\n" +
                "It might be a good idea to ask for help first.");

        game.funkySpaceBarUI.setLocationText("Totally Lost");

        game.funkySpaceBarUI.setContinueState();

        game.choiceOne = "Start of bar.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    public void goDance()
    {
        game.funkySpaceBarUI.setMainTextArea("The DJ notices your impressive display of dance moves, and gives you " +
                "the opportunity to choose the next song.");

        game.funkySpaceBarUI.setLocationText("Dance floor");

        game.funkySpaceBarUI.setButtonOneText("Ask DJ to play the song mentioned in your space-tinder date's profile.");
        game.funkySpaceBarUI.setButtonTwoText("Ask DJ to play \"Baby\" by Justin Bieber.");
        game.funkySpaceBarUI.setButtonThreeText("");
        game.funkySpaceBarUI.setButtonFourText("");

        game.choiceOne = "Date comes to dance.";
        game.choiceTwo = "Bone town.";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    public void dateComesToDance()
    {
        game.funkySpaceBarUI.setLocationText("Dance floor with your hot date");

        game.funkySpaceBarUI.setMainTextArea("You sly son of a gourd. Like a mating call, this song brought your " +
                "date directly to you.\n\nIt doesn't take long for you both to get the chemistry flowing with " +
                "your sick moves.");

        game.funkySpaceBarUI.setContinueState();

        game.choiceOne = "Date is into you.";
    }

    public void takeDrink()
    {
        //add 1 to drinks taken in beginning instead of the end
        drinksTaken++;
        if(drinksTaken >= 4)
        {
            game.funkySpaceBarUI.setMainTextArea("You managed to drink so much that you blacked out.\n\nYou don't " +
                    "remember much of what happened, but you check your phone " +
                    "and see a message from your date saying, \"It's over.\"\n\nGreat job.");

            game.funkySpaceBarUI.setLocationText("In the back of an alley soaked in your own bodily fluids.");

            game.funkySpaceBarUI.setButtonOneText("Accept your defeat and go home.");
            game.funkySpaceBarUI.setButtonTwoText("");
            game.funkySpaceBarUI.setButtonThreeText("");
            game.funkySpaceBarUI.setButtonFourText("");

            game.choiceOne = "Date failed.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
        else
        {
            game.funkySpaceBarUI.setMainTextArea("You take drink number " + drinksTaken + "." + "\n\nWhat do you want " +
                    "to say to the bartender now?");

            game.funkySpaceBarUI.setLocationText("Drinking your life away.");

            game.funkySpaceBarUI.setButtonOneText("\"Give me another.\"");
            game.funkySpaceBarUI.setButtonTwoText("\"I was wondering if you'd seen someone who looks like this picture.\"");
            game.funkySpaceBarUI.setButtonThreeText("");
            game.funkySpaceBarUI.setButtonFourText("");

            game.choiceOne = "Take drink.";
            game.choiceTwo = "Get bartender help.";
            game.choiceThree = "";
            game.choiceFour = "";
        }
    }

    public void getBartenderHelp()
    {
        if(PlayerBedroom.nightStandSearched)
        {
            game.funkySpaceBarUI.setMainTextArea("\"No, I haven't seen anyone like that.\"");

            game.funkySpaceBarUI.setLocationText("The Bar");

            game.funkySpaceBarUI.setButtonOneText("*Bribe the bartender with your crumpled $20 bill.*");
            game.funkySpaceBarUI.setButtonTwoText("");
            game.funkySpaceBarUI.setButtonThreeText("");
            game.funkySpaceBarUI.setButtonFourText("");

            game.choiceOne = "Give bartender money.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";
        }
        else
        {
            game.funkySpaceBarUI.setMainTextArea("\"No, I haven't seen anyone like that.\"");

            game.funkySpaceBarUI.setLocationText("The Bar");

            game.funkySpaceBarUI.setButtonOneText("\"Alright, well thanks anyways.\"");
            game.funkySpaceBarUI.setButtonTwoText("");
            game.funkySpaceBarUI.setButtonThreeText("");
            game.funkySpaceBarUI.setButtonFourText("");

            game.choiceOne = "Start of bar.";
            game.choiceTwo = "";
            game.choiceThree = "";
            game.choiceFour = "";

            bartenderAsked = true;
        }
    }

    public void giveBartenderMoney()
    {
        game.funkySpaceBarUI.setMainTextArea("\"Now that you mention it, I did see someone who looked like that sitting in the back.\"");

        game.funkySpaceBarUI.setLocationText("The Bar");

        game.funkySpaceBarUI.setButtonOneText("Thank the bartender and search for your date.");
        game.funkySpaceBarUI.setButtonTwoText("");
        game.funkySpaceBarUI.setButtonThreeText("");
        game.funkySpaceBarUI.setButtonFourText("");

        game.choiceOne = "Search for date.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    public void giveDJGourd()
    {
        game.funkySpaceBarUI.setMainTextArea("The DJ accepts your psychedelic gourd, but he refuses to turn down " +
                "the music.\n\n"+
                "He does tell you that someone looking for a person that looks like you " +
                "is sitting at the back of the bar.");

        game.funkySpaceBarUI.setLocationText("Stage");

        game.funkySpaceBarUI.setContinueState();

        game.choiceOne = "Search for date.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    public void yellAtBand()
    {
        game.funkySpaceBarUI.setMainTextArea("The DJ gives you a weird glare. Who goes to a bar and asks the DJ " +
                "to turn the music down?\n\nThe whole point is to leave half deaf anyway.\n\nClearly that didn't " +
                "work. What else is there to do?");

        game.funkySpaceBarUI.setLocationText("Stage");

        game.funkySpaceBarUI.setButtonOneText("Go back to the front of the bar.");
        game.funkySpaceBarUI.setButtonTwoText("");
        game.funkySpaceBarUI.setButtonThreeText("");
        game.funkySpaceBarUI.setButtonFourText("");

        game.choiceOne = "Start of bar.";
        game.choiceTwo = "";
        game.choiceThree = "";
        game.choiceFour = "";

        DJAsked = true;
    }

    public void searchForDate()
    {
        game.funkySpaceBarUI.setMainTextArea("You move to the back of the bar where the music is a bit quieter." +
                "\n\nYou notice your date sitting by themselves.");

        game.funkySpaceBarUI.setLocationText("Back of the Bar");

        game.funkySpaceBarUI.setButtonOneText("Approach date casually.");
        game.funkySpaceBarUI.setButtonTwoText("Approach date with machismo.");
        game.funkySpaceBarUI.setButtonThreeText("Chicken out and go home.");
        game.funkySpaceBarUI.setButtonFourText("");

        game.choiceOne = "Playing it cool.";
        game.choiceTwo = "Swagger.";
        game.choiceThree = "Date failed.";
        game.choiceFour = "";
    }

    public void playingItCool()
    {
        game.funkySpaceBarUI.setLocationText("Finally with your date");

        game.funkySpaceBarUI.setMainTextArea("You approached your date with a mellow vibe about you.\n\nYou thought " +
                "you looked cool but the hottie looks up at you unimpressed.");

        game.funkySpaceBarUI.setButtonOneText("Take them to the dance floor and show off your groovy moves.");
        game.funkySpaceBarUI.setButtonTwoText("Start a conversation.");
        game.funkySpaceBarUI.setButtonThreeText("");
        game.funkySpaceBarUI.setButtonFourText("");

        game.choiceOne = "Date is into you.";
        game.choiceTwo = "Ghosted.";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    public void swagger()
    {
        game.funkySpaceBarUI.setLocationText("Finally with your date");

        game.funkySpaceBarUI.setMainTextArea("You approach with a tornado of testosterone. Young women around the " +
                "bar scream and faint from sensory overload.\n\nIts as if you were Patrick Swazey and just " +
                "realized someone put baby in the corner.\n\n\"You look pretty... I look pretty... Why don't we " +
                "go home and stare at each other?\"\n\nYour soulmate is immediately put in a trance and your pecs" +
                " aren't helping either. Their eyes are drawn to them like a moth to a lamp.");

        game.funkySpaceBarUI.setButtonOneText("Continue to emanate pheromones.");
        game.funkySpaceBarUI.setButtonTwoText("Get to know your date.");
        game.funkySpaceBarUI.setButtonThreeText("");
        game.funkySpaceBarUI.setButtonFourText("");

        game.choiceOne = "Date is into you.";
        game.choiceTwo = "Ghosted.";
        game.choiceThree = "";
        game.choiceFour = "";
    }

    //when the date is going well
    public void dateIsIntoYou()
    {
        game.funkySpaceBarUI.setLocationText("Oh Yeah, It's All Comin' Together");

        game.funkySpaceBarUI.setMainTextArea("Your date actually seems into you! I'm extremely surprised but you've " +
                "earned my respect. \n\nNow that things are heating up, what's your next move Casanova?");

        game.funkySpaceBarUI.setButtonOneText("Propose to them.");
        game.funkySpaceBarUI.setButtonTwoText("Ask them to come to your place and play \"Elden Ring\".");
        game.funkySpaceBarUI.setButtonThreeText("Get jiggy with it.");
        game.funkySpaceBarUI.setButtonFourText("");

        game.choiceOne = "Propose to them.";
        game.choiceTwo = "Take date home.";
        game.choiceThree = "Get jiggy with it.";
        game.choiceFour = "";
    }

    //only when "Baby" is played
    public void boneTown()
    {
        game.funkySpaceBarUI.setLocationText("Giggity");

        game.funkySpaceBarUI.setMainTextArea("Nobody knows what it is about the way you dance to \"Baby\" but you're" +
                " doing something right. Five seconds in, three babes are dancing around and on you making heart eyes " +
                "towards you. They aren't your date though.");

        game.funkySpaceBarUI.setButtonOneText("These babes are my soulmates now.");
        game.funkySpaceBarUI.setButtonTwoText("Go search for the date.");
        game.funkySpaceBarUI.setButtonThreeText("Get jiggy with it.");
        game.funkySpaceBarUI.setButtonFourText("");

        game.choiceOne = "These babes are my soulmates now.";
        game.choiceTwo = "Search for date.";
        game.choiceThree = "Get jiggy with it.";
        game.choiceFour = "";
    }

    //leads to the endings
    public void toFinalLocation(int i)
    {
        game.funkySpaceBarUI.deleteUI();
        game.finalLocationUI.createUI();

        if(i == 0)
        {
            game.FINAL_LOCATION.setPlayerChoice("Ending four.");
        }
        else if(i == 1)
        {
            game.FINAL_LOCATION.setPlayerChoice("Ending three.");
        }
        else if(i == 2)
        {
            game.FINAL_LOCATION.setPlayerChoice("Ending two.");
        }
        else if(i == 3)
        {
            game.FINAL_LOCATION.setPlayerChoice("Take date home.");
        }
        else if(i == 4)
        {
            game.FINAL_LOCATION.setPlayerChoice("Ghosted");
        }
        else
        {
            game.FINAL_LOCATION.setPlayerChoice("Propose to them.");
        }
    }
}