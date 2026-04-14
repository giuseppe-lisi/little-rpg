import java.util.Scanner;
import rpg.classes.entityClasses.Player;
import rpg.classes.entityClasses.enemyTypes.Goblin;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        Player player = new Player();
        Goblin goblin = new Goblin(100, 10, 0.5f);

        while(goblin.getHp() > 0){
            System.out.println("Attaccare goblin?");
            String choice = input.nextLine();
            if (choice.equals("y")) {
                player.attack(goblin);
            }
        }
        
    }
}
