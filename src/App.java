import java.util.Scanner;
import rpg.classes.entityClasses.Player;
import rpg.classes.entityClasses.enemyTypes.Goblin;
import rpg.classes.entityClasses.enemyTypes.Slime;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        // player has first turn
        boolean playerTurn = true;

        Player player = new Player();
        Goblin goblin = new Goblin(100, 5, 0.5f);
        Slime slime = new Slime(30, 5, 0.5f);

        while (slime.getHp() > 0) {

            if (playerTurn) {
                System.out.println("It's the enemy's turn!");
                slime.drawSprite();
                System.out.println("*---------------------*");
                slime.getHpString();
                System.out.println("*---------------------*");
                System.out.println("HP: " + player.getHp() + " | Attack: " + player.getAttack() + " | Defense: "
                        + player.getDefense());
                System.out.println("*---------------------*");
                System.out.println("Attack? (y)");
                String choice = input.nextLine();
                // if player doesnt correctly type y to attack he doesnt deal damage and gets
                // attacked
                if (choice.equals("y")) {
                    player.dealDamage(slime);
                }
                playerTurn = !playerTurn;

            } else { // goblin deals damage and gives back turn to player
                slime.dealDamage(player);
                playerTurn = !playerTurn;
            }
        }

    }
}
