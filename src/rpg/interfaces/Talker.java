package rpg.interfaces;

// for npcs that are able to talk and taunt the player
public interface Talker {

    public static final String[] taunts = {
        "I am your doom!",
        "I would hope that there's an afterlife, but only if I could kill you there as well",
        "Wololo",
        "Are you really that stupid to fight me, or do you just look that way?",
        "I know there is something good left in you... but when i'm done with you, there will be nothing left of you!",
        "You fight well, it's a shame you choose the wrong side."
    };

    public String taunt();

}
