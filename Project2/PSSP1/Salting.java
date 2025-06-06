/*
 * Author: Alexis Lopez
 * 
 * This class is used to salt the y values of a CSV file by adding or subtracting a random number to each value.
 * It then writes the salted data to a new CSV file.
 * 
 * Originally, I had this class and the previous (Plotter) combine the read and writing of the csv file into one class
 * But as stated in class, since this is used so often, it would be more efficient to have a seperate class handle those tasks
 * It wasn't until i finished the JFreeHandler classes that i went back to update this code to utilize the CSVHandler class
 */
package Project2.PSSP1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Salting 
{

    public void saltData(String fileName, String output, int min, int max) throws IOException
    {
        
        // Creates a new CSVHandler object to read and write CSV files
        CSVHandler csvHandler = new CSVHandler();

        // Creates a new random object to generate random numbers
        Random rand = new Random();
        
        //Adds the .csv extension to the file name and output file name
        fileName += ".csv";
        output += ".csv";

        int[][] csvData = csvHandler.readCSV(fileName);

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
        csvHandler.writeCSV(xValues, saltedYValues, output);
        
    }
}
