package rpg.classes.entityClasses;

public class Player {
    private int maxHp = 100;
    private int hp = maxHp;
    private int attack = 30;
    private float defense = 0.9f;
    private int killCount = 0;
    private int healingPotions = 3; 

    // setter getter
    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public float getDefense() {
        return defense;
    }

    public void setKillCount() {
        killCount += 1;
    }
    
    // player util methods
    public void dealDamage(Enemy enemy) {
        enemy.takeDamage(attack);
    }
    
    public void takeDamage(int damage) {
        this.hp -= damage * defense;
    }

    public void heal() {
        healingPotions -= 1;
        if (healingPotions > 0) {
            hp = Math.clamp(hp + 50, 0, maxHp);
        }
    }
    
    // stats methods
    public void getStats() {
        System.out.println("*-------------------------------------------------*");
        System.out.println("HP: " + hp + " / " + maxHp + " | Attack: " + attack);
        System.out.println("Potions: " + healingPotions + String.format("    | Defense: %.2f", defense));
        System.out.println("*-------------------------------------------------*");
    }

    public void lvlUpStats() {
        if (killCount % 3 == 0) {
            System.out.println("You leveled up!");
            maxHp += 20;
            attack += 10;
            defense -= 0.1;
        }
    }

}
