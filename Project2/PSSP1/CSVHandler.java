/*
 * Author: Alexis Lopez
 * 
 * This class handles the reading and writing of CSV files. 
 * It provides methods to write x and y values to a CSV file and read them back into a 2D array.
 * It also handles the conversion of ArrayLists to arrays.
 * 
 * This was a fun excersize as I have never worked with a sliding window average before, so that was a little troublesome to figure out.
 * Additionally, I had to figure out how to read and write from a csv file which was a little tricky at first
 * Thankfully i found a video guide on how to use buffered reader, and in combination with help from the internet, I was able to figure it out.
 * 
 * One small trouble I ran into was actually a simple problem i had overblown. My issue was that I was trying to 
 * make a 2d array with arraylists which are incompatible, so i resorted to the internet and copied a piece of code which i did not understand and
 * intended to remedy later when i thought of a fix. I ended up spending a lot of time mulling this over until I realized that I could
 * just convert the arraylist to an array using a simple method that makes a new array of the arraylist size and then loops through the 
 * arraylist to fill the array with the values.
 */
package Project2.PSSP1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVHandler {
    
    /*
     * This method writes the x and y values to a CSV newly written by a user.
     * @param xValues the x values to write
     * @param yValues the y values to write
     * @param fileName the name of the CSV file to write to
     * @return the name of the CSV file written to
     */
    public String writeCSV(int[] xValues, int[] yValues, String fileName){
        
        // Creates new array list to hold the data
        ArrayList<String> data = new ArrayList<>();

        // Adds the header to the CSV file
        data.add("X,Y");

        // Adds the x and y values to the CSV file
        for(int i = 0; i < xValues.length; i++)
        {
            data.add(xValues[i] + "," + yValues[i]);
        }

        try 
        {
            // Creates a new file writer and print writer to write to the CSV file
            FileWriter csvOutputFile = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(csvOutputFile);

            // for each line in the data array list, write it to the CSV file
            for (String line : data) 
            {
                // Writes the line to the CSV file
                pw.println(line);
            }
            
            // Closes the print writer
            pw.close();

            // Returns the name of the CSV file written to
            return fileName;
        } 
        
        // If the file writer or print writer fails, catch the exception and print an error message and return null
        catch (IOException e) 
        {
            System.err.println("Error writing to CSV: " + e.getMessage());
            return null;
        }

    }

    /*
     * This method reads a CSV file and returns the x and y values as a 2D array.
     * Had to learn how to use buffered reader
     * Source: https://www.youtube.com/watch?v=waXvGUEjTTs
     * @param fileName the name of the CSV file to read from
     * @return a 2D array containing the x and y values
     */
    public int[][] readCSV(String fileName) throws IOException 
    {
        // Creates new array lists to hold the x and y values
        ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Integer> yValues = new ArrayList<>();

        // Creates a new buffered reader to read the CSV file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Skip header row
            reader.readLine();
            
            // Reads each line of the CSV file and splits it into columns
            String line;
            while ((line = reader.readLine()) != null) 
            {
                // Split the line by comma and take only the first two columns
                String[] values = line.split(",");

                // If the line contains at least two columns, parse the x and y values
                if (values.length == 2) 
                {
                    try 
                    {
                        // Parse the x and y values as integers and add them to the x and y values array lists
                        int x = Integer.parseInt(values[0].trim());
                        int y = Integer.parseInt(values[1].trim());
                        xValues.add(x);
                        yValues.add(y);
                    } 
                    
                    // If the x and y values are not valid integers, catch the exception and print an error message
                    catch (NumberFormatException e) 
                    {
                        System.err.println("Skipping invalid line: " + line);
                    }

                }

            }

        }

        // Convert ArrayLists to 2D array
        int[][] result = new int[2][];
        result[0] = convertToArray(xValues);
        result[1] = convertToArray(yValues);
        
        return result;
    }

    // Converts an ArrayList of integers to an array of integers
    private int[] convertToArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

}
