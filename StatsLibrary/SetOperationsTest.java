/*
 * Author: Alexis Lopez
 * The SetOperationsTest class contains the main method to test the methods in the SetOperations class.
 * The class prints out the results of the union, intersection, and complement methods.
 */

package StatsLibrary;
public class SetOperationsTest {
    
    public static void main(String[] args) {
        
        SetOperations test = new SetOperations();
        
        String[] arrayA = {"a", "b", "c"};
        String[] arrayB = {"c", "d", "e"};

        int[] arrayC = {1, 2, 3, 4, 5, 6, 7};
        int[] arrayD = {3, 4, 5,};
        
        System.out.println(test.arrayUnion(arrayA, arrayB));

        System.out.println(test.arrayIntersect(arrayA, arrayB));

        System.out.println(test.arrayComplement(arrayC, arrayD));
        
    }
}
