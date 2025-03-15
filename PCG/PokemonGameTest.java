package PCG;

import java.util.Scanner;

public class PokemonGameTest {
    
    public static void main(String[] args) {
        // Create a new PokemonGame instance
        PokemonGame game = new PokemonGame();
        
        System.out.println("Press 1 for game options or 2 for game rules:");

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
