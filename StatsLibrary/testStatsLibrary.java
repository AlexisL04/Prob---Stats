package StatsLibrary;
public class testStatsLibrary {
    
    public static void main(String[] args) {
        
        statsLibrary test = new statsLibrary();

        int[] someNumbers = {1,2,3,3,3,3,4,5,5,5,5};

        int[] someNumbers2 = {1,2,3};

        int n = 6;

        System.out.println("Our result: " + test.findMultinomialCoefficients(n, someNumbers2));

        //System.out.println("our result: " + test.getMean(someNumbers));

        //System.out.println("Our results: " + test.getMedian(someNumbers));

        //System.out.println("Our result: " + test.getMode(someNumbers));
    }
}
