package PCG.GameMechanics;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import PCG.Cards.Card;
import PCG.Cards.PokemonCard;

public class PlayerMechanics {

    CardMechanics playerCard = new CardMechanics();
    
    private ArrayList<Card> playerDeck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> playerBench;
    private ArrayList<Card> playerDiscard;
    private ArrayList<Card> playerPrize;
    private PokemonCard playerActive;
    boolean isLost;

    public PlayerMechanics() {

        playerDeck = playerCard.populateDeck();
        playerBench = playerCard.initializeEmptyPile();
        playerDiscard = playerCard.initializeEmptyPile();
        playerPrize = playerCard.populatePrizePile(playerDeck);

        playerHand = playerCard.populateHand(playerDeck);

        isLost = false;
    }

    public Boolean playerTurn (PlayerMechanics player, PlayerMechanics opponent){

        Scanner in = new Scanner(System.in);

        Boolean endTurn = false;
        Boolean placedEnergy = false;
        //Add retreat functionality

        if(player.getPlayerDeck().isEmpty()){
            System.out.println("You have no cards left in your deck. You lose.");
            player.setLost(true);
            endTurn = true;
        }
        System.out.println("You draw a card:");
        playerCard.drawCard(playerDeck, playerHand);
        System.out.println("Your new hand: " + displayHand());

        if(player.getPlayerActive() == null)
        {
            System.out.println("You have no active pokemon. Please play a pokemon");
        }

        else 
        {
            System.out.println("Your current active pokemon: " + player.getPlayerActive().getName());
        }

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
            
            int choice = in.nextInt();

            switch(choice)
            {
                case 1:

                    if(placedEnergy == true)
                    {
                        System.out.println("You have already played an energy card this turn");
                        break;
                    }

                    System.out.println("You have decided to play an energy card from your hand. If you want to cancel this action, please enter -1");
                    System.out.println("Please enter the index of the energy card you would like to play (0 to n)");
                    System.out.println("Your current hand: " + displayHand());

                    int energyChoice = in.nextInt();

                    if(energyChoice == -1)
                    {
                        System.out.println("You have cancelled your action");
                        break;
                    }
                    else if(energyChoice < 0 || energyChoice >= playerHand.size())
                    {
                        System.out.println("Invalid choice, please try again");
                        break;
                    }

                    playerCard.playEnergy(player, energyChoice);
                    placedEnergy = true;

                    break;
                case 2:
                    System.out.println("Which trainer card would you like to play? (Enter the index of the card 0 to n) or to cancel, enter -1");
                    System.out.println("Your current hand: " + displayHand());


                    int trainerChoice = in.nextInt();

                    if(trainerChoice == -1)
                    {
                        System.out.println("You have cancelled your action");
                        break;
                    }
                    
                    else if(trainerChoice < 0 || trainerChoice >= playerHand.size())
                    {
                        System.out.println("Invalid choice, please try again");
                        break;
                    }

                    playerCard.playTrainer(player, trainerChoice);

                    break;

                case 3:

                    if(player.getPlayerActive() != null)
                    {
                        System.out.println("You already have an active pokemon. Please bench the pokemon you want to play");
                        break;
                    }
                    
                    System.out.println("Which pokemon card would you like to play? (Enter the index of the card 0 to n) or to cancel, enter -1");
                    System.out.println("Your current hand: " + displayHand());
                    
                    int pokemonChoice = in.nextInt();
                    
                    if(pokemonChoice == -1)
                    {
                        System.out.println("You have cancelled your action");
                        break;
                    }
                    
                    else if(pokemonChoice < 0 || pokemonChoice >= playerHand.size())
                    {
                        System.out.println("Invalid choice, please try again");
                        break;
                    }
                    
                    else if(playerCard.determineIfPokemonIsInHand(playerHand) == false)
                    {
                        System.out.println("You cannot play that card");
                        break;
                    }

                    playerCard.playPokemon(player, pokemonChoice);

                    break;
                
                case 4:
                    
                    if(playerCard.determineIfPokemonIsInHand(playerHand) == false)
                    {
                        System.out.println("There is no pokemon in your hand");
                        break;
                    }

                    else if(playerBench.size() >= 5)
                    {
                        System.out.println("You cannot bench more than 5 pokemon");
                        break;
                    }
                
                    System.out.println("You benched a pokemon from your hand");
                    System.out.println("your current bench is: " + playerBench.size() + "/5");
                    System.out.println("Which pokemon card would you like to bench? (Enter the index of the card 0 to n) or to cancel, enter -1");
                    System.out.println("Your current hand: " + displayHand());
                    
                    int benchChoice = in.nextInt();

                    if(benchChoice == -1)
                    {
                        System.out.println("You have cancelled your action");
                        break;
                    }
                    
                    else if(benchChoice < 0 || benchChoice >= playerHand.size())
                    {
                        System.out.println("Invalid choice, please try again");
                        break;
                    }
                    
                    playerCard.benchPokemon(player, benchChoice);
                    
                    break;

                case 5:
                
                    if(player.getPlayerActive() == null)
                    {
                        System.out.println("You have no active pokemon. Please play a pokemon card first");
                        break;
                    }

                    System.out.println("You attacked with your active pokemon");

                    //needs to check if the attatched energy matches the attack cost
                    playerCard.attack(player, opponent);
                    endTurn = true;
                    break;

                case 6:
                    
                    if(player.getPlayerActive() == null)
                    {
                        System.out.println("You have no active pokemon. Please play a pokemon card first");
                        break;
                    }

                    playerCard.retreat(player);
                    break;

                case 7:
                    endTurn = true;
                    break;

                case 8:
                    System.out.println("Your current hand: " + displayHand());
                    break;
                
                case 9:
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

    


    public void setPlayerActive(PokemonCard active) {
        playerActive = active;
    }

    public PokemonCard getPlayerActive() {
        return playerActive;
    }

    public ArrayList<Card> getPlayerDeck() {
        return playerDeck;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getPlayerBench() {
        return playerBench;
    }

    public ArrayList<Card> getPlayerDiscard() {
        return playerDiscard;
    }

    public ArrayList<Card> getPlayerPrize() {
        return playerPrize;
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }

    public boolean getPlayerLost(){
        return isLost;
    }

    public String coinFlip() 
    {
        
        Random rand = new Random();

        if (rand.nextInt(2) == 0) 
        {
            return "Heads";
        } 

        return "Tails";

    }

    private String displayHand() {
        
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
