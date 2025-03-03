package StatsLibrary;
import java.math.BigInteger;

public class CombAndPerm {


    //A method to find the factorial of a given number using BigInteger
    //@param n the number to find the factorial of
    //@return the factorial of the given numbe
    public BigInteger findFactorial(BigInteger n)
    {
        //Sets the result automatically to 1 as if n is 0, the result will be 1
        BigInteger result = BigInteger.ONE;

        //A for loop to find the factorial of a a given number. Starts from 1 and goes up to the given number
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE))
        {
            //multiplies result with the current value of i
            result = result.multiply(i);
        }

        //The factorial of a given number
        return result;
    }

    //A method to find the combination of two given numbers using the formula n!/(r!(n-r)!)
    //@param n the first given
    //@param r the second given number
    //@return the combination of the two numbers
    public BigInteger getCombination(BigInteger n, BigInteger r)
    {

        // n! / (r!(n-r)!)
        return findFactorial(n).divide((findFactorial(r).multiply(findFactorial(n.subtract(r)))));

    }

    //A method to find the permutation of two given numbers using the formula n!/(n-r)!
    //@param n the first given number
    //@param r the second given number
    //@return the permutation of the two numbers
    public BigInteger getPermutation (BigInteger n, BigInteger r)
    {

        // n! / (n-r)!
        return findFactorial(n).divide(findFactorial(n.subtract(r)));

    }

    //A method to find the binomial distribution of two given numbers using the formula C(n/r) * p^r * (1-p)^(n-r)
    //@param n the number of trials
    //@param x the number of successful trials
    //@param p the probability of success on a single trial
    //@return the binomial distribution of the two numbers
    public BigInteger getBinomialDistribution(BigInteger n, BigInteger x, BigInteger p)
    {
        // C(n/r)
        // Find the combination of n and x
        BigInteger a = getCombination(n, x);

        // p^x
        // Find the power of p to x
        BigInteger b = BigInteger.valueOf((long) Math.pow(p.doubleValue(), x.doubleValue()));

        //  (q)^(n-r)
        // Find the power of q (probability of failure or 1-p) to n-x
        BigInteger c = BigInteger.valueOf((long) Math.pow((1-p.doubleValue()), n.subtract(x).doubleValue()));

        return a.multiply(b).multiply(c);

    }

    

}
