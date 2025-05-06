/*
 * Author: Alexis Lopez
 * 
 * This class is responsible for creating a CSV file with x and y values.
 * It prompts the user for the number of data points and the name of the file. as well as the output file name.
 * it then squares the x values to create the y values.
 * 
 * Nothing special here, this is just the beginning of the struggle that is the other upcoming projects
 */
package Project2.PSSP1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Plotter
{

    /*
     * This method creates a CSV file with the given x values and squares it to create its y values
     * @param none
     * @return none
     */
    public void dataPlotter() throws IOException{

        // Creates a new CSVHandler object to handle CSV file operations
        CSVHandler csvHandler = new CSVHandler();

        // Creates a new scanner object to read user input
        Scanner scanner = new Scanner(System.in);
    
        // Prompts the user for the number of data points to plot and the name of the CSV file
        System.out.println("How many data points would you like to plot?");
        int numPoints = scanner.nextInt();

        // Prompts the user for the name of the CSV file to create
        System.out.println("What would you like to call the file?");
        String fileName = scanner.next() + ".csv";
        
        // Creates two arrays to hold the x and y values for the data points
        int[] xValues = new int[numPoints];
        int[] yValues = new int[numPoints];

        scanner.close();

        // Loops through the number of data points and calculates the x and y values
        for (int i = 0; i < numPoints; i++) {
            
            //squares y
            int yValue = ySquared(i);
            
            // Sets the x and y values for the data point
            xValues[i] = i;
            yValues[i] = yValue;

        }

        // Writes the x and y values to the CSV file
        csvHandler.writeCSV(xValues, yValues, fileName);

    }

    // This method squares the given number.
    public int ySquared(int y)
    {
        return y * y;
    }
}
