package rpg.classes.entityClasses;

public class Player {
    private int hp = 100;
    private int attack = 30;
    private float defense = 0.9f;
    private int killCount = 0;

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

    public void updateKillCount() {
        killCount += 1;
    }

    public void lvlUpStats() {
        if (killCount % 3 == 0) {
            hp += 10;
            attack += 20;
            defense -= 0.1; 
        }
    }

}
