package PCG.Cards.Trainers;

import java.util.ArrayList;

import PCG.Cards.Card;
import PCG.Cards.TrainerCard;
import PCG.GameMechanics.PlayerMechanics;

public class Picknicker extends TrainerCard {
    
    public Picknicker() {
        
        setName("Picknicker");
        setDescription("Flip a coin. If heads draw 4 cards, if tails, draw 2");

    }

    @Override
    public ArrayList<Card> cardEffect(PlayerMechanics player) 
    {

        ArrayList<Card> hand = player.getPlayerHand();
        ArrayList<Card> deck = player.getPlayerDeck();

        String result = player.coinFlip();

        if (result.equals("Heads")) 
        {
            
            for (int i = 0; i < 4; i++) 
            {
                
                if (deck.isEmpty()) 
                {
                    System.out.println("Deck is empty. Cannot draw more cards.");
                    player.setLost(true);
                    break;
                } 

                hand.add(deck.remove(0));

            }

        } 

        else 
        {

            for (int i = 0; i < 2; i++) 
            {

                if (deck.isEmpty()) 
                {
                    System.out.println("Deck is empty. Cannot draw more cards.");
                    player.setLost(true);
                    break;
                } 
                
                hand.add(deck.remove(0));

            }

        }

        return hand;
    }
    
}
