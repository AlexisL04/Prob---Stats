/*
 * Author: Alexis Lopez
 * This class represents a Stadium where two Pokemon can battle.
 */
package PokemonBattle;

public class Stadium {
    
    /*
     * Method to battle two pokemon
     * The pokemon with the higher speed attacks first, loser is determined by which pokemon has 0 or less HP
     * @parameter p1 the first pokemon
     * @parameter p2 the second pokemon
     * @return void
     */
    public void battle(Pokemon p1, Pokemon p2){

        while (p1.getHp() > 0 && p2.getHp() > 0){

            if (p1.getSpeed() > p2.getSpeed()){

                p2.setHp(p2.getHp() - p1.getAttack());

            }

            else{

                p1.setHp(p1.getHp() - p2.getAttack());

            }

        }

        if(p1.getHp() > 0){
            System.err.println("Pikachu has won the battle");
        }

        else{
            System.out.println("Charmander has won the battle");
        }
    
    }

}
