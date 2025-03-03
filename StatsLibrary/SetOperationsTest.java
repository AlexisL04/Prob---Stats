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
