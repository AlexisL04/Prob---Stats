/*
 * Author: Alexis Lopez
 * This class represents a Pokemon game and has methods needed to simulate a mulligan test
 */
package PokemonMontyHall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import PCG.Cards.Card;

public class PokemonGame {

    /*
     * Method to shuffle a deck of cards
     * @parameter deck the deck to be shuffled
     * @return the shuffled deck
     */
    public ArrayList<String> shuffleCards(ArrayList<String> deck) 
    {
        //Initializes a random number generator
        Random rand = new Random();
        // initializes n to the size of the deck
        int n = deck.size();

        //Iterates through the deck and swaps each card with a random card in the deck
        for (int i = n - 1; i > 0; i--) 
        {
            //Generates a random number between 0 and i
            int j = rand.nextInt(i + 1);
            //Swaps the card at index i with the card at index j
            String temp = deck.get(i);
            //Swaps the card at index i with the card at index j
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }

        return deck;
    }

    /*
     * Method to populate a deck of cards
     * @parameter pokemon the number of pokemon cards in the deck
     * @parameter energy the number of energy cards in the deck
     * @return the populated deck
     */
    public ArrayList<String> populateDeck(int pokemon, int energy) {
        if (pokemon + energy > 60) {
            throw new IllegalArgumentException("Deck cannot be more than 60 cards");
        }

        ArrayList<String> deck = new ArrayList<>();

        for (int i = 0; i < pokemon; i++) {
            deck.add("Pokemon");
        }

        for (int i = 0; i < energy; i++) {
            deck.add("Energy");
        }

        shuffleCards(deck);
        return deck;
    }

    /*
     * Method to populate a deck of cards but with rare candies
     * @parameter rareCandy the number of rare candy cards in the deck
     * @return the populated deck
     */
    public ArrayList<String> populateDeck2(int rareCandy) 
    {
        
        //initializes the number of rare candies and the number of pokemon in the deck
        int rc = rareCandy;
        int n = 60 - rc;

        //intializes a random number generator amount of pokemon in the deck
        Random random = new Random();
        int pokemon = random.nextInt(n) + 1;
            
        //creates a new empty deck
        ArrayList<String> deck = new ArrayList<>();

        // Add Rare Candy cards
        for (int i = 0; i < rc; i++) 
        {
            deck.add("Rare Candy");
        }

        // Add remaining cards based on random number
        for (int i = 0; i < pokemon; i++) 
        {
            deck.add("Pokemon");
        }

        // Add Energy cards to fill the deck to 60 cards
        for (int i = 0; i < (n - pokemon); i++) 
        {
            deck.add("Energy");
        }

        // Shuffle the deck
        shuffleCards(deck);

        // Return the shuffled deck
        return deck;

    }

    public ArrayList<String> drawCard(ArrayList<String> deck) 
    {
        ArrayList<String> hand = new ArrayList<>();
        
        for (int i = 0; i < 7 && !deck.isEmpty(); i++) 
        {
            hand.add(deck.remove(0));  // Remove from start of deck and add to hand
        }

        return hand;
    }

    /*
     * Method to populate a prize pile
     * @param deck the deck to draw from
     * @return the prize pile
     */
    public ArrayList<String> populatePrizePile(ArrayList<String> deck) 
    {
        //Creates a new empty prize pile
        ArrayList<String> prizePile = new ArrayList<>();
        
        //Draws 6 cards from the deck and adds them to the prize pile
        for (int i = 0; i < 6 && !deck.isEmpty(); i++) 
        {
            prizePile.add(deck.remove(0));
        }

        return prizePile;
    }

    /*
     * Method to determine if a pokemon is in the hand
     * @param hand the hand to check
     * @return true if a pokemon is in the hand, false otherwise
     */
    public boolean determineIfPokemonIsInHand(ArrayList<String> hand) {
        return hand.contains("Pokemon");
    }

    /*
     * Method to determine if all rare candies are in the prize pile
     * @param prizePile the prize pile to check
     * @param rareCandy the number of rare candies in the deck
     * @return true if all rare candies are in the prize pile, false otherwise
     */
    public boolean determineIfAllRCIsInPrizePile(ArrayList<String> prizePile, int rareCandy) {

        int count = 0;
        for (String card : prizePile) {
            if (card.equals("Rare Candy")) {
                count++;
            }
        }

        return count == rareCandy;

    }

}