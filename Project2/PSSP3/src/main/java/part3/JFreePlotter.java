package Project2.PSSP3.src.main.java.part3;

import java.io.IOException;
import java.util.Scanner;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class JFreePlotter {
    
    private XYSeries squaredData;
    private XYSeriesCollection dataset;
    private JFreeHandler jFreeHandler;

    public int squared(int x) {
        return x * x;
    }

    public void createData() throws IOException{

        squaredData = new XYSeries( "Data" );  
        dataset = new XYSeriesCollection( );       
        jFreeHandler = new JFreeHandler();
           

        Scanner scanner = new Scanner(System.in);
        

        System.out.println("How many data points would you like to plot?");
        int numPoints = scanner.nextInt();

        System.out.println("What would you like to call the file?");
        String fileName = scanner.next() + ".csv";
        
        int[] xValues = new int[numPoints];
        int[] yValues = new int[numPoints];

        scanner.close();

        for (int i = 0; i < numPoints; i++) {
            int yValue = squared(i);
            
            xValues[i] = i;
            yValues[i] = yValue;

            squaredData.add(i, yValue);
        }

        dataset.addSeries( squaredData );
        jFreeHandler.writeCSV(xValues, yValues, fileName);
        jFreeHandler.plotCSV(fileName);


    }

}
