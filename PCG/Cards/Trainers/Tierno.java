package PCG.Cards.Trainers;

import java.util.ArrayList;

import PCG.Cards.Card;
import PCG.Cards.TrainerCard;
import PCG.GameMechanics.PlayerMechanics;

public class Tierno extends TrainerCard {
    
    public Tierno() 
    {
        setName("Tierno");

        setDescription("Draw 3 cards.");
    }
    
    @Override
    public ArrayList<Card> cardEffect(PlayerMechanics player) 
    {

        ArrayList<Card> hand = player.getPlayerHand();
        ArrayList<Card> deck = player.getPlayerDeck();

        // Draw 3 cards from deck
        for (int i = 0; i < 4; i++) 
        {
            if (!deck.isEmpty()) 
            {
                hand.add(deck.remove(0));
            }
        }
        
        return hand;
    }
    
}
