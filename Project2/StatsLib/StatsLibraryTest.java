public class StatsLibraryTest {
    
    public static void main(String[] args) {
        StatsLibrary statsLib = new StatsLibrary();

        // Poisson
        
        System.out.println("Poisson(4, 7): " + statsLib.poissonDist(4, 7));
        System.out.println("Poisson(2, 14): " + statsLib.poissonDist(2, 14) + "\n");

        // Poisson Expected and Variance

        System.out.println("Poisson Expected and Variance(7): " + statsLib.poissonExpected(7));
        System.out.println("Poisson Expected and Variance(14): " + statsLib.poissonExpected(14) + "\n");
        
        // Poisson STD

        System.out.println("Poisson STD(7): " + statsLib.poissonSTD(7));
        System.out.println("Poisson STD(14): " + statsLib.poissonSTD(14) + "\n");


        // Tchebysheff

        System.out.println("Tchebysheff with k = 2 and >= (2, 1): " + statsLib.tchebysheff(2, 1));
        System.out.println("Tchebysheff with k = 3 and <= (3, 2): " + statsLib.tchebysheff(3, 2) + "\n");

        // Uniform Distribution

        System.out.println("Uniform Distribution with a range of (10, 30): " + statsLib.uniformDist(10, 30));
        System.out.println("Uniform Distribution with a range of (20, 10): " + statsLib.uniformDist(20, 10) + "\n");

        // Uniform Expected

        System.out.println("Uniform Expected with a range of (10, 30): " + statsLib.uniformExpected(10, 30));
        System.out.println("Uniform Expected with a range of (20, 10): " + statsLib.uniformExpected(20, 10) + "\n");
        

    }

}
