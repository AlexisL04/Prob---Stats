/*
 * Author: Alexis Lopez
 * This class is a child of the TrainerCard class and contains methods and variables needed to create a Professor Oak trainer card.
 */
package PCG.Cards.Trainers;

import java.util.ArrayList;

import PCG.Cards.Card;
import PCG.Cards.TrainerCard;
import PCG.GameMechanics.PlayerMechanics;

public class ProfOak extends TrainerCard{
    
    /*
     * Constructor for the ProfOak class, initializes the name and description of the card
     */
    public ProfOak() 
    {
        setName("Professor Oak");
        setDescription("Discard your hand then draw 7 cards from your deck.");
    }

    /*
     * This method is used to implement the effect of the Professor Oak card
     * @param player the player that is using the card
     * @return an ArrayList of Card objects representing the player's hand after using the trainer card
     */
    @Override
    public ArrayList<Card> cardEffect(PlayerMechanics player) 
    {
        // Get the player's hand, deck, and discard pile
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
            // Check if the deck is empty before drawing a card
            if (deck.isEmpty()) 
            {
                // If the deck is empty, set the player's lost status to true and break out of the loop
                System.out.println("Deck is empty. Cannot draw more cards.");
                player.setLost(true);
                break;
            } 
            
            // If the deck is not empty, draw a card and add it to the player's hand
            else 
            {
                hand.add(deck.remove(0));
            }
            
        }
        
        // Return the player's hand after using the trainer card
        return hand;
    }

}
