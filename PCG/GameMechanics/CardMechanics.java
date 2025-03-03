package PCG.GameMechanics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

// Card type imports
import PCG.Cards.Card;
import PCG.Cards.EnergyCard;
import PCG.Cards.PokemonCard;
import PCG.Cards.TrainerCard;

// Energy card type imports
import PCG.Cards.Energy.*;

// Pokemon card type imports
import PCG.Cards.Pokemon.*;

// Trainer card type imports
import PCG.Cards.Trainers.*;


// This class handles the mechanics of the game, including deck population, shuffling, drawing cards, and playing cards.
// It also includes methods for checking energy requirements and handling attacks.
public class CardMechanics extends Card
{
    /* 
     * This method populates the deck with a specific number of Pokemon, Trainer, and Energy cards.
     * @param none
     * @return ArrayList<Card> returns the populated and shuffled deck
     */
    public ArrayList<Card> populateDeck()
    {
        // Define the number of each card type
        int pokemonCards = 16;
        int trainerCards = 16;
        int energyCards = 28;
        int max = pokemonCards + trainerCards + energyCards;

        //Creates a deck with the specified number of cards
        ArrayList<Card> deck = new ArrayList<>(pokemonCards + trainerCards + energyCards);
        
        // A for loop to add 4 copies of each Pokemon and Trainer card
        for (int i = 0; i < 4; i++) 
        {
            deck.add(new Squirtle());
            deck.add(new Bulbasaur());
            deck.add(new Charmander());
            deck.add(new Pikachu());
            deck.add(new ProfOak());
            deck.add(new Picknicker());
            deck.add(new Tierno());
            deck.add(new Sophocles());
        }

        // Add random energy cards to the deck till 60 cards are reached
        for (int i = (pokemonCards + trainerCards); i < (max) ; i++)
        {
            Random random = new Random();
            int energyType = random.nextInt(5); 

            switch (energyType)
            {
                case 0:
                    deck.add(new Water());
                    break;
                case 1:
                    deck.add(new Grass());
                    break;
                case 2:
                    deck.add(new Fire());
                    break;
                case 3:
                    deck.add(new Electric());
                    break;
                case 4:
                    deck.add(new Normal());
                    break;
            }
        }

        // Shuffle the deck
        shuffleCards(deck);

        return deck;
    }
    
    /* 
     * Shuffles the deck by using three variables, a temporary variable, a random entry in the deck, and the current possition of the for loop
     * @param ArrayList<Card> deck - The deck to be shuffled
     * @return ArrayList<Card> - The shuffled deck
     */
    public ArrayList<Card> shuffleCards(ArrayList<Card> deck) 
    {
        Random rand = new Random();
        int n = deck.size();

        for (int i = n - 1; i > 0; i--) 
        {
            int j = rand.nextInt(i + 1);
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
        return deck;
    }

    /* 
     * Draws a card from the deck and adds it to the specified pile (hand, discard, etc.)
     * @param ArrayList<Card> deck - The deck to draw from
     * @param ArrayList<Card> pile - The pile to add the drawn card to
     * @return ArrayList<Card> - The updated pile
     */
    public ArrayList<Card> drawCard(ArrayList<Card> deck, ArrayList<Card> pile) 
    {
        pile.add(deck.remove(0));
        return pile;
    }

    /*
     * Populates the player's hand with 7 cards from the deck
     * @param ArrayList<Card> deck - The deck to draw from
     * @return ArrayList<Card> - The populated hand
     */
    public ArrayList<Card> populateHand(ArrayList<Card> deck) 
    {
        ArrayList<Card> hand = new ArrayList<>();
        
        do{
            for (int i = 0; i < 7; i++) 
            {
                drawCard(deck, hand);
            }
        } while(determineIfPokemonIsInHand(hand) == false);

        return hand;
    }

    /*
     * Populates the prize pile with 6 cards from the deck
     * @param ArrayList<Card> deck - The deck to draw from
     * @return ArrayList<Card> - The populated prize pile
     */
    public ArrayList<Card> populatePrizePile(ArrayList<Card> deck) 
    {
        ArrayList<Card> prizePile = new ArrayList<>();
        for (int i = 0; i < 6; i++) 
        {
            drawCard(deck, prizePile);
        }
        return prizePile;
    }

    /*
     * Initializes an empty pile, either to be used for discarding cards or for other purposes like a bench for the pokemon
     * @param none
     * @return ArrayList<Card> - The empty pile
     */
    public ArrayList<Card> initializeEmptyPile()
    {
        ArrayList<Card> discardPile = new ArrayList<>();
        return discardPile;
    }

    /*
     * Checks if the player has any Pokemon cards in their hand
     * @param ArrayList<Card> hand - The player's hand
     * @return boolean - true if there is at least one Pokemon card, false otherwise
     */
    public boolean determineIfPokemonIsInHand(ArrayList<Card> hand) 
    {
        for (Card card : hand) 
        {
            if (card instanceof PokemonCard) 
            {
                return true;
            }
        }
        return false;
    }

    /*
     * Plays an energy card from the player's hand to the active Pokemon
     * @param PlayerMechanics player - The player whose turn it is
     * @param int Choice - The index of the card in the player's hand
     * @return void
     */
    public void playEnergy(PlayerMechanics player, int Choice) 
    {
        // We get everything we need from the player, their hand, active pokemon, and the card they have selected from the hand
        ArrayList<Card> hand = player.getPlayerHand();
        PokemonCard active = player.getPlayerActive();
        Card selectedCard = hand.get(Choice);

        // Checks to see if there is an active pokemon on the field
        if (active == null) {
            System.out.println("You need an active Pokemon to attach energy to!");
            return;
        }

        // Checks to see if the selected card is an energy card
        if (selectedCard instanceof EnergyCard) 
        {

            // If it is, we cast the card to an energy card and add it to the active pokemon and remove it from the hand
            EnergyCard energyCard = (EnergyCard) selectedCard;
            active.addEnergy(energyCard);
            hand.remove(Choice);
            System.out.println("You have attatched " + energyCard.getCardName(energyCard) + " energy to your " + active.getName());
            
        } 
        else  
        {
            System.out.println("You cannot play that card - selected card is not an Energy card");
        }
    }

    /*
     * Plays a trainer card from the player's hand
     * @param PlayerMechanics player - The player whose turn it is
     * @param int choice - The index of the card in the player's hand
     * @return void
     */
    public void playTrainer (PlayerMechanics player, int choice) 
    {
        // We get everything we need from the player, their hand, their discard pile, and the card they have selected from the hand
        ArrayList<Card> hand = player.getPlayerHand();
        ArrayList<Card> discard = player.getPlayerDiscard();
        Card selectedCard = hand.get(choice);
        
        // Checks to see if the selected card is a trainer card
        if (selectedCard instanceof TrainerCard) 
        {
            // If it is, we cast the card to a trainer card and call the cardEffect method, then we remove the card from the hand and add it to the discard pile
            TrainerCard trainer = (TrainerCard) selectedCard;
            trainer.cardEffect(player);
            discard.add(hand.remove(choice));
        } 

        else 
        {
            System.out.println("You cannot play that card");
        } 
    }

    /*
     * Plays a Pokemon card from the player's hand to the active position
     * @param PlayerMechanics player - The player whose turn it is
     * @param int choice - The index of the card in the player's hand
     * @return void
     */
    public void playPokemon(PlayerMechanics player, int choice) 
    {
        // We get everything we need from the player, their hand, active, and the card they have selected from the hand
        ArrayList<Card> hand = player.getPlayerHand();
        PokemonCard active = player.getPlayerActive();
        Card selectedCard = hand.get(choice);

        // Checks to see if there is an active pokemon on the field
        if ( active != null) 
        {
            System.out.println("You already have an active Pokemon. Please retreat the current active Pokemon before playing a new one.");
            return;
        }

        // Checks to see if the selected card is a pokemon card
        if (selectedCard instanceof PokemonCard) 
        {
            // If it is, we cast the card to a pokemon card and set it as the active pokemon, then we remove it from the hand
            PokemonCard pokemon = (PokemonCard) selectedCard;
            player.setPlayerActive(pokemon);
            hand.remove(choice);
        } 
        else 
        {
            System.out.println("You cannot play that card");
        }
    }
    
    /*
     * Plays a Pokemon card from the player's hand to the bench
     * @param PlayerMechanics player - The player whose turn it is
     * @return void
     */
    public void benchPokemon(PlayerMechanics player, int choice) 
    {
        // We get everything we need from the player, their hand, and their bench
        ArrayList<Card> hand = player.getPlayerHand();
        ArrayList<Card> playerBench = player.getPlayerBench();
        Card selectedCard = hand.get(choice);
        
        // Check if bench is full
        if (playerBench.size() >= 5) {
            System.out.println("Bench is full!");
            return;
        }

        // Checks to see if the selected card is a pokemon card
        if (selectedCard instanceof PokemonCard) 
        {
            // If it is, we cast the card to a pokemon card and add it to the bench, then we remove it from the hand
            PokemonCard pokemon = (PokemonCard) selectedCard;
            playerBench.add(pokemon);
            hand.remove(choice);
        } 
        else 
        {
            System.out.println("You cannot play that card");
        }
    }

    /*
     * Attacks the opponent's active Pokemon with the player's active Pokemon
     * @param PlayerMechanics player - The player whose turn it is
     * @param PlayerMechanics opponent - The opponent player
     * @return void
     */
    public void attack(PlayerMechanics player, PlayerMechanics opponent)
    {
        // We get everything we need from the player, their active pokemon, their hand, and prize pile 
        PokemonCard active = player.getPlayerActive();
        ArrayList<Card> playerHand = player.getPlayerHand();
        ArrayList<Card> playerPrize = player.getPlayerPrize();

        //We also get the opponent's active pokemon, discard pile, and bench
        PokemonCard opponentActive = opponent.getPlayerActive();
        ArrayList<Card> opponentDiscard = opponent.getPlayerDiscard();
        ArrayList<Card> opponentBench = opponent.getPlayerBench();

        // Checks to see if the player has an active pokemon
        if (active == null || opponentActive == null) 
        {
            System.out.println("You or your opponent does not have an active pokemon");
            return;
        }

        // Checks to see if the player has enough energy to attack
        if (checkEnergy(player)) 
        {
            // If they do, we print
            System.out.println("You have enough energy to attack");
            System.out.println("You have attacked your opponent's pokemon");
            
            // Calculate damage based on type advantages
            int damage = active.getAttack();
            String type = active.getAtkType();
            
            if (opponentActive.getWeakness().equals(type)) 
            {
                damage *= 2;
                System.out.println("Your attack was super effective");
            } 
            else if (opponentActive.getResistance().equals(type)) 
            {
                damage /= 2;
                System.out.println("Your attack was not very effective");
            }
            
            // Apply damage to opponent's active Pokemon
            System.out.println("Your attack did " + damage + " damage to your opponent's pokemon");
            opponentActive.setHP(opponentActive.getHP() - damage);
            System.out.println("Your opponent's pokemon has " + opponentActive.getHP() + " HP left");
            // Check if the opponent's active Pokemon has fainted
            if (opponentActive.getHP() <= 0) 
            {
                System.out.println("Your opponent's pokemon has fainted");
            }

            // Handle Pokemon knockout
            if (opponentActive.getHP() <= 0) 
            {
                
                System.out.println("You have knocked out your opponent's pokemon");
                playerHand.add(playerPrize.remove(0));
                
                // Check if player has any remaining prize cards
                if(playerPrize.isEmpty())
                {
                    
                    // If the player has no more prize cards, they win the game
                    System.out.println("You have won the game");
                    opponent.setLost(true);

                }

                // Move opponent's active Pokemon to discard pile and sets their active pokemon to null
                opponentDiscard.add(opponentActive);
                opponent.setPlayerActive(null);

                // Check if opponent has any Pokemon on the bench
                if (opponentBench.size() > 0) 
                {
                    
                    // If they do, we set the first one on the bench as their new active pokemon
                    opponent.setPlayerActive((PokemonCard) opponentBench.remove(0));

                } 
                else 
                {
                    
                    // If they don't, we print a message and set the opponent as lost
                    System.out.println("Your opponent has no more pokemon in play");

                }
            }
        } 

        else 
        {
            System.out.println("You do not have enough energy to attack");
        }
    }

    /*
     * Allows the player to retreat their active pokemon
     * @param PlayerMechanics player - The player whose turn it is
     * @return void
     */
    public void retreat(PlayerMechanics player)
    {
        // We get everything we need from the player, their active pokemon, and their bench
        PokemonCard active = player.getPlayerActive();
        ArrayList<Card> playerBench = player.getPlayerBench();
        ArrayList<Card> playerHand = player.getPlayerHand();
        ArrayList<Card> playerDiscard = player.getPlayerDiscard();

        // Checks to see if the player has an active pokemon
        if (active == null) 
        {
            System.out.println("You have no active pokemon");
            return;
        }

        // Checks to see if the player has enough energy to retreat
        if (checkRetreatEnergy(player)) 
        {

            // Get the energy cards attached to the active pokemon and print them
            System.out.println("Select an energy card to remove:");
            for (int i = 0; i < active.getAttatchedEnergy().size(); i++) {
                System.out.println(i + ": " + active.getAttatchedEnergy().get(i).getCardName(active.getAttatchedEnergy().get(i)));
            }

            // Get user input for which energy to remove
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            // Remove the selected energy card
            if (choice >= 0 && choice < active.getAttatchedEnergy().size()) 
            {
                playerDiscard.add(active.getAttatchedEnergy().remove(choice));
            } 
            
            else 
            {
                System.out.println("Invalid selection");
                return;
            }
            
            // If they do, we print a message and set the active pokemon to null
            System.out.println("You have retreated your active pokemon");
            player.setPlayerActive(null);

            // Check if the player has any Pokemon on the bench
            if (playerBench.size() > 0) 
            {
                // If they do, we set the first one on the bench as their new active pokemon
                active = (PokemonCard) playerBench.remove(0);
            } 
            
            else if(determineIfPokemonIsInHand(playerHand) == true)
            {
                // If they don't, we print a message and set the player as lost
                System.out.println("Please play a pokemon from your hand");
                return;
            }

            else 
            {
                // If they don't, we print a message and set the player as lost
                System.out.println("You have no pokemon to play in your hand");
            }
        } 

        else 
        {
            System.out.println("You do not have enough energy to retreat");
        }
    }
    
    /*
     * Checks if the player has enough energy to attack
     * @param PlayerMechanics player - The player whose turn it is
     * @return boolean - true if the player has enough energy, false otherwise
     */
    public boolean checkEnergy(PlayerMechanics player) 
    {
        
        // We get everything we need from the player, their active pokemon, the energy cards attached to it, 
        PokemonCard active = player.getPlayerActive();
        ArrayList<EnergyCard> attachedEnergy = active.getAttatchedEnergy();
        HashMap<String, Integer> requiredEnergy = active.getRequiredEnergy();

        // Count attached energy by type
        HashMap<String, Integer> energyCount = new HashMap<>();
        int totalEnergy = 0;

        // This segment of code essentially converts our attachedEnergy ArrayList into a HashMap that counts the number of energy cards attached by type
        for (EnergyCard energy : attachedEnergy) {
            String energyType = energy.getEnergyType();
            energyCount.put(energyType, energyCount.getOrDefault(energyType, 0) + 1);
            totalEnergy++;
        }

        // This segment of code checks if the player has enough energy for each type required by looping through the requiredEnergy HashMap
        for (Map.Entry<String, Integer> requirement : requiredEnergy.entrySet()) 
        {
            
            // Get the energy type and required amount
            String requiredType = requirement.getKey();
            int requiredAmount = requirement.getValue();
            
            // This segment of code checks if the amount of a specific type of energy is met
            if (!requiredType.equals("Normal")) 
            {
                int attachedAmount = energyCount.getOrDefault(requiredType, 0);
                
                // if the attached amount is less than the required amount, we print a message and return false
                if (attachedAmount < requiredAmount) 
                {
                    System.out.println("Not enough " + requiredType + " energy - need " + requiredAmount + ", have " + attachedAmount);
                    return false;
                }

            }

        }

        // This segment of code checks if the player has enough Normal energy for the attack
        int requiredNormal = requiredEnergy.getOrDefault("Normal", 0);
        int totalRequired = requiredNormal;
        for (int specificTypeAmount : requiredEnergy.values()) {
            if (specificTypeAmount != requiredNormal) {
                totalRequired += specificTypeAmount;
            }
        }

        // Compares the total amount normal energy attached to the active pokemon to the total amount of energy required for the attack
        if (totalEnergy < totalRequired) {
            System.out.println("Not enough total energy - need " + totalRequired + ", have " + totalEnergy);
            return false;
        }

        // If the player has enough energy and meets specific energy requirements, we print a message and return true
        return true;

    }

    /*
     * Check if the active pokemon has enough energy to retreat
     * @param PlayerMechanics player - The player whose turn it is
     * @return boolean - true if the player has enough energy, false otherwise
     */
    public boolean checkRetreatEnergy(PlayerMechanics player)
    {
        // We get everything we need from the player, their active pokemon, the energy cards attached to it, 
        PokemonCard active = player.getPlayerActive();
        HashMap<String, Integer> retreatCost = active.getRetreatCost();
        ArrayList<EnergyCard> attachedEnergy = active.getAttatchedEnergy();

        // We create a HashMap to count the number of energy cards attached by type
        HashMap<String, Integer> energyCount = new HashMap<>();

        // Count attached energy by type
        for (EnergyCard energy : attachedEnergy) 
        {
            // Get the energy type and increment the count
            String energyType = energy.getCardName(energy);
            energyCount.put(energyType, energyCount.getOrDefault(energyType, 0) + 1);
        }

        // Check if the player has enough energy for each type required by looping through the retreatCost HashMap
        for (Map.Entry<String, Integer> requirement : retreatCost.entrySet()) 
        {
            
            // Get the energy type and required amount
            String type = requirement.getKey();
            int required = requirement.getValue();
            int attached = energyCount.getOrDefault(type, 0);
        
            // If the energy type is "Normal", we check if the total attached energy is greater than or equal to the required amount
            if (type.equals("Normal")) 
            {
                int totalAttached = attachedEnergy.size();
                int totalRequired = required;
                
                if (totalAttached < totalRequired) 
                {
                    return false;
                }

            }
            
            // If the energy type is not "Normal", we check if the attached energy of that type is less than the required amount
            else if (attached < required) 
            {
                return false;
            }
        }

        return true;
    }

}
