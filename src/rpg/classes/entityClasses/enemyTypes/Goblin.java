package rpg.classes.entityClasses.enemyTypes;
import java.util.Random;
import rpg.classes.entityClasses.Enemy;
import rpg.interfaces.Tauntable;

public class Goblin extends Enemy implements Tauntable {

    public Goblin(int hp, int attack, float defense) {
        super(hp, attack, defense);
    }
    
    // utils
    @Override
    public String taunt() {
        Random rand = new Random();
        return Tauntable.taunts[rand.nextInt(0,Tauntable.taunts.length - 1)];
    }
    
    @Override
    public void getHpString() {
        System.out.println("Current goblin hp: " + hp);
    }

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
