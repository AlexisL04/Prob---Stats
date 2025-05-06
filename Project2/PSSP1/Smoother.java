/*
 * Author: Alexis Lopez
 * 
 * This class handles the smoothing of the previously salted data. It takes in a CSV file, reads the data, and smooths it using 
 * moving window average. This was originally the most difficult part of the project for me as I had to wrap my head around the idea of
 * programming a moving window average. I had to look through a few different sources and ask my peers on how I should go about implementing this
 * 
 * As time passed, I went on ahead to the other parts of this projects as i finished using octave and was heading into the final stages 
 * of the project. I was going about this the wrong way and as a result, I have ended up putting myself in a position where it seemed difficult
 * but was really simple once i understood the concept of a moving window average. It also didnt help i was looking at the project from the 
 * wrong side and was trying to implement it in a way that was not needed.
 */
package Project2.PSSP1;

import java.io.IOException;


public class Smoother
{

    /*
     * This method smooths the data in the CSV file using a moving window average.
     * @param fileName the name of the CSV file to read from
     * @param window the size of the moving window to use for smoothing
     * @param output the name of the CSV file to write to
     * @throws IOException if there is an error reading or writing the CSV file
     */
    public void smoothData(String fileName, int window, String output) throws IOException
    {
     
        // Creates a new CSVHandler object to handle the CSV file
        CSVHandler csvHandler = new CSVHandler();

        // adds the .csv extension to the file name and output file name
        fileName += ".csv";
        output += ".csv";

        // Reads the CSV file and stores the x and y values in a 2D array
        int[][] data = csvHandler.readCSV(fileName);

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

        // Writes the x and y values to the CSV file
        csvHandler.writeCSV(xValues, yValues, output);

    }
}
