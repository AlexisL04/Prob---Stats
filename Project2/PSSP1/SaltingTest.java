/*
 * Author: Alexis Lopez
 * 
 * This class tests the Salting class by calling the saltData method and prompting the user for input
 */
package Project2.PSSP1;

import java.io.IOException;
import java.util.Scanner;

public class SaltingTest {
    
    public static void main(String[] args) throws IOException {
        Salting salting = new Salting();

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the name of the CSV file to salt: ");
        String inputFile = in.nextLine();
        
        System.out.println("What would you like to call the output file?");
        String outputFile = in.nextLine();
        
        System.out.println("Enter the minimum value for salting: ");
        int min = in.nextInt();
        
        System.out.println("Enter the maximum value for salting: ");
        int max = in.nextInt();

        salting.saltData(inputFile, outputFile, min, max);
    }

}
