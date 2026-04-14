package rpg.classes.entityClasses.enemyTypes;
import rpg.classes.entityClasses.Enemy;
import rpg.classes.entityClasses.Player;

public class Slime extends Enemy {
    protected int hp;
    protected int attack;
    protected float defense;

    public Slime(int hp, int attack, float defense) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    // getter setter
    public int getHp() {
        return hp;
    }

    public void getHpString() {
        System.out.println("Current slime hp: " + hp);
    }

    // class utils
    @Override
    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    @Override
    public void dealDamage(Player player) {
        player.takeDamage(attack);
    }
    // draws goblin sprite on screen
    @Override
    public void drawSprite() {
        System.err.print("........................................\n" + //
                        "................................  ......\n" + //
                        "............... ::. .       .. ::: .....\n" + //
                        "................ ::::.:++:::::::: ......\n" + //
                        "............... :.::::::::::::::  ......\n" + //
                        "............. :++:::::::::::::::: ......\n" + //
                        "...........  :+:::::::::  ::::- :: .....\n" + //
                        ".......... :++::::::::=+ :::::..+ : ....\n" + //
                        "......... ::::::::::::::::::::::::: ....\n" + //
                        "........ :::::::::::::. ..  :  . :: ....\n" + //
                        "....... :::::::::::::  .::.   ::  :. ...\n" + //
                        "...... ::::::::::::::::::::::::::::. ...\n" + //
                        "....  :::::::::::::::::::::::::::::. ...\n" + //
                        ".. ::::::::::::::::::::::::::::::::  ...\n" + //
                        "   ::::::::::::::::::::::::::::::::::  .\n" + //
                        "....  ::::::::::::::::::::::::::::::: ..\n" + //
                        "......  :::::::::::::::::::::.:::    ...\n" + //
                        "...........      .....     .............\n" + //
                        "........................................\n" + //
                        "");
    }
}
