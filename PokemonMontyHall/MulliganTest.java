
package PokemonMontyHall;

import java.util.ArrayList;

public class MulliganTest {
    
    public static void main(String[] args) {
        
        
        PokemonGame game = new PokemonGame();

        for (int i = 1; i < 5; i++){

            int count = 0;

            for (int j = 0; j < 10000; j++){
                
                ArrayList<String> deck = game.populateDeck2(i);
                ArrayList<String> hand = game.drawCard(deck);
                
                while (game.determineIfPokemonIsInHand(hand) == false)
                {
                    deck = game.populateDeck2(i);
                    hand = game.drawCard(deck);
                }


                ArrayList<String> prize = game.populatePrizePile(deck);

                if (game.determineIfAllRCIsInPrizePile(prize, i) == true)
                {
                    count++;
                }

            }

            double probability = (count * 100.0) / 10000;

            System.out.println(probability);
        }
            
        
        /*
        for (int i = 0; i < 60; i++){
            int x = 0 + i;
            int y = 60 - i;

            int count = 0;
            
            for (int j = 0; j < 10000; j++){
                
                ArrayList<String> deck = game.populateDeck(x, y);
                ArrayList<String> hand = game.drawCard(deck);
                
                if (game.determineIfPokemonIsInHand(hand) == false)
                {
                    count++;
                } 
            }

            double probability = (count * 100.0) / 10000;


            System.out.println(probability);

            //System.out.println("the chance for a mulligan is " + probability + "% for " + x + " pokemon and " + y + " energy");

        }

        */


    }

}
