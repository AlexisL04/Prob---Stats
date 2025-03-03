package PokemonBattle;

public class Stadium {
    
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
