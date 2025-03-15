package StatsLibrary;
/*
 * This is a statistics library that provides various statistical calculations for chapters 1 and 2
 * 
 * @author Alexis Lopez
 */


 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.Map;
 
 public class statsLibrary 
 {
    
  

    /*
    * Calculates the arithmetic mean of an array of integers
    * @param userInputNumbers Array of integers to calculate mean
    * @return The mean as a double
    */

    public double getMean(int[] userInputNumbers) 
    {
        int total = 0;
         
        // Sum all numbers in the array
        for (int singleNumber: userInputNumbers) 
        {
            total = total + singleNumber;
        }
         
        // Calculate mean by dividing sum by count of numbers
        double result = (double) total / userInputNumbers.length;
        return result;

    }
 


    /*
     * Calculates the median (middle value) of an array of integers
     * @param userInputNumbers Array of integers to find median
     * @return The median as a double
     */
    public double getMedian(int[] userInputNumbers) 
    {
        int n = userInputNumbers.length;
        double result;
 
        // Sort array to get numbers in ascending order
        Arrays.sort(userInputNumbers);
 
        // If array length is odd, median is middle number
        if (n % 2 != 0) 
        {
            result = userInputNumbers[n/2];
        }
         
        // If array length is even, median is average of two middle numbers
        else 
        {
            result = (userInputNumbers[(n - 1) / 2] + userInputNumbers[n / 2]) / 2.0;
        }
        return result;
     }
 

     /*
      * Finds the mode (most frequent value) in an array of integers
      * @param userInputNumbers Array of integers to find mode
      * @return The mode as an integer
      */
    public ArrayList<Integer> getMode(int[] userInputNumbers) 
    {

        // Use HashMap to store number frequencies
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        // An arraylist to store the most frequent numbers
        ArrayList<Integer> modes = new ArrayList<>();

        // Count frequency of each number in the array
        for (int num : userInputNumbers) 
        {
            // Increment frequency count for the number, with the default being 0 if not present
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Find the highest frequency
        int top = 1;
        
        // Loop through the frequency map to find the highest count
        for (int count : frequency.values()) 
        {
            // If the current count is higher than the top, update the top
            if (count > top) 
            {
                top = count;
            }

        }

        // Once we looped through and found the highest frequency we
        // Check if there are other numbers with similar frequency
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) 
        {
            // If the frequency of the number is equal to the top, add it to the modes list
            if (entry.getValue() == top) 
            {
                modes.add(entry.getKey());
            }
        }
        
         return modes;

    }

    /*
     * Calculates the variance of an array of integers
     * @param userInputNumbers Array of integers to calculate variance
     * @return The variance as an integer
     */
    public int getVariance(int[] userInputNumbers) 
    {
    
        int n = userInputNumbers.length;
        double mean = getMean(userInputNumbers);
        double sum = 0;
 
        // Calculate sum of squared differences from mean
        for (int i = 0; i < n; i++) {
            sum += Math.pow(userInputNumbers[i] - mean, 2);
        }
 
        // Calculate variance by dividing sum by count
        double result = sum / n;
        return (int) result;

    }
 

    /*
     * Calculates the standard deviation of an array of integers
     * @param userInputNumbers Array of integers to calculate standard deviation
     * @return The standard deviation as a double
     */
    public double getStandardDeviation(int[] userInputNumbers) 
    {
        int n = userInputNumbers.length;
        double mean = getMean(userInputNumbers);
        double sum = 0;
 
        // Calculate sum of squared differences from mean
        for (int i = 0; i < n; i++) {
            sum += Math.pow(userInputNumbers[i] - mean, 2);
        }
 
        // Calculate standard deviation by taking square root of average
        double result = Math.sqrt(sum / n);
        return result;
    }


    /*
     * Multiplies two numbers
     * @param m First number
     * @param n Second number
     * @return Product of m and n
     */
    public double findMN(int m, int n) 
    {
        double result;
         
        result = m * n;
         
        return result;
    }
 

    /*
     * Calculates multinomial coefficients
     * @param n Total number of items
     * @param k Array of counts for each category
     * @return The multinomial coefficient
     */
    public double findMultinomialCoefficients(int n, int[] k) 
    {
        double result = 1;
 
        // Calculate product of factorials of k values
        for (int i = 0; i < k.length; i++) 
        {
            result = result * factorial(k[i]);
        }
 
        // Divide factorial of n by product of k factorials
        result = factorial(n) / result;
         
        return result;
    }
 
    /*
     * Helper method to calculate factorial of a number
     * @param n Number to calculate factorial
     * @return Factorial of n
     */
    public int factorial(int n) 
    {
        if (n == 0 || n == 1) 
        {
            return 1;
        }

        return n * factorial(n - 1);

    }

    /*
     * Determines if Axiom 1 applies to this set of probabilities P(A) > 0
     * @param probabilities Array of probabilities
     * @return true if Axiom 1 applies, false otherwise
     */
    public boolean probabilityAxiomOne(double[] probabilities) 
    {
                  
        for (double probability : probabilities) 
        {
            if (probability < 0)
            {
                return false;
            }
        }
        
        return true;

    }
    
    /*
     * Determines if Axiom 2 applies to this set of probabilities P(S) = 1
     * @param probabilities Array of probabilities
     * @return true if Axiom 2 applies, false otherwise
     */
    public boolean probabilityAxiomTwo(double[] probabilities) 
    {
        
        double sum = 0;

        for (double probability : probabilities) 
        {
            sum += probability;
        }

        System.out.println("Sum: " + sum);

        return sum == 1;

    }

    /*
     * Determines if Axiom 3 applies to this set of probabilities P(A and B) = null
     * @param A Array of probabilities for event A
     * @param B Array of probabilities for event B
     * @return true if Axiom 3 applies, false otherwise
     */
    public boolean probabilityAxiomThree(double[] A, double[] B) 
    {
        
        HashSet<Double> intersect = arrayIntersect(A, B);
        
        if (intersect.isEmpty()) 
        {
            return true;
        }
        
        return false;
    
    }

    /*
     * Find the intersection of 2 arrays
     * @param A the first array
     * @param B the second array
     * @return a hashset of the intersection of the 2 arrays
     */
    public HashSet<Double> arrayIntersect(double[] A, double[] B) 
    {
        
        //creates a hashset to store the intersection of the 2 arrays
        HashSet<Double> intersect = new HashSet<Double>();
        
        //loops through the first array
        for (Double elementA : A){
           
            //loops through the second array
            for (Double elementB : B)
            {
                
                //if the element from the first array mathces the element from the second array, then the element is added to the intersect set
                if (elementA.equals(elementB))
                {
                    intersect.add(elementA);
                }

            }

        }
        
        //returns the result of the intersect set
        return intersect;
    }

    /*
     * Checks if two events A and B are independent or not
     * @param A Probability of event A
     * @param B Probability of event B
     * @param AAndB Probability of event A AND B
     * @return true if A and B are independent, false otherwise
     */
    public String checkDependancy(double A, double B, double AAndB) 
    {

        // P(B|A) = P(A AND B) / P(A)
        double probabilityBGivenA = AAndB / A;

        // P(A|B) = P(A AND B) / P(B)
        double probabilityAGivenB = AAndB / B;

        // If P(B|A) = P(A), P(B|A) = P(B), or P(A AND B) = P(A) * P(A) then A and B are independent
        if (probabilityAGivenB == B || probabilityBGivenA == A || AAndB == (A * B)) 
        {
            return "Independent";
        }
        
        // If neither of the conditions are met, then we return false, or that they are dependent
        return "Dependent";

    }

    /*
     * Calculates P(B|A) for dependent or independent events
     * @param A Probability of event A
     * @param B Probability of event B
     * @param AAndB Probability of event A AND B
     * @return P(B|A) for dependent or independent events
     */
    public double calculateConditionalProbability(double A, double AAndB) 
    {

        // P(B|A) = P(A AND B) / P(A)
        double probabilityBGivenA = AAndB / A;

        return probabilityBGivenA;

    }

    /*
     * Calculates P(A AND B) for dependent or independent events
     * @param A Probability of event A
     * @param B Probability of event B
     * @param AAndB Probability of event A AND B
     * @return P(A AND B) for dependent or independent events
     */
    public double calculateDependancyIntersection(double A, double B, double AAndB)
    {

        //Calcualtes the probability of A AND B if they are dependent
        if (checkDependancy(A, B, AAndB ) == "Dependent")
        {

            //P(B|A)
            double probabilityBGivenA = AAndB / A;

            //P(A And B) = P(A) * P(B|A)
            double probabilityAAndB = A * probabilityBGivenA;

            return probabilityAAndB;

        }

        return A * B;

    }

    /*
     * Calculates P(A OR B) for dependent or independent events
     * @param A Probability of event A
     * @param B Probability of event B
     * @param AAndB Probability of event A AND B
     * @return P(A OR B) for dependent or independent events
     */
    public double calculateExclusivityUnion(double A, double B, double AAndB) 
    {

        //Calculates the probability of A AND B
        double AIntersectionB = calculateDependancyIntersection(A, B, AAndB);
        
        //Calculates the probability of A OR B if they are mutually exclusive
        if (AIntersectionB == 0)
        {
            //If the intersection is 0, then we can just add A and B together
            return A + B;
        }
        
        //Calculates the probability of A OR B if they are not mutually exclusive
        //If the intersection is not 0, then we need to subtract the intersection from A and B
        return A + B - AAndB;

    }

    /*
     * Calculates the total probability of an event
     * @param AB Array of probabilities for event A Given B
     * @param B Array of probabilities for event B
     * @return The total probability of the event
     */
    public double totalProbability(double[] AB, double[] B)
    {
        double totalProbability = 0;
        for (int i = 0; i < AB.length; i++)
        {
            totalProbability += AB[i] * B[i];
        }

        return totalProbability;
    }
    
    /*
     * Calculates the probability of an event using Bayes' Theorem
     * @param A Probability of event A
     * @param B Probability of event B
     * @param AGivenB Probability of event A Given B
     * @param BGivenA Probability of event A Given B
     * @return The probability of event B given A
     */
    public double calculateBayesTheorem(double A, double B, double AGivenB, double BGivenA) 
    {
        double probabilityBGivenA = 0;

        if (A > 0 && B > 0) 
        {
            // P(B|A) = (P(A|B) * P(B))/P(A)
            probabilityBGivenA = (AGivenB * B) / A;

        }
        else
        {
            // P(B|A) = (P(A|B) * P(B))/(P(A|B) * P(B) + P(A|B') * P(B'))
            probabilityBGivenA = (AGivenB * B) / ((AGivenB * B) + ((1 - AGivenB) * (1 - B)));
        }
        
        //returns the probability of B given A
        return probabilityBGivenA;

    }

    /*
     * Calculates the expected value of a random variable
     * @param prob Array of probabilities for each outcome
     * @param outcome Array of outcomes for each probability
     * @return The expected value of the random variable
     */
    public double expectedRandom(double[] prob, double[] outcome)
    {
        double expectedValue = 0;

        for (int i = 0; i < prob.length; i++) 
        {
            expectedValue += prob[i] * outcome[i];
        }

        return expectedValue;
    }

    /*
     * Calculates the variance of a random variable
     * @param prob Array of probabilities for each outcome
     * @param outcome Array of outcomes for each probability
     * @return The variance of the random variable
     */
    public double varianceRandom(double[] prob, double[] outcome)
    {
        double variance = 0;
        double expectedValue = expectedRandom(prob, outcome);

        for (int i = 0; i < prob.length; i++) 
        {
            variance += prob[i] * Math.pow((outcome[i] - expectedValue), 2);
        }

        return variance;
    }

    public double standardDeviationRandom(double[] prob, double[] outcome)
    {
        double variance = varianceRandom(prob, outcome);
        return Math.sqrt(variance);
    }



 }