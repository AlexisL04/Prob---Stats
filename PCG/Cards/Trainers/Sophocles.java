package PCG.Cards.Trainers;

import java.util.ArrayList;


import PCG.Cards.TrainerCard;
import PCG.GameMechanics.PlayerMechanics;
import PCG.Cards.Card;

public class Sophocles extends TrainerCard {
    
    public Sophocles() {
        setName("Sophocles");
        setDescription("Discard 2 cards from your hand. If you do, draw 4 cards.");
    }
    
    @Override
    public ArrayList<Card> cardEffect(PlayerMechanics player) 
    {

        ArrayList<Card> hand = player.getPlayerHand();
        ArrayList<Card> deck = player.getPlayerDeck();
        ArrayList<Card> discard = player.getPlayerDiscard();

        // Discard 2 cards from hand
        if (hand.size() >= 2) 
        {
            discard.add(hand.remove(0));
            discard.add(hand.remove(0));

                // Draw 4 cards from deck
                for (int i = 0; i < 4; i++) 
                {
                    if (deck.isEmpty()) 
                    {
                        System.out.println("Deck is empty. Cannot draw more cards.");
                        player.setLost(true);
                        break;
                    } 
                    
                    else 
                    {
                        hand.add(deck.remove(0));
                    }
                
                }
        }
        
        
        return hand;
    }
    
}
