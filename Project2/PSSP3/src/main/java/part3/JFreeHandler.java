/*
 * Author: Alexis Lopez
 * 
 * This class handles the reading and writing of CSV files, as well as plotting the data using JFreeChart.
 * Although this started off relatively simple as most of the methods were just copied from the first part of the project,
 * it was a little more difficult to figure out how to use and plot using jfreechart.
 * I had to look through a few different sources in order to figure out how to use it properly, and some didnt have what i needed
 * I finally found something that worked for me and I have linked it as a source for the plotCSV method.
 * 
 * There were definitely a lot of challenges, especially for my salting since there was an issue with the plotting still
 * resembling the original data. It wasnt until i realized that i was using a large dataset with a small range of values to add/subtract from
 * so it still resembled the original data. So after creating a new dataset with smaller data points, it worked out much better.
 * 
 * Other than that, I was able to use previous code and integrate it with the newely added methods to not only store data as a csv
 * but also plot it using jfreechart
 */

package part3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class JFreeHandler {
    
    /*
     * This method writes the x and y values to a CSV newely written by a user.
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
     * This method reads the x and y values from a CSV file and returns them as a 2D array.
     * @param fileName the name of the CSV file to read from
     * @return a 2D array containing the x and y values
     */
    public int[][] readCSV(String fileName) throws IOException 
    {
        // Creates new array lists to hold the x and y values
        ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Integer> yValues = new ArrayList<>();

        // Creates a new buffered reader to read the CSV file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) 
        {
            // Skip header row
            reader.readLine();
            
            // Reads each line of the CSV file and splits it into x and y values
            String line;
            while ((line = reader.readLine()) != null) 
            {
                // Splits the line into x and y values
                String[] values = line.split(",");

                // If the line contains 2 values, parse them as integers and add them to the x and y values array lists
                if (values.length == 2) 
                {
                    try 
                    {
                        // Parse the x and y values as integers and add them to the array lists
                        int x = Integer.parseInt(values[0].trim());
                        int y = Integer.parseInt(values[1].trim());
                        xValues.add(x);
                        yValues.add(y);
                    } 
                    
                    // If the x or y value is not a valid integer, catch the exception and print an error message
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

    /*
     * This method plots the x and y values from a CSV file using JFreeChart.
     * @param fileName the name of the CSV file to read from
     * Source that helped: https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm
     */
    public void plotCSV(String fileName) throws IOException {
        
        // Read the CSV data and makes arrays for x and y values
        int[][] data = readCSV(fileName);
        int[] xValues = data[0];
        int[] yValues = data[1];

        // Create a new series for the x and y values
        XYSeries series = new XYSeries("Data Points");

        // Adds the x and y values to the series
        for (int i = 0; i < xValues.length; i++) 
        {
            series.add(xValues[i], yValues[i]);
        }

        // Create new collection titled dataset to hold the series
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Create the chart
        JFreeChart chart = ChartFactory.createXYLineChart("CSV Data Plot",  "X Values","Y Values", dataset);

        // Display the chart in a frame
        ChartFrame frame = new ChartFrame("Data Visualization", chart);
        frame.pack();
        frame.setVisible(true);
    }

    /*
     * This method converts an ArrayList of integers to an array of integers.
     * @param list the ArrayList to convert
     * @return the array of integers
     */
    private int[] convertToArray(ArrayList<Integer> list) {
        
        // Creates a new array of integers with the same size as the ArrayList
        int[] array = new int[list.size()];

        // Fills the array with the values from the ArrayList
        for (int i = 0; i < list.size(); i++) 
        {
            array[i] = list.get(i);
        }

        // Returns the array of integers
        return array;
    }


}
