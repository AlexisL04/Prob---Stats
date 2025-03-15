/*
 * Author: Alexis Lopez
 * The PlayerMechanics class contains methods and variables needed for the player to play the game
 * Also contains methods to handle players decks, display them, and handle the player's turn
 */

package PCG.GameMechanics;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import PCG.Cards.Card;
import PCG.Cards.PokemonCard;

public class PlayerMechanics {

    // All the variables needed to create a player
    //The playerCard object is used to call the methods in the CardMechanics class
    CardMechanics playerCard = new CardMechanics();
    
    private ArrayList<Card> playerDeck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> playerBench;
    private ArrayList<Card> playerDiscard;
    private ArrayList<Card> playerPrize;
    private PokemonCard playerActive;
    boolean isLost;

    /*
     * Constructor for the PlayerMechanics class, initializes the playerDeck, playerHand, playerBench, playerDiscard, and playerPrize
     * @param none
     * @return none
     */
    public PlayerMechanics() {

        playerDeck = playerCard.populateDeck();
        playerBench = playerCard.initializeEmptyPile();
        playerDiscard = playerCard.initializeEmptyPile();
        playerPrize = playerCard.populatePrizePile(playerDeck);

        playerHand = playerCard.populateHand(playerDeck);

        isLost = false;
    }

    /*
     * This method simulates a player's turn
     * @param player the player object
     * @param opponent the opponent object
     * @return true if the turn is over, false otherwise
     */
    public Boolean playerTurn (PlayerMechanics player, PlayerMechanics opponent){

        Scanner in = new Scanner(System.in);

        //Booleans needed to check if the player has ended their turn or has placed an energy card
        Boolean endTurn = false;
        Boolean placedEnergy = false;

        //Checks if the player deck is empty, if it is, ends the game
        if(player.getPlayerDeck().isEmpty()){
            System.out.println("You have no cards left in your deck. You lose.");
            player.setLost(true);
            endTurn = true;
            return true;
        }

        //Draws a card for the player and displays their hand
        System.out.println("You draw a card:");
        playerCard.drawCard(playerDeck, playerHand);
        System.out.println("Your new hand: " + displayHand());

        //Checks if the player has an active pokemon, if not, prompts them to play one
        if(player.getPlayerActive() == null)
        {
            System.out.println("You have no active pokemon. Please play a pokemon");
        }

        //Checks if the player has an active pokemon, if they do, displays it
        else 
        {
            System.out.println("Your current active pokemon: " + player.getPlayerActive().getName());
        }

        //Loops until the player ends their turn
        //Allows the player to play cards from their hand, attack, retreat, and end their turn
        while(!endTurn)
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("How will you play your turn? (Enter corresponding #):");
            System.out.println("1) Play an energy card from your hand");
            System.out.println("2) Play a trainer card from your hand");
            System.out.println("3) Play a pokemon card from your hand");
            System.out.println("4) Bench pokemon from your hand");
            System.out.println("5) Attack with your active pokemon");
            System.out.println("6) Retreat your active pokemon");
            System.out.println("7) End your turn");
            System.out.println("8) Check hand");
            System.out.println("9) Check active");
            System.out.println("------------------------------------------------------------------------");
            
            //Gets the player's choice and executes the corresponding action
            int choice = in.nextInt();

            switch(choice)
            {
                case 1:

                    //Checks if the player has already played an energy card this turn
                    if(placedEnergy == true)
                    {
                        //If the player has already played an energy card, they cannot play another one
                        System.out.println("You have already played an energy card this turn");
                        break;
                    }

                    //Allows for the user to play an energy card if they havent already. prompts them to choose what card
                    System.out.println("You have decided to play an energy card from your hand. If you want to cancel this action, please enter -1");
                    System.out.println("Please enter the index of the energy card you would like to play (0 to n)");
                    System.out.println("Your current hand: " + displayHand());

                    //Gets the player's choice
                    int energyChoice = in.nextInt();

                    //Checks if the player has cancelled their action
                    if(energyChoice == -1)
                    {
                        System.out.println("You have cancelled your action");
                        break;
                    }

                    //checks if the player chose an invalid option
                    else if(energyChoice < 0 || energyChoice >= playerHand.size())
                    {
                        System.out.println("Invalid choice, please try again");
                        break;
                    }

                    //attatches the energy card to the active pokemon
                    playerCard.playEnergy(player, energyChoice);
                    placedEnergy = true;

                    break;
                case 2:
                    
                    //prompts the user to play a trainer card
                    System.out.println("Which trainer card would you like to play? (Enter the index of the card 0 to n) or to cancel, enter -1");
                    System.out.println("Your current hand: " + displayHand());

                    //Gets the player's choice
                    int trainerChoice = in.nextInt();

                    //Checks if the player has cancelled their action
                    if(trainerChoice == -1)
                    {
                        System.out.println("You have cancelled your action");
                        break;
                    }
                    
                    //Checks if the player chose an invalid option
                    else if(trainerChoice < 0 || trainerChoice >= playerHand.size())
                    {
                        System.out.println("Invalid choice, please try again");
                        break;
                    }

                    //plays the trainer card
                    playerCard.playTrainer(player, trainerChoice);

                    break;

                case 3:

                    //Checks to see if the player has any pokemon in active field
                    if(player.getPlayerActive() != null)
                    {
                        System.out.println("You already have an active pokemon. Please bench the pokemon you want to play");
                        break;
                    }
                    //Checks if the player has any pokemon in their hand
                    if(playerCard.determineIfPokemonIsInHand(playerHand) == false)
                    {
                        System.out.println("There is no pokemon in your hand");
                        break;
                    }
                    
                    //if so, prompts them to play a pokemon card
                    System.out.println("Which pokemon card would you like to play? (Enter the index of the card 0 to n) or to cancel, enter -1");
                    System.out.println("Your current hand: " + displayHand());
                    
                    //Gets the player's choice
                    int pokemonChoice = in.nextInt();
                    
                    //Checks if the player has cancelled their action
                    if(pokemonChoice == -1)
                    {
                        System.out.println("You have cancelled your action");
                        break;
                    }
                    
                    //Checks if the player chose an invalid option
                    else if(pokemonChoice < 0 || pokemonChoice >= playerHand.size())
                    {
                        System.out.println("Invalid choice, please try again");
                        break;
                    }
                
                    //Plays the pokemon card
                    playerCard.playPokemon(player, pokemonChoice);
                    break;
                
                case 4:
                    
                    //Checks if the player has any pokemon in their hand
                    if(playerCard.determineIfPokemonIsInHand(playerHand) == false)
                    {
                        System.out.println("There is no pokemon in your hand");
                        break;
                    }

                    //Checks if the player bench is full
                    else if(playerBench.size() >= 5)
                    {
                        System.out.println("You cannot bench more than 5 pokemon");
                        break;
                    }
                
                    //if so, prompts them to bench a pokemon card
                    System.out.println("You benched a pokemon from your hand");
                    System.out.println("your current bench is: " + playerBench.size() + "/5");
                    System.out.println("Which pokemon card would you like to bench? (Enter the index of the card 0 to n) or to cancel, enter -1");
                    System.out.println("Your current hand: " + displayHand());
                    
                    //Gets the player's choice
                    int benchChoice = in.nextInt();

                    //Checks if the player has cancelled their action
                    if(benchChoice == -1)
                    {
                        System.out.println("You have cancelled your action");
                        break;
                    }
                    
                    //Checks if the player chose an invalid option
                    else if(benchChoice < 0 || benchChoice >= playerHand.size())
                    {
                        System.out.println("Invalid choice, please try again");
                        break;
                    }
                    
                    //Benches the pokemon card
                    playerCard.benchPokemon(player, benchChoice);
                    break;

                case 5:
                
                    //Checks if the player has any pokemon in their hand
                    if(player.getPlayerActive() == null)
                    {
                        System.out.println("You have no active pokemon. Please play a pokemon card first");
                        break;
                    }

                    //if so, attacks their opponents pokemon and ends turn
                    System.out.println("You attacked with your active pokemon");
                    playerCard.attack(player, opponent);
                    endTurn = true;
                    break;

                case 6:
                    
                    //Checks if the player has any pokemon in their hand
                    if(player.getPlayerActive() == null)
                    {
                        System.out.println("You have no active pokemon. Please play a pokemon card first");
                        break;
                    }

                    //if so, retreats their active pokemon and ends turn
                    playerCard.retreat(player);
                    break;

                case 7:
                    //Ends the player's turn
                    endTurn = true;
                    break;

                case 8:
                    //Displays the player's hand
                    System.out.println("Your current hand: " + displayHand());
                    break;
                
                case 9:
                    //Displays the player's active pokemon if they have one
                    if(player.getPlayerActive() == null)
                    {
                        System.out.println("You have no active pokemon. Please play a pokemon card first");
                        break;
                    }
                    System.out.println("Your current active pokemon: " + player.getPlayerActive().getName());
                    break;
            }

        }
        

        return true;
    }

    /*
     * This method sets the active pokemon for the player
     * @param active PokemonCard they wish to have as active
     * @return none
     */
    public void setPlayerActive(PokemonCard active) {
        playerActive = active;
    }

    /*
     * This method gets the active pokemon for the player
     * @param none
     * @return players active pokemon
     */
    public PokemonCard getPlayerActive() {
        return playerActive;
    }

    /*
     * This method gets the player's deck
     * @param none
     * @return the player's deck
     */
    public ArrayList<Card> getPlayerDeck() {
        return playerDeck;
    }

    /*
     * This method gets the player's hand
     * @param none
     * @return the player's hand
     */
    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    /*
     * This method gets the player's bench
     * @param none
     * @return the player's bench
     */
    public ArrayList<Card> getPlayerBench() {
        return playerBench;
    }

    /*
     * This method gets the player's discard pile
     * @param none
     * @return the player's discard pile
     */
    public ArrayList<Card> getPlayerDiscard() {
        return playerDiscard;
    }

    /*
     * This method gets the player's prize pile
     * @param none
     * @return the player's prize pile
     */
    public ArrayList<Card> getPlayerPrize() {
        return playerPrize;
    }

    /*
     * This method sets the players win condition
     * @param decision true if the player has lost, false otherwise
     * @return none
     */
    public void setLost(boolean decision) {
        isLost = decision;
    }

    /*
     * This method gets the player's win condition
     * @param none
     * @return true if the player has lost, false otherwise
     */
    public boolean getPlayerLost(){
        return isLost;
    }

    /*
     * This method flips a coin and returns the result
     * @param none
     * @return "Heads" or "Tails" as a string
     */
    public String coinFlip() 
    {
        
        Random rand = new Random();

        if (rand.nextInt(2) == 0) 
        {
            return "Heads";
        } 

        return "Tails";

    }

    /*
     * This method displays the player's hand using string builder
     * @param none
     * @return the player's hand as a string
     */
    private String displayHand() 
    {
        
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        
        for (int i = 0; i < playerHand.size(); i++) {
            
            sb.append(i).append(": ").append(playerHand.get(i).getCardName(playerHand.get(i)));
            
            if (i < playerHand.size() - 1) {
                sb.append("\n");
            }

        }
        
        return sb.toString();
    }
    
}
