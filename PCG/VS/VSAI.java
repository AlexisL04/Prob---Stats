/*
 * Author: Alexis Lopez
 * The VSAI class contains the gameplay loop for the player vs AI option
 */
package PCG.VS;

import PCG.GameMechanics.AIMechanics;
import PCG.GameMechanics.PlayerMechanics;

public class VSAI {
    
    //Creates the player and opponent objects
    PlayerMechanics player = new PlayerMechanics();
    AIMechanics opponent = new AIMechanics();

    public void gamePlayLoop()
    {

        //flips coin to determine who goes first
        String playerToken = player.coinFlip();

        //if player wins coin flip, they go first
        if (playerToken.equals("Heads")) 
        {
            do{

                //Checks win condition
                if (opponent.getPlayerLost() == true) {
                    System.out.println("Player wins!");
                    break;
                }
                if (player.getPlayerLost() == true) {
                    System.out.println("AI wins!");
                    break;
                }

                //Player goes first
                System.out.println("Players turn");
                player.playerTurn(player, opponent);
                
                //Checks win condition
                if (opponent.getPlayerLost() == true) {
                    System.out.println("Player wins!");
                    break;
                }
                if (player.getPlayerLost() == true) {
                    System.out.println("AI wins!");
                    break;
                }

                //AI goes second
                System.out.println("AI's turn");
                opponent.aiTurn(opponent, player);
                
                //Checks win condition
                if (opponent.getPlayerLost() == true) {
                    System.out.println("Player wins!");
                    break;
                }
                if (player.getPlayerLost() == true) {
                    System.out.println("AI wins!");
                    break;
                }

            }
            while (player.getPlayerLost() == false && opponent.getPlayerLost() == false);
        } 

        //if AI wins coin flip, they go first, and player goes second.
        else 
        {
            do
            {
                if (opponent.getPlayerLost() == true) {
                    System.out.println("Player wins!");
                    break;
                }
                if (player.getPlayerLost() == true) {
                    System.out.println("AI wins!");
                    break;
                }

                System.out.println("AI's turn");
                opponent.aiTurn(opponent, player);
                
                if (opponent.getPlayerLost() == true) {
                    System.out.println("Player wins!");
                    break;
                }
                if (player.getPlayerLost() == true) {
                    System.out.println("AI wins!");
                    break;
                }
                
                System.out.println("Players turn");
                player.playerTurn(player, opponent);
                
                if (opponent.getPlayerLost() == true) {
                    System.out.println("Player wins!");
                    break;
                }
                if (player.getPlayerLost() == true) {
                    System.out.println("AI wins!");
                    break;
                }
            }
            while (player.getPlayerLost() == false && opponent.getPlayerLost() == false);
            
        }

    }


    

}
