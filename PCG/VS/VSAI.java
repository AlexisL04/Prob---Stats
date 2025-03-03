package PCG.VS;

import PCG.GameMechanics.AIMechanics;
import PCG.GameMechanics.PlayerMechanics;

public class VSAI {
    
    PlayerMechanics player = new PlayerMechanics();
    AIMechanics opponent = new AIMechanics();

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
