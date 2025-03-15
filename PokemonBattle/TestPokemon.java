/*
 * Author: Alexis Lopez
 * Tests the stadium class and utilizes the Pokemon classes.
 */
package PokemonBattle;

public class TestPokemon {
    
    public static void main(String[] args) {
        
        // Create instances of Charmander
        Charmander charmanderSteve = new Charmander();

        // Create instances of Pikachu
        Pikachu geoff = new Pikachu();

        // Create instance of Stadium
        Stadium tester = new Stadium();

        // Test battle method
        tester.battle(charmanderSteve, geoff);

    }

}
