/*
 * Author: Alexis Lopez
 * The BirthdayFinder class contains methods and variables needed to find the probability of at least two people sharing a birthday.
 * The class creates a list of people with random birthdays and checks if there are any shared birthdays.
 */
package BirthdayProgram;

import java.util.Random;

public class BirthdayFinder {
    
    private Person[] persons;

    /*
     * Constructor for the BirthdayFinder class, initializes the array of people and the number of people to 0
     * @param none
     * @return none
     */
    public BirthdayFinder()
    {
        persons = new Person[0];
    }

    /*
     * Method to set the birthdays of the people in the array of size numPersons
     * @param numPersons the number of people we want to create
     * @return none
     */
    public void setBirthdays(int numPersons)
    {
        persons = new Person[numPersons];

        Random rand = new Random();

        for (int i = 0; i < numPersons; i++)
        {

            int month = rand.nextInt(12) + 1;
            int day = rand.nextInt(30) + 1;
            int birthday = month * 100 + day;

            persons[i] = new Person(birthday);

        }

    }

    /*
     * Method to check if there are any shared birthdays in the array of people
     * @param none
     * @return true if there are any shared birthdays, false otherwise
     */
    private boolean hasSharedBirthday() 
    {
        
        for (int i = 0; i < persons.length - 1; i++) 
        {
            
            for (int j = i + 1; j < persons.length; j++) 
            {
                
                if (persons[i].getBirthday() == persons[j].getBirthday()) 
                {
                    return true;
                }

            }

        }

        return false;
    }

    public double probabilitySharedBirthday(int trials, int numPersons)
    {
    
        int sharedBirthdays = 0;

        for (int i = 0; i < trials; i++)
        {
            
            // Sets the birthdays of the people in the array of size numPersons
            setBirthdays(numPersons);

            // Checks if there are any shared birthdays
            if (hasSharedBirthday()) 
            {
                sharedBirthdays++;
            }

        }

        // Calculate the probability of at least two people sharing a birthday
        double probability = (double) sharedBirthdays / trials;
        return probability;

    }

    

}
