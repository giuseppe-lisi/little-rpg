import java.util.Scanner;
import rpg.classes.entityClasses.Player;
import rpg.classes.entityClasses.enemyTypes.Goblin;
import rpg.classes.entityClasses.enemyTypes.Slime;
import rpg.interfaces.Tauntable;
import rpg.classes.entityClasses.enemyTypes.Knight;
import rpg.classes.entityClasses.Enemy;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        // game is made of 10 levels, each level is an enemy with different stats
        Enemy[] levels = {
                new Slime(40, 5, 0.7f),
                new Slime(50, 5, 0.7f),
                new Goblin(60, 10, 0.9f),
                new Slime(80, 10, 0.7f),
                new Goblin(60, 15, 0.8f),
                new Knight(80, 20, 0.9f),
                new Goblin(60, 25, 0.6f),
                new Goblin(90, 30, 0.8f),
                new Knight(95, 20, 0.8f),
                new Knight(100, 25, 0.8f),
        };

        // player vars
        boolean playerTurn = true;
        Player player = new Player();
        int currentFloor = 0;

        Enemy currentEnemy = levels[currentFloor];

        boolean running = true;
        while (running) {

            // main game loop
            while (player.getHp() > 0) {

                // player turn
                if (playerTurn) {
                    currentEnemy.drawSprite();

                    if (currentEnemy instanceof Tauntable t) {
                        System.out.println("*---------------------*");
                        System.out.println("The enemy taunts you: " + t.taunt());
                        System.out.println("*---------------------*");
                    }

                    currentEnemy.getHpString();

                    player.getStats();

                    System.out.println("Attack (a) | Heal (h)");
                    String choice = input.nextLine();

                    // if player doesnt correctly type y to attack or h to heal 
                    // he doesnt deal damage and gets attacked
                    switch (choice) {
                        case "a":
                            player.dealDamage(currentEnemy);
                            playerTurn = !playerTurn;
                            break;
                        case "h":
                            player.heal();
                            playerTurn = !playerTurn;
                            break;

                        default:
                            playerTurn = !playerTurn;
                            break;
                    }
                } 
                // enemy turn
                else {
                    // currentEnemy deals damage and gives back turn to player
                    if (currentEnemy.getHp() > 0) {
                        System.out.println("*---------------------*");
                        System.out.println("It's the enemy's turn!");
                        System.out.println("*---------------------*");
                        System.out.println("The enemy attacks aswell!");
                        System.out.println("*---------------------*");
                        currentEnemy.dealDamage(player);
                        playerTurn = !playerTurn;
                    } else {
                        currentFloor += 1;
                        if (currentFloor >= levels.length - 1) {
                            running = false;
                            System.out.println("▗▖  ▗▖▄▄▄  █  ▐▌    ▄   ▄ ▄ ▄▄▄▄                                   \n" + //
                                    " ▝▚▞▘█   █ ▀▄▄▞▘    █ ▄ █ ▄ █   █                                  \n" + //
                                    "  ▐▌ ▀▄▄▄▀          █▄█▄█ █ █   █                                  \n" + //
                                    "  ▐▌                      █                                        \n" + //
                                    "                                                                   \n" + //
                                    "                                                                   \n" + //
                                    "                                                                   \n" + //
                                    "▗▄▄▄▖▐▌   ▗▞▀▚▖    ▄▄▄▄   ▄▄▄  ▄▄▄▄   ▄▄▄  ■  ▗▞▀▚▖ ▄▄▄ ▄▄▄        \n" + //
                                    "  █  ▐▌   ▐▛▀▀▘    █ █ █ █   █ █   █ ▀▄▄▗▄▟▙▄▖▐▛▀▀▘█   ▀▄▄         \n" + //
                                    "  █  ▐▛▀▚▖▝▚▄▄▖    █   █ ▀▄▄▄▀ █   █ ▄▄▄▀ ▐▌  ▝▚▄▄▖█   ▄▄▄▀        \n" + //
                                    "  █  ▐▌ ▐▌                                ▐▌                       \n" + //
                                    "                                          ▐▌                       \n" + //
                                    "                                                                   \n" + //
                                    "                                                                   \n" + //
                                    "▐▌▗▞▀▜▌▄   ▄ ▗▞▀▚▖    ▗▖   ▗▞▀▚▖▗▞▀▚▖▄▄▄▄       ▄▄▄ █ ▗▞▀▜▌▄ ▄▄▄▄  \n" + //
                                    "▐▌▝▚▄▟▌█   █ ▐▛▀▀▘    ▐▌   ▐▛▀▀▘▐▛▀▀▘█   █     ▀▄▄  █ ▝▚▄▟▌▄ █   █ \n" + //
                                    "▐▛▀▚▖   ▀▄▀  ▝▚▄▄▖    ▐▛▀▚▖▝▚▄▄▖▝▚▄▄▖█   █     ▄▄▄▀ █      █ █   █ \n" + //
                                    "▐▌ ▐▌                 ▐▙▄▞▘                         █      █       \n");
                                    break;
                        } else {
                            // spawns a new enemy, player starts again
                            player.setKillCount();
                            player.lvlUpStats();
                            System.out.println("*---------------------*");
                            System.out.println("A new foe appears! You are on floor: " + (currentFloor + 1));
                            System.out.println("*---------------------*");
                            playerTurn = !playerTurn;
                            currentEnemy = levels[currentFloor];
                        }
                    }
                }

            }
            running = false;
        }

        // print game over message if player
        System.out.println("▗▄▄▄▖▐▌   ▗▞▀▚▖    ▄▄▄▄   ▄▄▄  ▄▄▄▄   ▄▄▄  ■  ▗▞▀▚▖ ▄▄▄ ▄▄▄     ▄   ▄  ▄▄▄  ▄▄▄▄  \n" + //
                "  █  ▐▌   ▐▛▀▀▘    █ █ █ █   █ █   █ ▀▄▄▗▄▟▙▄▖▐▛▀▀▘█   ▀▄▄      █ ▄ █ █   █ █   █ \n" + //
                "  █  ▐▛▀▚▖▝▚▄▄▖    █   █ ▀▄▄▄▀ █   █ ▄▄▄▀ ▐▌  ▝▚▄▄▖█   ▄▄▄▀     █▄█▄█ ▀▄▄▄▀ █   █ \n" + //
                "  █  ▐▌ ▐▌                                ▐▌                                      \n" + //
                "                                          ▐▌                                      \n");
        input.close();
    }
}
