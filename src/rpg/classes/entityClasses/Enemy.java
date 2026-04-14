package rpg.classes.entityClasses;

public abstract class Enemy {

    public abstract void takeDamage(int damage);

    public abstract void dealDamage(Player player);

    public abstract void drawSprite();
}
