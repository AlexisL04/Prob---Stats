/*
 * Author: Alexis Lopez
 * 
 * This class handles smoothing data by averaging the y values of a given window size around each x value.
 */
package part3;

import java.io.IOException;

public class JFreeSmoother {
    
    public void smoothData(String fileName, int window, String output) throws IOException
    {
        
        // Creates a new JFreeHandler object to handle the CSV file and plotting
        JFreeHandler jFreeHandler = new JFreeHandler();

        // adds the .csv extension to the file name and output file name
        fileName += ".csv";
        output += ".csv";

        // Reads the CSV file and stores the x and y values in a 2D array
        int[][] data = jFreeHandler.readCSV(fileName);

        // Gets the x and y values from the 2D array
        int[] xValues = data[0];
        int[] yValues = data[1];

        // Loops through x values and averages the y values around the window
        for (int i = 0; i < xValues.length; i++)
        { 

            // Sets the start and end of the window
            int start = Math.max(0, i - window);
            int end = Math.min(xValues.length - 1, i + window);

            // variables to hold the sum and count of the y values in the window
            int sum = 0;
            int count = 0;

            // Loops through the y values in the window and adds them to the sum and increment count
            for (int j = start; j <= end; j++)
            {
                sum += yValues[j];
                count++;
            }

            // Sets the y value at position i to the average of the y values in the window
            yValues[i] = sum / count; 

        }

        // Writes the x and y values to the CSV file and plots it using JFreeChart
        jFreeHandler.writeCSV(xValues, yValues, output);
        jFreeHandler.plotCSV(output);

    }

}
