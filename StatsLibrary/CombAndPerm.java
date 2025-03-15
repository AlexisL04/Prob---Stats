/*
 * Author: Alexis Lopez
 * The CombAndPerm class contains methods and variables needed to calculate the combinations and permutations of a given set of numbers.
 * The class can:
 * - Find the factorial of a given number
 * - Find the combination of two given numbers
 * - Find the permutation of two given numbers
 * This class also contains methods for equations we have so far learned in chapter 3 of the textbook
 */

package StatsLibrary;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class CombAndPerm {


    //A method to find the factorial of a given number using BigInteger
    //@param n the number to find the factorial of
    //@return the factorial of the given numbe
    public BigInteger findFactorial(int n)
    {
        if (n == 0)
        {
            return BigInteger.ONE;
        }
       
        return BigInteger.valueOf(n).multiply(findFactorial(n-1));

    }

    //A method to find the combination of two given numbers using the formula n!/(r!(n-r)!)
    //@param n the first given
    //@param r the second given number
    //@return the combination of the two numbers
    public BigInteger getCombination(int n, int r)
    {

        // n! / (r!(n-r)!)
        return findFactorial(n).divide((findFactorial(r).multiply(findFactorial(n-r))));

    }

    //A method to find the permutation of two given numbers using the formula n!/(n-r)!
    //@param n the first given number
    //@param r the second given number
    //@return the permutation of the two numbers
    public BigInteger getPermutation (int n, int r)
    {

        // n! / (n-r)!
        return findFactorial(n).divide(findFactorial(n-r));

    }

    //A method to find the binomial distribution of two given numbers using the formula C(n/r) * p^r * (1-p)^(n-r)
    //@param n the number of trials
    //@param x the number of successful trials
    //@param p the probability of success on a single trial
    //@return the binomial distribution
    public BigDecimal getBinomialDistribution(int n, int x, double p)
    {
        // C(n choose x)
        // Find the combination of n and x
        BigInteger a = getCombination(n, x);

        // p^x
        // Find the power of p to x
        double b = Math.pow(p, x);

        //  (q)^(n-x)
        // Find the power of q (probability of failure or 1-p) to n-x
        double c = Math.pow((1-p), (n-x));

        BigDecimal result = new BigDecimal(a).multiply(BigDecimal.valueOf(b)).multiply(BigDecimal.valueOf(c));

        return result;

    }

    /*
     * A method to find the expected value of a binomial distribution using the formula n*p
     * @param n the number of trials
     * @param p the probability of success on a single trial
     * @return the expected value of the binomial distribution
     */
    public double getBinomialDistributionExpected(double n, double p)
    {
        return n * p;
    }

    /*
     * A method to find the variance of a binomial distribution using the formula n*p*(1-p)
     * @param n the number of trials
     * @param p the probability of success on a single trial
     * @return the variance of the binomial distribution
     */
    public double getBinomialDistributionVariance(double n, double p)
    {
        return n * p * (1 - p);
    }

    /*
     * A method to find the standard deviation of a binomial distribution using the formula sqrt(n*p*(1-p))
     * @param n the number of trials
     * @param p the probability of success on a single trial
     * @return the standard deviation of the binomial distribution
     */
    public double getBinomialDistributionStandardDeviation(double n, double p)
    {
        double variance = getBinomialDistributionVariance(n, p);
        return Math.sqrt(variance);
    }

    /*
     * A method to find the geometric distribution of a given probability and number of trials using the formula (1-p)^(y-1) * p 
     * @param p the probability of success on a single trial
     * @param y the number of trials
     * @return the geometric distribution
     */    
    public double getGeometricDistribution(double p, double y)
    {
        double distribution = Math.pow((1-p), (y-1)) * p;
        return distribution; 
    }

    /*
     * A method to find the expected value of a geometric distribution using the formula 1/p
     * @param p the probability of success on a single trial
     * @return the expected value of the geometric distribution
     */
    public double getGeometricDistributionExpected(double p)
    {
        return 1/p;
    }

    /*
     * A method to find the variance of a geometric distribution using the formula (1-p)/p^2
     * @param p the probability of success on a single trial
     * @return the variance of the geometric distribution
     */
    public double getGeometricDistributionVariance(double p)
    {
        return (1-p) / Math.pow(p, 2);
    }

    /*
     * A method to find the standard deviation of a geometric distribution using the formula sqrt((1-p)/p^2)
     * @param p the probability of success on a single trial
     * @return the standard deviation of the geometric distribution
     */
    public double getGeometricDistributionStandardDeviation(double p)
    {
        double variance = getGeometricDistributionVariance(p);
        return Math.sqrt(variance);
    }

    /*
     * A method to find the probability of a geometric distribution on or before a given number of trials using the formula 1-(1-p)^n
     * @param p the probability of success on a single trial
     * @param n the number of trials
     * @return the probability of the geometric distribution on or before a given number of trials
     */
    public double onOrBeforeGeometricDistribution(double p, double n)
    {
        return 1 - Math.pow((1-p), n);
    }

    /*
     * A method to find the probability of a geometric distribution on or after a given number of trials using the formula (1-p)^(n-1)
     * @param p the probability of success on a single trial
     * @param n the number of trials
     * @return the probability of the geometric distribution on or after a given number of trials
     */
    public double beforeGeometricDistribution(double p, double n)
    {
        return 1 - Math.pow((1-p), (n-1));
    }

    /*
     * A method to find the probability of a geometric distribution on or after a given number of trials using the formula (1-p)^(n-1)
     * @param p the probability of success on a single trial
     * @param n the number of trials
     * @return the probability of the geometric distribution on or after a given number of trials
     */
    public double onOrAfterGeometricDistribution(double p, double n)
    {
        return Math.pow((1-p), (n-1));
    }

    /*
     * A method to find the probability of a geometric distribution after a given number of trials using the formula (1-p)^n
     * @param p the probability of success on a single trial
     * @param n the number of trials
     * @return the probability of the geometric distribution after a given number of trials
     */
    public double afterGeometricDistribution(double p, double n)
    {
        return Math.pow((1-p), n);
    }

    /*
     * A method to find the hypergeometric distribution of a given probability and number of trials using the formula C(r,y) * C(N-r,n-y) / C(N,n)
     * @param N the population size
     * @param n the sample size
     * @param r the number of successes in the population
     * @param y the number of successes in the sample
     * @return the hypergeometric distribution
     */
    public BigDecimal getHyperGeometricDistribution(int N, int n, int r, int y)
    {

        // C(r,y)
        BigInteger comb1 = getCombination(r, y);

        // C(N-r,n-y)
        BigInteger comb2 = getCombination(N-r, n-y);

        //multiply the two combinations
        BigInteger numerator = comb1.multiply(comb2);

        // C(N,n)
        BigInteger denominator = getCombination(N, n);

        //divide the numerator by the denominator, if zero, return null
        if (denominator.equals(BigInteger.ZERO))
        {
            System.out.println("Cannot divide by zero");
            return null;
        }

        //divide the numerator by the denominator and return the result
        return new BigDecimal(numerator).divide(new BigDecimal(denominator), 3, RoundingMode.HALF_UP);

    }

    /*
     * A method to find the expected value of a hypergeometric distribution using the formula (n*r)/N
     * @param N the population size
     * @param n the sample size
     * @param r the number of successes in the population
     * @return the expected value of the hypergeometric distribution
     */
    public BigDecimal getHyperGeometricExpected(int N, int n, int r)
    {
        return BigDecimal.valueOf((double)(n*r)/ (double)N);
    }

    /*
     * A method to find the variance of a hypergeometric distribution using the formula n * (r/n) * ((N-r)/N) * ((N-n)/(N-1))
     * @param N the population size
     * @param n the sample size
     * @param r the number of successes in the population
     * @return the variance of the hypergeometric distribution
     */
    public BigDecimal getHyperGeometricVariance(int N, int n, int r)
    {
        return BigDecimal.valueOf(( (double)n * (double)(r/n) * (double)((N-r)/N) * (double)((N-n)/(N-1)) ) );
    }

    /*
     * A method to find the standard deviation of a hypergeometric distribution using the formula:
     * sqrt(n * (r/n) * ((N-r)/N) * ((N-n)/(N-1)))
     * @param N the population size
     * @param n the sample size
     * @param r the number of successes in the population
     * @return the standard deviation of the hypergeometric distribution
     */
    public BigDecimal getHyperGeometricStandardDeviation(int N, int n, int r)
    {
        double variance = getHyperGeometricVariance(N, n, r).doubleValue();
        return BigDecimal.valueOf(Math.sqrt(variance));
    }

    /*
     * A method to find the negative binomial distribution of a given probability and number of trials using the formula:
     * C(y-1,r-1) * p^r * (1-p)^(y-r)
     * @param y the number of trials
     * @param r the number of successes
     * @param p the probability of success on a single trial
     * @param q the probability of failure on a single trial
     * @return the negative binomial distribution
     */
    public BigDecimal getNegativeBinomialDistribution( int y, int r, double p, double q)
    {
        BigDecimal comb = new BigDecimal(getCombination(y-1, r-1));

        double result = comb.doubleValue() * Math.pow(p, r) * Math.pow(q, y-r);

        return BigDecimal.valueOf(result);
    }

    /*
     * A method to find the expected value of a negative binomial distribution using the formula r/p
     * @param r the number of successes
     * @param p the probability of success on a single trial
     * @return the expected value of the negative binomial distribution
     */
    public double getNegativeBinomialDistributionExpected(int r, double p)
    {
        return (r/p);
    }

    /*
     * A method to find the variance of a negative binomial distribution using the formula r(1-p)/p^2
     * @param r the number of successes
     * @param p the probability of success on a single trial
     * @return the variance of the negative binomial distribution
     */
    public double getNegativeBinomialDistributionVariance(int r, double p)
    {
        return (r * (1-p)) / Math.pow(p, 2);
    }

    /*
     * A method to find the standard deviation of a negative binomial distribution using the formula sqrt(r(1-p)/p^2)
     * @param r the number of successes
     * @param p the probability of success on a single trial
     * @return the standard deviation of the negative binomial distribution
     */
    public double getNegativeBinomialDistributionStandardDeviation(int r, double p)
    {
        double variance = getNegativeBinomialDistributionVariance(r, p);
        return Math.sqrt(variance);
    }

}
