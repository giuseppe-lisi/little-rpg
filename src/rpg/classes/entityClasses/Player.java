package rpg.classes.entityClasses;

public class Player {
    private int hp = 100;
    private int attack = 30;
    private float defense = 0.9f;

    // setter getter
    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public float getDefense() {
        return defense;
    }

    // player util methods
    public void dealDamage(Enemy enemy) {
        enemy.takeDamage(attack);
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
    }

}
