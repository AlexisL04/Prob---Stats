/*
 * Author: Alexis Lopez
 * The VSPlayer class contains the gameplay loop for the player vs player option
 */
package PCG.VS;

import PCG.GameMechanics.PlayerMechanics;

public class VSPlayer {
    
    //Creates the player and opponent objects
    PlayerMechanics player = new PlayerMechanics();
    PlayerMechanics opponent = new PlayerMechanics();

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
                System.out.println("Player 1's turn");
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
                System.out.println("Player 2's turn");
                opponent.playerTurn(opponent, player);
                
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
                
                System.out.println("Player 2's turn");
                opponent.playerTurn(opponent, player);
                
                if (opponent.getPlayerLost() == true) {
                    System.out.println("Player wins!");
                    break;
                }
                if (player.getPlayerLost() == true) {
                    System.out.println("AI wins!");
                    break;
                }
                
                System.out.println("Player 1's turn");
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
