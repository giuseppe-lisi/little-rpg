package rpg.classes.entityClasses.enemyTypes;
import rpg.classes.entityClasses.Enemy;

public class Goblin extends Enemy {
    protected int hp;
    protected int attack;
    protected float defense;

    public Goblin(int hp, int attack, float defense) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    // getter setter
    public int getHp() {
        return hp;
    }

    @Override
    public void takeDamage(int damage) {
        this.hp -= damage;
        System.err.println("Current goblin hp: " + this.hp);
    }
    
}
