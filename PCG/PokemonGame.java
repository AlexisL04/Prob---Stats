package PCG;

import java.util.Scanner;

import PCG.VS.VSAI;
import PCG.VS.VSPlayer;

public class PokemonGame {
    
    public static void main(String[] args) {

        VSPlayer PlayerGame = new VSPlayer();
        VSAI AIGame = new VSAI();

        
        System.out.println("Welcome to the Pokemon Card Game!");
        System.out.println("You can play against a player or an AI.");
        System.out.println("Please select an option:");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs AI");
        Scanner in = new Scanner(System.in);
        
        int choice = in.nextInt();

        switch(choice) {
            case 1:
                System.out.println("You have selected Player vs Player.");
                PlayerGame.gamePlayLoop();
                break;
            case 2:
                System.out.println("You have selected Player vs AI.");
                AIGame.gamePlayLoop();
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
                return;
        }
        
    }

}
