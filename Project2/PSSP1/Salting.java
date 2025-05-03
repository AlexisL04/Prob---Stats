package Project2.PSSP1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Salting 
{

    public void saltData(String fileName, String outputFile, int min, int max) throws IOException 
    {
        ArrayList<String> data = new ArrayList<>();
        data.add("X,Y");
        BufferedReader reader = null;

        Random rand = new Random();


        try 
        {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) 
            {
                String[] values = line.split(",");
                if (values.length == 2) 
                {
                    int x = Integer.parseInt(values[0].trim());
                    double y = Double.parseDouble(values[1].trim());
                    
                    int yMod = rand.nextInt(max - min + 1) + min;
                    
                    int decision = rand.nextInt(2); // 0 or 1
                    if (decision == 0) 
                    {
                        yMod = (int) y + yMod;
                    } 
                    else 
                    {
                        yMod = (int) y - yMod;
                    }


                    data.add(x + "," + yMod);
                }
            }
        }

        finally 
        {
            try 
            {
                if (reader != null) 
                {
                    reader.close();
                }
            } 
            catch (IOException e) 
            {
                System.err.println("Error closing the file: " + e.getMessage());
            }
        }

        // writes to an output file
        try (FileWriter writer = new FileWriter(outputFile)) 
        {
            for (String line : data) 
            {
                writer.write(line);
                writer.write(System.lineSeparator());
        
            }
        }
    }
}
