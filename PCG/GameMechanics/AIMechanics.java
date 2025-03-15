/*
 * Author: Alexis Lopez
 * This class handles all of the AI's game mechanics for the Pokemon card game.
 * It extends the PlayerMechanics class and the method contains the AI's logic for playing the game.
 * The AI will select the first available card for each stage of the game, such as playing a pokemon card, attatching an energy
 * playing a trainer card, and attacking if possible
 */

package PCG.GameMechanics;

import PCG.Cards.Card;
import PCG.Cards.EnergyCard;
import PCG.Cards.PokemonCard;
import PCG.Cards.TrainerCard;

public class AIMechanics extends PlayerMechanics {

    CardMechanics AICards = new CardMechanics();
    
    // AI logic for the game mechanics
    public boolean aiTurn(PlayerMechanics player, PlayerMechanics opponent) {
        System.out.println("AI is making a move...");

        // Check if deck is empty first
        if (player.getPlayerDeck().isEmpty()) 
        {
            System.out.println("AI's deck is empty. AI loses.");
            player.setLost(true);
            return false;
        }

        // AI's logic for setting the Ai's active pokemon
        if (player.getPlayerActive() == null)
        {

            Card selectedCard;
            int randomIndex;

            // Randomly select a Pokemon card from the AI's hand to be the active Pokemon
            do 
            {
                randomIndex = (int) (Math.random() * player.getPlayerHand().size());
                selectedCard = player.getPlayerHand().get(randomIndex);
            } 
            while (!(selectedCard instanceof PokemonCard));
            
            player.setPlayerActive((PokemonCard) selectedCard);
            player.getPlayerHand().remove(randomIndex);
        }

        System.out.println("AI has selected " + player.getPlayerActive().getName() + " as the active Pokemon.");

        // AI's logic for playing an energy card
        for(int i = 0; i < player.getPlayerHand().size(); i++)
        {
            if(player.getPlayerHand().get(i) instanceof EnergyCard)
            {
                
                AICards.playEnergy(player, i);
                break;
                
            }
        }

        //Ai's logic for playing a trainer card
        for(int i = 0; i < player.getPlayerHand().size(); i++)
        {
            if(player.getPlayerHand().get(i) instanceof TrainerCard)
            {
                
                AICards.playTrainer(player, i);
                break;
                
            }
        }

        // Ai's logic for benching pokemon
        if (player.getPlayerBench().size() < 5) 
        {
            for (int i = 0; i < player.getPlayerHand().size(); i++) 
            {
                if (player.getPlayerHand().get(i) instanceof PokemonCard) 
                {
                    AICards.benchPokemon(player, i);
                    break;
                }
            }
        }

        // AI's logic for attacking
        if (player.getPlayerActive() != null) 
        {
            AICards.attack(player, opponent);
        } 
        else 
        {
            System.out.println("AI has no active Pokemon to attack with.");
        }

        return true;

    }
    

}
