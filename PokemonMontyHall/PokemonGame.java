package PokemonMontyHall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PokemonGame {

    public ArrayList<String> shuffleCards(ArrayList<String> deck) {
        Collections.shuffle(deck);
        return deck;
    }

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

        public ArrayList<String> populateDeck2(int rareCandy) {
            int rc = rareCandy;
            int n = 60 - rc;

            Random random = new Random();
            int pokemon = random.nextInt(n) + 1;
            
            ArrayList<String> deck = new ArrayList<>();

            // Add Rare Candy cards
            for (int i = 0; i < rc; i++) {
                deck.add("Rare Candy");
            }

            // Add remaining cards based on random number
            for (int i = 0; i < pokemon; i++) {
                deck.add("Pokemon");
            }

            for (int i = 0; i < (n - pokemon); i++) {
                deck.add("Energy");
            }

            shuffleCards(deck);
            return deck;

        }

        public ArrayList<String> drawCard(ArrayList<String> deck) {
        ArrayList<String> hand = new ArrayList<>();
        
        for (int i = 0; i < 7 && !deck.isEmpty(); i++) {
            hand.add(deck.remove(0));  // Remove from start of deck and add to hand
        }

        return hand;
    }

    public ArrayList<String> populatePrizePile(ArrayList<String> deck) {
        ArrayList<String> prizePile = new ArrayList<>();
        
        for (int i = 0; i < 6 && !deck.isEmpty(); i++) {
            prizePile.add(deck.remove(0));
        }

        return prizePile;
    }

    public boolean determineIfPokemonIsInHand(ArrayList<String> hand) {
        return hand.contains("Pokemon");
    }

    public boolean determineIfAllRCIsInPrizePile(ArrayList<String> prizePile, int rareCandy) {

        int count = 0;
        for (String card : prizePile) {
            if (card.equals("Rare Candy")) {
                count++;
            }
        }

        return count == rareCandy;

    }


    public int coinFlip() {
        return 1;
    }
}