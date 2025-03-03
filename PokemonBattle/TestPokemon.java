package PokemonBattle;

public class TestPokemon {
    
    public static void main(String[] args) {
        
        Charmander charmanderSteve = new Charmander();

        
        Pikachu geoff = new Pikachu();


        Stadium tester = new Stadium();

        tester.battle(charmanderSteve, geoff);

    }

}
