/*
 * Author: Alexis Lopez
 * 
 * This class tests the JFreeSmoother class by calling the smoothData method and prompting the user for input
 */
package part3;

import java.io.IOException;
import java.util.Scanner;

public class JFreeSmootherTest {
    
    public static void main(String[] args) throws IOException {
        JFreeSmoother smoother = new JFreeSmoother();

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the name of the file to smooth: ");
        String fileName = in.nextLine();
        System.out.println("Enter the name of the output file: ");
        String output = in.nextLine();
        System.out.println("Enter the window size: ");
        int window = in.nextInt();
        
        
        smoother.smoothData(fileName, window, output);
        
        in.close();

    }

}
