package rpg.classes.playerClasses;
import rpg.interfaces.Entity;

public class Player implements Entity {
    protected int hp = 100;
    protected int attack = 10;
    protected float defense = 0.1f;
    
    public void attack() {
        System.out.println("Im attacking!");
    }

    public void defend() {
        System.out.println("Im defending!");
    }
}
