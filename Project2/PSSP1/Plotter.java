package Project2.PSSP1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Plotter
{

    public String convertToCSV(){
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> data = new ArrayList<>();

        System.out.println("What would you like to call the file?");
        String fileName = scanner.nextLine() + ".csv";

        System.out.println("How many data points would you like to plot?");
        int numPoints = scanner.nextInt();

        scanner.close();
        data.add("X,Y");

        for(int x = 0; x < numPoints; x++)
        {
            double y = Math.pow(x, 2);
            data.add(x + "," + y);
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

    /*
    public double ySquared(double y)
    {
        return y * y;
    }
    */
}
