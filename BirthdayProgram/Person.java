/*
 * Author: Alexis Lopez
 * The Person class contains methods and variables needed to store and get a person's birthday.
 */
package BirthdayProgram;

public class Person {
    
    // The birthday variable stores the birthday of a person in the format MMDD
    private int birthday;

    /*
     * Constructor for the Person class, initializes the birthday to 0101
     * @param none
     * @return none
     */
    public Person()
    {
        birthday = 0101;
    }

    /*
     * Constructor for the Person class, initializes the birthday to the given birthday
     * @param birthday the birthday we want to set
     * @return none
     */
    public Person(int birthday)
    {
        this.birthday = birthday;
    }

    /*
     * Gets the birthday of a person
     * @param none
     * @return the birthday as an int
     */
    public int getBirthday()
    {
        return birthday;
    }

}
