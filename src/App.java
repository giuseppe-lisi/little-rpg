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
    
                if (playerTurn) {
                    currentEnemy.drawSprite();
    
                    if (currentEnemy instanceof Tauntable t) {
                        System.out.println("*---------------------*");
                        System.out.println("The enemy taunts you: " + t.taunt());
                        System.out.println("*---------------------*");
                    }
    
                    currentEnemy.getHpString();
    
                    player.getStats();
    
                    System.out.println("Attack? (y)");
                    String choice = input.nextLine();
    
                    // if player doesnt correctly type y to attack he doesnt deal damage and gets attacked
                    if (choice.equals("y")) {
                        player.dealDamage(currentEnemy);
                    }
                    playerTurn = !playerTurn;
                    
                } else {
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
                        currentFloor++;
                        if (currentFloor == 10) {
                            print
                        } 
                        currentEnemy = levels[]
                    }
                }
    
            }
        }
        
        // print game over message if player
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
