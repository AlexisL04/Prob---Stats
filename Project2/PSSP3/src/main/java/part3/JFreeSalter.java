/*
 * Author: Alexis Lopez
 * 
 * This class handles salting data by randomly adding or subtracting the original y values by a random number between a given range.
 * It then procceeds to write the salted data to a new CSV file and plot it using JFreeChart.
 */

package part3;

import java.io.IOException;
import java.util.Random;

public class JFreeSalter {

   
    public void saltData(String fileName, String output, int min, int max) throws IOException
    {
        
        // Creates a new JFreeHandler object to handle the CSV file and plotting
        // Creates a new random object to generate random numbers
        JFreeHandler jFreeHandler = new JFreeHandler();
        Random rand = new Random();
        
        //Adds the .csv extension to the file name and output file name
        fileName += ".csv";
        output += ".csv";

        // Reads the CSV file and stores the x and y values in a 2D array
        int[][] csvData = jFreeHandler.readCSV(fileName);

        // Gets the x and y values from the 2D array
        int[] xValues = csvData[0];
        int[] yValues = csvData[1];

        // Creates a new array to hold the salted y values
        int[] saltedYValues = new int[yValues.length];

        // Loops through the y values and adds or subtracts a random number to each value
        for (int i = 0; i < xValues.length; i++) {
            
            // Sets temp variable to y at position i
            int yValue = yValues[i];
            
            // Generates a random number between min and max
            int yMod = rand.nextInt(max - min + 1) + min;
            
            // Generates a random number between 0 and 1 to decide whether to add or subtract the random number from the y value
            int decision = rand.nextInt(2); // 0 or 1
            if (decision == 0) 
            {
                yMod = yValue + yMod;
            } 
            else 
            {
                yMod = yValue - yMod;
            }

            // Sets the salted y value to the new y value
            saltedYValues[i] = yMod;

        }


        // Writes the x and salted y values to a new CSV file
        jFreeHandler.writeCSV(xValues, saltedYValues, output);

        // Plots the salted data using JFreeChart
        jFreeHandler.plotCSV(output);
        
    }

    

}
