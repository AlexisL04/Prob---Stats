package Project2.PSSP1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVHandler {
    
    public String writeCSV(int[] xValues, int[] yValues){
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> data = new ArrayList<>();

        System.out.println("What would you like to call the file?");
        String fileName = scanner.nextLine() + ".csv";

        scanner.close();
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
        result[0] = xValues.stream().mapToInt(Integer::intValue).toArray();
        result[1] = yValues.stream().mapToInt(Integer::intValue).toArray();
        
        return result;
    }

}
