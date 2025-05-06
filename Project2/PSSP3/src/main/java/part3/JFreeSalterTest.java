/*
 * Author: Alexis Lopez
 * 
 * This class tests the JFreeSalter class by calling the saltData method and prompting the user for input
 */
package part3;

import java.io.IOException;
import java.util.Scanner;

public class JFreeSalterTest {
    
    public static void main(String[] args) throws IOException {
        JFreeSalter salter = new JFreeSalter();

        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the name of the CSV file to salt: ");
        String fileName = in.nextLine();
        System.out.println("What would you like to call the output file?");
        String output = in.nextLine();
        System.out.println("Enter the minimum value for salting: ");
        int min = in.nextInt();
        System.out.println("Enter the maximum value for salting: ");
        int max = in.nextInt();
        
        in.close();

        salter.saltData(fileName, output, min, max);
    }

}
