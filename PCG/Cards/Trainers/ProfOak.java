package PCG.Cards.Trainers;

import java.util.ArrayList;

import PCG.Cards.Card;
import PCG.Cards.TrainerCard;
import PCG.GameMechanics.PlayerMechanics;

public class ProfOak extends TrainerCard{
    
    public ProfOak() {
        setName("Professor Oak");
        setDescription("Discard your hand then draw 7 cards from your deck.");
    }

    @Override
    public ArrayList<Card> cardEffect(PlayerMechanics player) 
    {
        ArrayList<Card> hand = player.getPlayerHand();
        ArrayList<Card> deck = player.getPlayerDeck();
        ArrayList<Card> discard = player.getPlayerDiscard();
        
        // Discard all cards in hand
        while (!hand.isEmpty()) 
        {
            discard.add(hand.remove(0));
        }
        
        // Draw 7 cards from deck
        for (int i = 0; i < 8; i++) 
        {
            if (!deck.isEmpty()) 
            {
                hand.add(deck.remove(0));
            }
        }
        
        return hand;
    }

}
