package rpg.classes.entityClasses;

public abstract class Enemy {

    // damage and attack - take damage also works as setter for hp
    public abstract void takeDamage(int damage);

    public abstract void dealDamage(Player player);

    // getter hp
    public abstract int getHp();
    
    public abstract void getHpString();

    // draws sprite
    public abstract void drawSprite();
}
