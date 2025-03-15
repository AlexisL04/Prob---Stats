/*
 * Author: Alexis Lopez
 * This class is a child of the TrainerCard class
 * Contains all the information of the actual pokemon card, such as the name, description, and the effect of the card.
 */

package PCG.Cards.Trainers;

import java.util.ArrayList;
import PCG.Cards.TrainerCard;
import PCG.GameMechanics.PlayerMechanics;
import PCG.Cards.Card;

public class Sophocles extends TrainerCard {
    
    /*
     * Constructor for the Sophocles class, initializes the name and description of the card
     */
    public Sophocles() 
    {
        setName("Sophocles");
        setDescription("Discard 2 cards from your hand. If you do, draw 4 cards.");
    }
    
    /*
     * This method is used to implement the effect of the Sophocles card
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

        // Discard 2 cards from hand
        if (hand.size() >= 2) 
        {
            discard.add(hand.remove(0));
            discard.add(hand.remove(0));

            // Draw 4 cards from deck
            for (int i = 0; i < 4; i++) 
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
        }
        
        // Return the player's hand after using the trainer card
        return hand;
    }
    
}
