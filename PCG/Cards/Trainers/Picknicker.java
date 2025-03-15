/*
 * Author: Alexis Lopez
 * This class is a child of the TrainerCard class.
 * Contains all the information of the actual pokemon card, such as the name, description, and the effect of the card.
 */
package PCG.Cards.Trainers;

import java.util.ArrayList;

import PCG.Cards.Card;
import PCG.Cards.TrainerCard;
import PCG.GameMechanics.PlayerMechanics;

public class Picknicker extends TrainerCard {
    
    /*
     * Constructor for the Picknicker class, initializes the name and description of the card
     * @param none
     * @return none
     */
    public Picknicker() {
        
        setName("Picknicker");
        setDescription("Flip a coin. If heads draw 4 cards, if tails, draw 2");

    }

    /*
     * This method is used to implement the effect of the Picknicker card
     * @param player the player that is using the card
     * @return an ArrayList of Card objects representing the player's hand after using the trainer card
     */
    @Override
    public ArrayList<Card> cardEffect(PlayerMechanics player) 
    {

        // Get the player's hand and deck
        ArrayList<Card> hand = player.getPlayerHand();
        ArrayList<Card> deck = player.getPlayerDeck();

        // Flip a coin to determine how many cards to draw
        // If heads, draw 4 cards, if tails, draw 2 cards
        String result = player.coinFlip();

        if (result.equals("Heads")) 
        {
            
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

                // else we continue to draw cards
                hand.add(deck.remove(0));

            }

        } 

        // If tails, draw 2 cards from deck
        else 
        {

            for (int i = 0; i < 2; i++) 
            {

                // Check if the deck is empty before drawing a card
                if (deck.isEmpty()) 
                {
                    System.out.println("Deck is empty. Cannot draw more cards.");
                    player.setLost(true);
                    break;
                } 
                
                // Else we continue to draw cards
                hand.add(deck.remove(0));

            }

        }

        // Return the player's hand after using the trainer card
        return hand;
    }
    
}
