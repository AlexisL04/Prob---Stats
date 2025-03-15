/*
 * Author: Alexis Lopez
 * This class 
 */
package PCG;

import java.util.Scanner;

import PCG.VS.VSAI;
import PCG.VS.VSPlayer;

public class PokemonGame {
    
        VSPlayer PlayerGame = new VSPlayer();
        VSAI AIGame = new VSAI();

        public void startGame() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the Pokemon Trading Card Game!");
            System.out.println("Choose your game mode:");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs AI");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                PlayerGame.gamePlayLoop();
            } else if (choice == 2) {
                AIGame.gamePlayLoop();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
            
            scanner.close();
        }

        public void rules() {
            System.out.println("Game Rules:");
            System.out.println("1. Each player starts with a deck of 60 cards.");
            System.out.println("2. Players take turns drawing a card and playing them.");
            System.out.println("3. Players can attack their opponent's Pokemon and use Trainer cards.");
            System.out.println("4. The game ends when one player has no Pokemon left to play or their deck is empty");
        }

}
