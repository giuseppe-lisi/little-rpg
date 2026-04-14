import rpg.classes.playerClasses.Player;

public class App {
    public static void main(String[] args) throws Exception {
        Player player = new Player();

        player.attack();
        player.defend();
    }
}
