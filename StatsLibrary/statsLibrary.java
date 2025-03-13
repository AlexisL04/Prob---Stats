package StatsLibrary;
/*
 * This is a statistics library that provides various statistical calculations
 * 
 * @author Alexis Lopez
 */

 import java.util.Arrays;
 import java.util.HashMap;
 import java.util.HashSet;
 
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
     public int getMode(int[] userInputNumbers) 
     {
         int n = userInputNumbers.length;
         
         // Use HashMap to store number frequencies
         HashMap<Integer, Integer> mode = new HashMap<Integer, Integer>();
         
         int top = 1;        // Tracks highest frequency
         int result = 0;     // Stores the mode
 
         // Count frequency of each number
         for (int i = 0; i < n; i++) 
         {
             
            // If number already exists in HashMap, increment its count
             if (mode.get(userInputNumbers[i]) != null) 
             {
                 int count = mode.get(userInputNumbers[i]);
                 count++;
                 mode.put(userInputNumbers[i], count);
 
                 // Update mode if current number has higher frequency
                 if (count > top) 
                 {
                     top = count;
                     result = userInputNumbers[i];
                 }
             }
             
             // If number is new, add to HashMap with count 1
             else 
             {
                 mode.put(userInputNumbers[i], 1);
             }
         }
         return result;
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
     private int factorial(int n) 
     {
         if (n == 0 || n == 1) 
         {
             return 1;
         }

         return n * factorial(n - 1);

     }

     /*
      *  Determines if Axiom 1 applies to this set of probabilities
      */
     private boolean probabilityAxiomOne(double[] probabilities) 
     {
         
        double sum = 0;
         
        for (double probability : probabilities) 
        {
            sum += probability;
        }
        
        return sum == 1;

     }

     private boolean probabilityAxiomTwo(double[] probabilities) 
     {
         
        for (double probability : probabilities) 
        {
            if (probability < 0 || probability > 1) 
            {
                return false;
            }
        }
        
        return true;

     }

    private boolean probabilityAxiomThree(double[] A, double[] B) 
    {
            
        if (arrayIntersect(A, B) == null) 
        {
            return true;
        }

        return false;
    
    }

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
     * @return true if A and B are independent, false otherwise
     */
    public Boolean checkDependancy(double A, double B) 
    {

        // P(A AND B) = P(A) * P(B)
        double AAndB = A * B;

        // P(A|B) = P(A AND B) / P(B)
        double probabilityAGivenB = AAndB / B;

        // P(B|A) = P(A AND B) / P(A)
        double probabilityBGivenA = AAndB / A;

        // If P(A|B) = P(A), P(B|A) = P(B), or P(A AND B) = P(A) * P(A) then A and B are independent
        if (probabilityAGivenB == A || probabilityBGivenA == B || AAndB == (A * B)) 
        {
            return true;
        }
        
        // If neither of the conditions are met, then we return false, or that they are dependent
        return false;

    }

    /*
     * Calculates P(A AND B) for dependent or independent events
     * @param A Probability of event A
     * @param B Probability of event B
     * @param AAndB Probability of event A AND B
     * @return P(A AND B) for dependent or independent events
     */
    public double calculateDependancyIntersection(double A, double B, double AGivenB)
    {

        //Calcualtes the probability of A AND B if they are dependent
        if (checkDependancy(A, B) == false)
        {

            return AGivenB * B;

        }

        return A * B;

    }

    /*
     * Calculates P(A OR B) for dependent or independent events
     * @param A Probability of event A
     * @param B Probability of event B
     * @param AGivenB Probability of event A given B
     * @return P(A OR B) for dependent or independent events
     */
    public double calculateExclusivityUnion(double A, double B, double AGivenB) 
    {

        //Calculates the probability of A AND B
        double AIntersectionB = calculateDependancyIntersection(A, B, AGivenB);
        
        //Calculates the probability of A OR B if they are mutually exclusive
        if (AIntersectionB == 0)
        {
            //If the intersection is 0, then we can just add A and B together
            return A + B;
        }
        
        //Calculates the probability of A OR B if they are not mutually exclusive
        //If the intersection is not 0, then we need to subtract the intersection from A and B
        return A + B - calculateDependancyIntersection(A, B, AIntersectionB);

    }
    

 }