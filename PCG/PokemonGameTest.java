package PCG;

import java.util.Scanner;

public class PokemonGameTest {
    
    public static void main(String[] args) {
        // Create a new PokemonGame instance
        PokemonGame game = new PokemonGame();
        
        System.out.println("Would you like to play the game or read the rules?");
        System.out.println("1. Play the game");
        System.out.println("2. Read the rules");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                game.startGame();
                break;
            case 2:
                game.rules();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }


    }

}
