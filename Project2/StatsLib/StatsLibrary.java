import java.math.BigInteger;
import java.lang.Math;

public class StatsLibrary {
    
    /*
     * This method calculates the factorial of a given number n using recurssion.
     * @param n the number to calculate the factorial of
     * @return the factorial of n as a BigInteger
     */
    public BigInteger factorial(int n) 
    {
        
        if (n == 0){
            return BigInteger.ONE;
        } 
        
        return BigInteger.valueOf(n).multiply(factorial(n - 1));

    }


    //3.8

    /*
     * This method calculates poisson distribution for a given y and lambda.
     * @param y the number of occurrences
     * @param lambda the average number of occurrences
     * @return the poisson distribution value
     */
    public double poissonDist(int y, double lambda) 
    {

        //finds the value of e^(-lambda) and stores it in a variable
        double e = Math.exp(-lambda);
        //calculates the numerator
        double num = Math.pow(lambda, y);
        //calculates the denominator
        double denom = factorial(y).doubleValue();

        //calculates the poisson distribution value
        double result = (e * num) / denom;

        return result;
        
    }

    /*
     * Calculates the expected value of a Poisson distribution for a given lambda.
     * @param lambda the average number of occurrences
     * @return the expected value of the Poisson distribution
     */
    public double poissonExpected(double lambda) 
    {
       
        return lambda;
        
    }

    /*
     * Calculates the variance of a Poisson distribution for a given lambda.
     * @param lambda the average number of occurrences
     * @return the variance of the Poisson distribution
     */
    public double poissonVariance(double lambda) 
    {
        
        return lambda;
        
    }

    /*
     * Calculates the standard deviation of a Poisson distribution for a given lambda.
     * @param lambda the average number of occurrences
     * @return the standard deviation of the Poisson distribution
     */
    public double poissonSTD(double lambda) 
    {
        
        return Math.sqrt(lambda);
        
    }

    //3.11

    /*
     * This method calculates the Tchebysheff inequality for a given k and option.
     * Option 1 returns 1 - 1/k^2 for P(|Y - mean| < k * STD) >= 1- 1/k^2) 
     * and option 2 returns 1/k^2 for P(|Y - mean| >= k * STD) <= 1/k^2.
     * @param k the number of standard deviations from the mean
     * @param option the option to choose (1 for 1 - 1/k^2, 2 for 1/k^2)
     * @return the result
     */
    public double tchebysheff(int k, int option)
    {
        switch (option) {
            case 1:
                return 1 - (1 / Math.pow(k,2));
            case 2:
                return 1 / Math.pow(k,2);
            default:
                return 0;
        }
    }

    /*
     * This method calculates uniform distribution for a given range [a, b].
     * @param a the lower bound of the range
     * @param b the upper bound of the range
     */
    public double uniformDist(double a, double b) 
    {
        if (a < b){
           return  1/(b-a);
        }

        return 0;
    }

    /*
     * This method calculates the expected value of a uniform distribution for a given range [a, b].
     * @param a the lower bound of the range
     * @param b the upper bound of the range
     * @return the expected value of the uniform distribution
     */
    public double uniformExpected(double a, double b) 
    {
        return (a + b) / 2;
    }

    /*
     * This method calculates the variance of a uniform distribution for a given range [a, b].
     * @param a the lower bound of the range
     * @param b the upper bound of the range
     * @return the variance of the uniform distribution
     */
    public double uniformVariance(double a, double b)
    {
        return math.pow(b-a,2) / 12;
    }






}

