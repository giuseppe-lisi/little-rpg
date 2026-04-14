package rpg.classes.entityClasses;

public class Player {
    private int hp = 100;
    private int attack = 10;
    private float defense = 0.1f;

    public void attack(Enemy enemy) {
        enemy.takeDamage(attack);
    }

}
