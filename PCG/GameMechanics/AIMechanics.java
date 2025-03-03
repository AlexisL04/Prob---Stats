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

            do {
                randomIndex = (int) (Math.random() * player.getPlayerHand().size());
                selectedCard = player.getPlayerHand().get(randomIndex);
            } while (!(selectedCard instanceof PokemonCard));
            
            player.setPlayerActive((PokemonCard) selectedCard);
            player.getPlayerHand().remove(randomIndex);
        }

        System.out.println("AI has selected " + player.getPlayerActive().getName() + " as the active Pokemon.");

        // AI's logic for playing an energy card
        for(int i = 0; i < player.getPlayerHand().size(); i++){
            if(player.getPlayerHand().get(i) instanceof EnergyCard){
                
                AICards.playEnergy(player, i);
                break;
                
            }
        }

        //Ai's logic for playing a trainer card

        // AI's logic for playing an energy card
        for(int i = 0; i < player.getPlayerHand().size(); i++){
            if(player.getPlayerHand().get(i) instanceof TrainerCard){
                
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
