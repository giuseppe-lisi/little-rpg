package rpg.classes.entityClasses;

public abstract class Enemy {
    protected int hp;
    protected int attack;
    protected float defense;

    public Enemy(int hp, int attack, float defense) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    // damage and attack - take damage also works as setter for hp
    public void takeDamage(int damage) {
        this.hp -= damage * defense;
    }

    public void dealDamage(Player player) {
        player.takeDamage(attack);
    }
    // getter hp
    public int getHp() {
        return hp;
    };
    
    // utils
    public abstract void getHpString();

    public abstract void drawSprite();
}
