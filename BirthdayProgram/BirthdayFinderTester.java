/*
 * Author: Alexis Lopez
 * The BirthdayFinderTester class gives the user the probability of at least two people sharing a birthday in a group of people.
 * The user inputs the number of trials and the number of people in the group.
 */
package BirthdayProgram;

import java.util.Scanner;

public class BirthdayFinderTester {
    
    public static void main(String[] args)
    {
        // create a new instance of the BirthdayFinder class
        BirthdayFinder birthdayFinder = new BirthdayFinder();
        // create a new instance of the Scanner class to read input from the user
        Scanner in = new Scanner(System.in);
        
        // initialize variables
        int trials;
        int numPersons;

        // prompt the user for the number of trials and number of people
        System.out.println("Enter the number of trials: ");
        trials = in.nextInt();
        System.out.println("Enter the number of people: ");
        numPersons = in.nextInt();

        // call the probabilitySharedBirthday method to calculate the probability of at least two people sharing a birthday
        double probability = birthdayFinder.probabilitySharedBirthday(trials, numPersons);

        // print the probability of at least two people sharing a birthday
        System.out.println("The probability of at least two people sharing a birthday in a group of " + numPersons + " people is: " + probability);
    }

}
