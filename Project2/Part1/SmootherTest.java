package Project2.Part1;

import java.io.IOException;

public class SmootherTest {
    
    public static void main(String[] args) throws IOException {
        Smoother smoother = new Smoother();
        String inputFile = "testSalt.csv";
        int windowSize = 10;
        
        smoother.smoothData(inputFile, windowSize);
    }

}
