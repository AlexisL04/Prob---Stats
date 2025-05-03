package Project2.Part1;

import java.io.IOException;

public class SaltingTest {
    
    public static void main(String[] args) throws IOException {
        Salting salting = new Salting();

        String inputFile = "testPlot.csv";
        String outputFile = "testSalt.csv";
        int min = 10000;
        int max = 100000;

        salting.saltData(inputFile, outputFile, min, max);
    }

}
