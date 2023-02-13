public enum GameEnding
{
    ENDING_ONE("You come home to where you used to live. I say \"used to live\" because " +
            "your housed burned down.\n\nApparently you left your oven on. Maybe you should've checked before you left, huh?" +
            "\n\nOh well, sucks to suck LMFAO.", 1),

    ENDING_TWO("Like holy crap man.\n\nYou had one simple task, and you failed.\n\n" +
            "You had the once in a lifetime opportunity to be with your soulmate. I mean, how often does someone get matches on space tinder?\n\nNow you'll be lonely forever.\n\n" +
            "To be fair, I should've known this would happen. I mean just look at you, you and that yee yee ass hair cut.\n\n" +
            "Your soulmate would have to be blind, deaf, and dumb to actually believe you weren't absolutely" +
            " repulsive.\n\nNow get out of my sight. You disgust me.", 2),

    ENDING_THREE("Well, you didn't meet your soulmate, but you took the three babes home " +
            "with you.\n\nWhy have one soulmate when you can have three, I guess?", 3),

    ENDING_FOUR("You decided to live this night to the fullest. \n\nYou don't remember " +
            "much from last night, but you do know that you consumed enough psychedelic gourds to sedate an elephant." +
            "\n\nAfter your vision clears a little, you realize you're on " +
            "top of the bar counter. \n\nYou also notice writing on your arm. It's a phone number! As you're" +
            " reading it, you accidentally barf on it. \n\nOn instinct, you wipe away the foul, chunky regurgitation " +
            "and smear half the number in the process. Good job. \n\nNow we have to " +
            "endure another terrible quest just because of your lameness. Are you up for it?", 4),

    ENDING_FIVE("As you lean in to kiss your date, you are suddenly awoken by the shout of Professor Ed Hall.\n\nYou have no idea " +
                          "what he is talking about, but the last thing you heard was something about an array list of gourds.", 5);

    private final String description;
    private int endingNum;

    GameEnding(String description, int endingNum)
    {
        this.description = description;
        this.endingNum = endingNum;
    }

    public String getDescription()
    {
        return description;
    }

    public int getEndingNum()
    {
        return endingNum;
    }
}
