import java.util.Scanner;
import rpg.classes.entityClasses.Player;
import rpg.classes.entityClasses.enemyTypes.Goblin;
import rpg.classes.entityClasses.enemyTypes.Slime;
import rpg.classes.entityClasses.Enemy;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        // player has first turn
        boolean playerTurn = true;

        Player player = new Player();
        Goblin goblin = new Goblin(100, 5, 0.9f);
        Slime slime = new Slime(30, 5, 0.7f);

        Enemy currentEnemy = slime;

        while (player.getHp() > 0) {

            if (playerTurn) {
                currentEnemy.drawSprite();

                if (currentEnemy instanceof Goblin) {
                    // downcasting to allow call to taunt method
                    currentEnemy = (Goblin) goblin;
                    System.out.println("*---------------------*");
                    System.out.println("The enemy taunts you: " + goblin.taunt());
                    System.out.println("*---------------------*");
                }

                currentEnemy.getHpString();
                System.out.println("*---------------------*");
                System.out.println("HP: " + player.getHp() + " | Attack: " + player.getAttack() + " | Defense: "
                        + player.getDefense());
                System.out.println("*---------------------*");
                System.out.println("Attack? (y)");
                String choice = input.nextLine();
                // if player doesnt correctly type y to attack he doesnt deal damage and gets
                // attacked
                if (choice.equals("y")) {
                    player.dealDamage(currentEnemy);
                }
                System.out.println("*---------------------*");
                System.out.println("It's the enemy's turn!");
                playerTurn = !playerTurn;

            } else {
                // currentEnemy deals damage and gives back turn to player
                if (currentEnemy.getHp() > 0 && player.getHp() > 0) {
                    System.out.println("*---------------------*");
                    System.out.println("The enemy attacks aswell!");
                    System.out.println("*---------------------*");
                    currentEnemy.dealDamage(player);
                    playerTurn = !playerTurn;
                }
            }

            // print game over message if player died otherwise go back and get new enemy
        }

        System.out.println("▗▄▄▄▖▐▌   ▗▞▀▚▖    ▄▄▄▄   ▄▄▄  ▄▄▄▄   ▄▄▄  ■  ▗▞▀▚▖ ▄▄▄ ▄▄▄     ▄   ▄  ▄▄▄  ▄▄▄▄  \n" + //
                "  █  ▐▌   ▐▛▀▀▘    █ █ █ █   █ █   █ ▀▄▄▗▄▟▙▄▖▐▛▀▀▘█   ▀▄▄      █ ▄ █ █   █ █   █ \n" + //
                "  █  ▐▛▀▚▖▝▚▄▄▖    █   █ ▀▄▄▄▀ █   █ ▄▄▄▀ ▐▌  ▝▚▄▄▖█   ▄▄▄▀     █▄█▄█ ▀▄▄▄▀ █   █ \n" + //
                "  █  ▐▌ ▐▌                                ▐▌                                      \n" + //
                "                                          ▐▌                                      \n" + //
                "                                                                                  \n" + //
                "                                                                                  \n" + //
                "                                                                                  \n" + //
                "                                                                                  \n" + //
                "                                                                                  \n" + //
                "                                                                                  \n" + //
                "                                                                                  \n" + //
                "                                                                                  \n" + //
                "                                                                                  ");
        input.close();
    }
}
