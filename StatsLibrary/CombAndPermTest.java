/*
 * Author: Alexis Lopez
 * The CombAndPermTest class contains the main method to test the methods in the CombAndPerm class.
 * The class prints out the results of the combination, permutation, and binomial distribution methods.
 */

package StatsLibrary;

public class CombAndPermTest {
    public static void main(String[] args) {
        
        CombAndPerm test = new CombAndPerm();
       
        System.out.println("Combination: 5 choose 2");
        System.out.println(test.getCombination(5, 2) + "\n");
       
        System.out.println("Permutation: 5 choose 2");
        System.out.println(test.getPermutation(5, 2) + "\n"); 

        System.out.println("Binomial Distribution: Trials 10 - Successes 7 - Probability of Success .8 ");
        System.out.println("Probability: " + test.getBinomialDistribution(10, 7, .8));

        System.out.println("Expected: " + test.getBinomialDistributionExpected(10, .8));

        System.out.println("Variance: " + test.getBinomialDistributionVariance(10, .8));

        System.out.println("STD: " + test.getBinomialDistributionStandardDeviation(10, .8));

        System.out.println("Geometric Distribution: Trials 10 - Probability of Success .8\n");
        System.out.println("Probability: " + test.getGeometricDistribution(.8, 10));

        System.out.println("Expected: " + test.getGeometricDistributionExpected(.8));

        System.out.println("Variance: " + test.getGeometricDistributionVariance(.8));

        System.out.println("STD: " + test.getGeometricDistributionStandardDeviation(.8));

        System.out.println("On or Before: " + test.onOrBeforeGeometricDistribution(.8, 5));

        System.out.println("Before: " + test.beforeGeometricDistribution(.8, 5));

        System.out.println("On or After: " + test.onOrAfterGeometricDistribution(.8, 5));

        System.out.println("After: " + test.afterGeometricDistribution(.8, 5));

        System.out.println("HyperGeometric Distribution: Population 10 - Sample 3 - Successes in Population 5 - Sample Size 2\n");
        System.out.println("Probability: " + test.getHyperGeometricDistribution(10, 3, 5, 2));

        System.out.println("Expected: " + test.getHyperGeometricExpected(10, 3, 5));

        System.out.println("Variance " + test.getHyperGeometricVariance(10, 3, 5));

        System.out.println("STD: " + test.getHyperGeometricStandardDeviation(10, 3, 5));

        System.out.println("Negative Binomial Distribution: Trials 10 - Successes 5 - Probability of Success .3 - Probability of Failure .7\n");
        System.out.println("Probability: " + test.getNegativeBinomialDistribution(10, 5, .3, .7));

        System.out.println("Expected: " + test.getNegativeBinomialDistributionExpected(5, .3));

        System.out.println("Variance: " + test.getNegativeBinomialDistributionVariance(5, .3));

        System.out.println("STD: " + test.getNegativeBinomialDistributionStandardDeviation(5, .3));
    }
}
