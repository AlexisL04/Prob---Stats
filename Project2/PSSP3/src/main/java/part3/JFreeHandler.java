package Project2.PSSP3.src.main.java.part3;

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
    
    public String writeCSV(int[] xValues, int[] yValues, String fileName){
        
        ArrayList<String> data = new ArrayList<>();

        data.add("X,Y");

        for(int i = 0; i < xValues.length; i++)
        {
            data.add(xValues[i] + "," + yValues[i]);
        }

        try 
        {
            FileWriter csvOutputFile = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(csvOutputFile);

            for (String line : data) 
            {
                pw.println(line);
            }
            
            pw.close();
            return fileName;
        } 
        
        catch (IOException e) 
        {
            System.err.println("Error writing to CSV: " + e.getMessage());
            return null;
        }

    }

    public int[][] readCSV(String fileName) throws IOException 
    {
        ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Integer> yValues = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Skip header row
            reader.readLine();
            
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] values = line.split(",");
                if (values.length == 2) 
                {
                    try 
                    {
                        int x = Integer.parseInt(values[0].trim());
                        int y = Integer.parseInt(values[1].trim());
                        xValues.add(x);
                        yValues.add(y);
                    } 
                    
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

    public void plotCSV(String fileName) throws IOException {
        
        // Read the CSV data and makes arrays for x and y values
        int[][] data = readCSV(fileName);
        int[] xValues = data[0];
        int[] yValues = data[1];

        // Create the dataset
        XYSeries series = new XYSeries("Data Points");
        for (int i = 0; i < xValues.length; i++) {
            series.add(xValues[i], yValues[i]);
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Create the chart
        JFreeChart chart = ChartFactory.createXYLineChart("CSV Data Plot",  "X Values","Y Values", dataset);

        // Display the chart in a frame
        ChartFrame frame = new ChartFrame("Data Visualization", chart);
        frame.pack();
        frame.setVisible(true);
    }

    private int[] convertToArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

}
