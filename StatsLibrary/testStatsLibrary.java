/*
 * Author: Alexis Lopez
 * 
 * This is a test class for the StatsLibrary class. It tests all the methods in the StatsLibrary class.
 */
package StatsLibrary;
public class testStatsLibrary {
    
    public static void main(String[] args) {
        
        statsLibrary test = new statsLibrary();

        int[] someNumbers = {1,2,3,3,3,3,4,5,5,5,5};

        int[] someNumbers2 = {1,2,3};

        int n = 6;

        System.out.println("Calculating multinomial coefficients: n = 6 and numerators being 1 2 and 3");
        System.out.println("Multinomial Coefficients: " + test.findMultinomialCoefficients(n, someNumbers2) + "\n");

        System.out.println("Calculating the mean, median, mode, variance, and STD of the following numbers: 1,2,3,3,3,3,4,5,5,5,5");
        System.out.println("Mean: " + test.getMean(someNumbers));

        System.out.println("Median: " + test.getMedian(someNumbers));

        System.out.println("Mode: " + test.getMode(someNumbers));

        System.out.println("Variance: " + test.getVariance(someNumbers));

        System.out.println("Standard Deviation: " + test.getStandardDeviation(someNumbers) + "\n");

        System.out.println("MxN for 6 x 6:");
        System.out.println("MxN: " + test.findMN(6, 6) + "\n");

        System.out.println("Calculating the factorial of 5:");
        System.out.println("Our result for Factorial: " + test.factorial(5) + "\n");

        double[] axiomTests = {.1, .2, .3, .4};
        double[] axiomTest3 = {.5, .5};

        System.out.println("For True - Calculating Axioms 1 and 2 for the following numbers: .1, .2, .3, .4");
        System.out.println("Our result for Axiom 1: " + test.probabilityAxiomOne(axiomTests));

        System.out.println("Our result for Axiom 2: " + test.probabilityAxiomTwo(axiomTests) + "\n");

        System.out.println("Calculating Axiom 3 with the previous list of numbers and comparing it with the following numbers: .5, .5");
        System.out.println("Our result for Axiom 3: " + test.probabilityAxiomThree(axiomTests, axiomTest3) + "\n");

        double[] axiomTestsF = {-.1};
        double[] axiomTest3F1 = {.5, .5};
        double[] axiomTest3F2 = {.4, .5};

        System.out.println("For False - Calculating Axioms 1 and 2 for the following numbers: -.1");
        System.out.println("Our result for Axiom 1: " + test.probabilityAxiomOne(axiomTestsF));

        System.out.println("Our result for Axiom 2: " + test.probabilityAxiomTwo(axiomTestsF) + "\n");

        System.out.println("Calculating Axiom 3 with the following numbers: .5, .5 and .4, .5");
        System.out.println("Our result for Axiom 3: " + test.probabilityAxiomThree(axiomTest3F1, axiomTest3F2) + "\n");
        
        double[] arrayA = { .1, .4, .5, };
        double[] arrayB = { .2, .3, .4, };
        System.out.println("Calculating the intersection of the following arrays: { .1, .4, .5 } and { .2, .3, .4 }");
        System.out.println("Array Intersect: " + test.arrayIntersect(arrayA, arrayB) + "\n");

        System.out.println("Calculating dependancy: A = .4, B = .5, and P(A|B) = .2");
        System.out.println("Dependancy: " + test.checkDependancy(.4, .5, .2));
        System.out.println("Calculating dependancy: A = .3, B = .5, and P(A|B) = .2");
        System.out.println("Dependancy: " + test.checkDependancy(.3, .5, .2) + "\n");

        System.out.println("Calculating the conditional probability of the following: A = .3, AAndB = .1");
        System.out.println("Conditional probability: " + test.calculateConditionalProbability(.3, .1) + "\n"); 

        System.out.println("Calculating the following for Dependency Intersection: A = .3, B = .4, and P(AAndB) = .1");
        System.out.println("Dependancy Intersection: " + test.calculateDependancyIntersection(.3, .4, .1) + "\n");


        System.out.println("Our result for calculating Dependancy Union: " + test.calculateExclusivityUnion(.3, .4, .5));


        double[] AGivenB = {0.2, 0.3, 0.5};
        double[] B = {0.1, 0.4, 0.5};
        System.out.println("Our result for total probability: " + test.totalProbability(AGivenB, B) + "\n");

        System.out.println("Calculating the following for Bayes Theorem: A = .3, B = .6, P(A|B) = .4, and P(B) = .5");
        System.out.println("Our result for Bayes Theorem: " + test.calculateBayesTheorem(.3, .6, .4, .5) + "\n");

        double[] probabilities = {0.2, 0.3, 0.5};
        double[] events = {1, 2, 3};

        System.out.println("Calculating the expected, variance, and STD for the following: 0.2, 0.3, 0.5 and 1, 2, 3");
        System.out.println("Our result for random expected: " + test.expectedRandom(probabilities, events) + "\n");

        System.out.println("Our result for random variance: " + test.varianceRandom(probabilities, events) + "\n");

        System.out.println("Our result for random standard deviation: " + test.standardDeviationRandom(probabilities, events));
    }
}
