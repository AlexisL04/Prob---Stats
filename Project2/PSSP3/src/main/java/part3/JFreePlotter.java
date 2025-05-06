/*
 * Author: Alexis Lopez
 * 
 * This class handles plotting squared data using jfreechart. Similar to the initial plotter class but with
 * added functionality to plot the data using jfreechart rather than having to go into excel and plot it manually.
 */
package part3;

import java.io.IOException;
import java.util.Scanner;

public class JFreePlotter {
    
    /*
     * This method squares the given number.
     * @param x the number to square
     * @return the squared value of x
     */
    public int squared(int x) {
        return x * x;
    }

    /*
     * This method creates a CSV file with the given number of data points and plots it using JFreeChart.
     * @return none
     */
    public void createData() throws IOException{

        // Creates a new JFreeHandler object to handle the CSV file and plotting
        JFreeHandler jFreeHandler = new JFreeHandler();

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
            int yValue = squared(i);
            
            // Sets the x and y values for the data point
            xValues[i] = i;
            yValues[i] = yValue;

        }

        // Writes the x and y values to the CSV file and plots it using JFreeChart
        jFreeHandler.writeCSV(xValues, yValues, fileName);
        jFreeHandler.plotCSV(fileName);

    }

}
