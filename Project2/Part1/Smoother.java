package Project2.Part1;

import java.io.IOException;


public class Smoother
{

    public void smoothData(String fileName, int window) throws IOException
    {
        
        CSVHandler csvHandler = new CSVHandler();
        int[][] data = csvHandler.readCSV(fileName);

        int[] xValues = data[0];
        int[] yValues = data[1];

        for (int i = 0; i < xValues.length; i++)
        { 

            int start = Math.max(0, i - window);
            int end = Math.min(xValues.length - 1, i + window);
            int sum = 0;
            int count = 0;

            for (int j = start; j <= end; j++)
            {
                sum += yValues[j];
                count++;
            }

            yValues[i] = sum / count; 

        }

        csvHandler.writeCSV(xValues, yValues);

    }
}
