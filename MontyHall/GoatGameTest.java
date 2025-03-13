/*
 * Author: Alexis Lopez
 * This is a simulation of the Monty Hall problem we have discussed in our Probability and Statistics class.
 * This program simulates the game where a contestant chooses one of the three available doors, 1 being a prize and the others being goats.
 * The contestant can either stick with their original choice, or choose to change their choice after one of the doors is revealed to be a goat.
 * We simulate these two choices and see which one is more likely to win the prize.
 * The results are then printed out to the console.
 */

 /*
  * Question A
  * P(gPrize) = 1/3
  * P(goat1) = 1/3
  * P(goat2) = 1/3
  * The probability of picking the correct prize on the first go is .33
  */

  /*
   * Question B
   * P(gPrize) = 1/3
   * If she had initially picked the good prize and then switched over, she would lose as the other prize would be a dud
   * If she had initially chosen a dud, and another door was revealed to be a dud. If she had switched, she would win the prize.
   * If she had initially chosen a dud, her probability of winning the prize is 2/3
   * In order to maximize their probability of winning, it is better to swap doors than to keep the same door.
   */

package MontyHall;

public class GoatGameTest 
{
    
    public static void main(String[] args) 
    {
        GoatGame game = new GoatGame();
        System.out.println(game.noChange(10000));
        System.out.println(game.withChange(10000));
    }

}
