package PCG.VS;

import PCG.GameMechanics.PlayerMechanics;

public class VSPlayer {
    
    PlayerMechanics player = new PlayerMechanics();
    PlayerMechanics opponent = new PlayerMechanics();

    public void gamePlayLoop()
    {

        String playerToken = player.coinFlip();

        if (playerToken.equals("Heads")) 
        {
            do{

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

            }
            while (player.getPlayerLost() == false && opponent.getPlayerLost() == false);
        } 
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
