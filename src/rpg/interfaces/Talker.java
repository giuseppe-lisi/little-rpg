package rpg.interfaces;

// for npcs that are able to talk and taunt the player
public interface Talker {

    public static final String[] taunts = {
        "I am your doom!",
        "I would hope that there's an afterlife, but only if I could kill you there as well",
        "Wololo",
        "Are you really that stupid to fight me, or do you just look that way?",
        "I know there is something good left in you... but when i'm done with you, there will be nothing left of you!",
        "You fight well, it's a shame you choose the wrong side.",
        "I'm gonna floss with your spine!",
        "I'll crack your skull open with my thumbs!",
        "You must enjoy losing.",
        "Stay and be destroyed.",
        "You are a waste of breath.",
        "You really don't want me as your enemy.",
        "Surrender or die!"
    };

    public String taunt();

}
