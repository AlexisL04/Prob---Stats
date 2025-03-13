/*
 * Author: Alexis Lopez
 * The CombAndPermTest class contains the main method to test the methods in the CombAndPerm class.
 * The class prints out the results of the combination, permutation, and binomial distribution methods.
 */

package StatsLibrary;
import java.math.BigInteger;

public class CombAndPermTest {
    public static void main(String[] args) {
        
        CombAndPerm test = new CombAndPerm();
       
        System.out.println(test.getCombination(BigInteger.valueOf(5), BigInteger.valueOf(2)));
       
        System.out.println(test.getPermutation(BigInteger.valueOf(5),BigInteger.valueOf(2))); 

        System.out.println(test.getBinomialDistribution(10, 7, .8));
    }
}
