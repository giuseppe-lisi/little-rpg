package rpg.classes.entityClasses.enemyTypes;
import java.util.Random;

import rpg.classes.entityClasses.Enemy;
import rpg.classes.entityClasses.Player;
import rpg.interfaces.Tauntable;

public class Goblin extends Enemy implements Tauntable {
    private int hp;
    private int attack;
    private float defense;

    public Goblin(int hp, int attack, float defense) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    // getter setter
    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void getHpString() {
        System.out.println("Current goblin hp: " + hp);
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
    
    @Override
    public String taunt() {
        Random rand = new Random();
        return Tauntable.taunts[rand.nextInt(0,Tauntable.taunts.length - 1)];
    }

    // draws goblin sprite on screen
    @Override
    public void drawSprite() {
        System.err.print(". . .  . . .  . . .  #.. .  . . .  . . .\n" +
                        " . . .. . . .. . . .. *#= ..==---.. . . \n" +
                        " . . .. . . .. . . .. *#%#=**+::--= . . \n" +
                        ". . .  . . .  . .*******%%**=---*+== . .\n" +
                        ". . .  . . .  ***===##%%@*#-##@*=:===#*.\n" +
                        ". . .  . . .#%#*+===*%%@@%##+==+==@@ . .\n" +
                        " . . .. . . *%*++*+*#@%%%%*#%==%=:+=. . \n" +
                        " . . .. .#**#*****##%%%%%%###+=*==. . . \n" +
                        " . . ..*#%##**+**%%###%%#%#%*==* .. . . \n" +
                        ". . . =%%%%*+***%@@  . . .=%#*. .  . . .\n" +
                        ". . . **#+*+*#@@@@@@%% . .*##=. .  . . .\n" +
                        " . . .**#**+-*%@%%%%%##.. %%#. . .. . . \n" +
                        " *+= :**##%##*=*-%%%%%# . =#%* . .. . . \n" +
                        " #%**%**##. .**=+*%%* . . .=#*+. .. . . \n" +
                        "*%%+****## . #%%#**  . . .  .#*=.  . . .\n" +
                        "%%#*.###%. .+%##* #==. . .  . :*=  . . .\n" +
                        ". . .  . . .  .%%%**==+. .  . . ** . . .\n" +
                        " . . .. . . .. . .#*+***. .. . =*####+= \n" +
                        " . . .. . . .. . .%** * . .. . . .. . . \n");
    }

}
