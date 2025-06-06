/*
 * Author: Alexis Lopez
 * 
 * This class tests the Smoother class by calling the smoothData method and prompting the user for input
 */
package Project2.PSSP1;

import java.io.IOException;
import java.util.Scanner;

public class SmootherTest {
    
    public static void main(String[] args) throws IOException {
        Smoother smoother = new Smoother();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the name of the file to smooth: ");
        String fileName = in.nextLine();
        System.out.println("Enter the name of the output file: ");
        String output = in.nextLine();
        System.out.println("Enter the window size: ");
        int window = in.nextInt();

        smoother.smoothData(fileName, window, output);
    }

}
