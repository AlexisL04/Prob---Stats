/*
 * Author: Alexis Lopez
 * This class contains methods and variables needed to find the union, intersection, and complement of two arrays.
 * The class can:
 * - Find the union of two arrays
 * - Find the intersection of two arrays
 * - Find the complement of a subset using a sample set provided
 */

package StatsLibrary;
import java.util.HashSet;

public class SetOperations 
{
    
    /*
     * Find the union of 2 arrays
     * @param arrayA the first array
     * @param arrayB the second array
     * @return a string of the union of the 2 arrays
     */
    public String arrayUnion(String[] arrayA, String[] arrayB)
    {
            
        //creates a hashset to store the union of the 2 arrays
        HashSet<String> union = new HashSet<String>();
            
        //loops through the first array and adds each element to the union set
        for (String element : arrayA)
        {
            union.add(element);
        }
        
        //loops through the second array and adds each element to the union set
        for (String element : arrayB)
        {
            union.add(element);
        }
            
        //returns the result of the union set
        return union.toString();

    }

    /*
     * Find the intersection of 2 arrays
     * @param arrayA the first array
     * @param arrayB the second array
     * @return a string of the intersection of the 2 arrays
     */
    public String arrayIntersect(String[] arrayA, String[] arrayB)
    {
        
        //creates a hashset to store the intersection of the 2 arrays
        HashSet<String> intersect = new HashSet<String>();
        
        //loops through the first array
        for (String elementA : arrayA)
        {
           
            //loops through the second array
            for (String elementB : arrayB)
            {
                
                //if the element from the first array matches the element from the second array, then the element is added to the intersect set
                if (elementA.equals(elementB))
                {
                    intersect.add(elementA);
                }

            }

        }
        
        //returns the result of the intersect set
        return intersect.toString();
    }

    /*
     * Find the compliment of a subset using a sample set provided
     * @param arrayA the sample set
     * @param arrayB the subset
     * @return a string of the complement of the subset
     */
    public String arrayComplement(int[] arrayA, int[] arrayB)
    {
        
        //creates a hashset to store the complement of the 2 arrays
        HashSet<Integer> complement = new HashSet<Integer>();
        
        // loops through the sample set user has provided 
        for (int elementA : arrayA)
        {
            
            //sets the boolean to false, as we have not seen if the element exists in the subset
            boolean found = false;
            
            //loops through the subset provided by the user
            for (int elementB : arrayB)
            {
                
                //if the element from the subset exists in the sample set, then the boolean is set to true and the loop breaks
                if (elementB == elementA)
                {
                    found = true;
                    break;
                }

            }
            
            // if the element from the subset does not exists in the sample set, then the element is added to the complement set
            if (!found)
            {
                complement.add(elementA);
            }

        }

        //returns the result of the complement set
        return complement.toString();
    }

    

    

}
