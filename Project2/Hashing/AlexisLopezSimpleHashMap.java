/*
 * Author: Alexis Lopez
 * 
 * This is a simple hash map implementation using linked list array using Strings as the data type.
 * This was my first time trying to implement a hash map by myself, As I have stated in the TestingMapsAgain file,
 * I have used hash maps before but never really understood how they worked until now. Ive only ever used them in order to get my project done
 * So this was refreshing and fun to implement such a simple mechanic and see how it works, even though it is way inferior to the built in hashmap
 */
package Project2.Hashing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class AlexisLopezSimpleHashMap {
    
    public LinkedList<String>[] data;

    /*
     * This is the default constructor for the simple hash map.
     * It creates a linked list array of size 3 and initializes each element to a new linked list.
     */
    public AlexisLopezSimpleHashMap(){
        
        data = new LinkedList[3];
        
        for (int i = 0; i < data.length; i++)
        {
            data[i] = new LinkedList<String>();
        }

    }

    /*
     * This is the constructor for the simple hash map.
     * It creates a linked list array of size size and initializes each element to a new linked list.
     * @param size the size of the linked list array
     */
    public AlexisLopezSimpleHashMap(int size){
        
        data = new LinkedList[size];
        
        for (int i = 0; i < data.length; i++)
        {
            data[i] = new LinkedList<String>();
        }

    }

    /*
     * This is a simple hash function that returns the length of the word.
     * @param word the word to hash
     * @return the length of the word
     */
    public int simpleHash(String word)
    {
        return word.length();
    }

    /*
     * This method checks if the word is in the hash map.
     * @param word the word to check
     * @return true if the word is in the hash map, false otherwise
     */
    public boolean contains(String word){
        
        int index = simpleHash(word) % data.length;
        return data[index].contains(word);

    }
    

    /*
     * This method resizes the hash map to double its size.
     * It creates a new linked list array of size double the current size and rehashes all the words in the old array to the new array
     * @param none
     * @return none
     */
    public void resize()
    {

        // Create a new linked list array of double the size of the current array
        LinkedList<String>[] newData = new LinkedList[data.length * 2];

        // Initialize each element of the new array to a new linked list
        for (int i = 0; i < newData.length; i++)
        {

            newData[i] = new LinkedList<String>();

        }

        // Rehash all the words in the old array to the new array
        for (LinkedList<String> list : data)
        {
            // Loop through each linked list in the old array
            for (String word : list)
            {
                // Calculate the index for the new array using the simple hash function and adds the word to the new linked list
                int index = simpleHash(word) % newData.length;
                newData[index].add(word);
            }
        }

        // Replace the old array with the new array
        data = newData;
        
    }

    /*
     * This method adds a word to the hash map.
     * @param word the word to add
     * @return none
     */
    public void hashAdd(String word)
    {

        // Check if the total size of all linked lists is greater than or equal to the length of the data array
        int totalSize = 0;
        for (LinkedList<String> list : data) 
        {
            totalSize += list.size();
        }

        // If the total size is greater than or equal to the length of the data array, resize the array
        if (totalSize >= data.length) 
        {
            resize();
        }

        // creates the index value for the word
        int index = simpleHash(word) % data.length;
        
        // adds the word to the linked list at the index
        data[index].add(word);
        

    }

    /*
     * This method returns all the words in the hash map as a string.
     * @param none
     * @return a string containing all the words in the hash map
     */
    public String hashRevealAll()
    {
        // Create a new string builder to hold the result
        StringBuilder result = new StringBuilder();
        
        // Loop through each linked list in the data array
        for (LinkedList<String> list : data)
        {
            // Loop through each word in the linked list and append it to the result string builder
            for (String word : list)
            {
                result.append(word).append(" ");
            }
        }
        
        // Return the result string builder as a string, trimmed to remove anything unnecessary
        return result.toString().trim();
    }

    /*
     * This method returns the size of the hash map.
     * @param none
     * @return the size of the hash map
     */
    public int hashSize()
    {
        return data.length;
    }

    /*
     * This method removes a word from the hash map.
     * @param none
     * @return none
     */
    public void hashRemove(String word)
    {
        int index = simpleHash(word) % data.length;
        data[index].remove(word);
    }

    /*
     * Reads a CSV file and hashes the first column of each row.
     * Aswell as times how long it takes to hash the words.
     * Source: https://stackoverflow.com/questions/21858686/measure-time-taken-by-insert-operation-on-the-arraylist-and-linkedlist
     * @param fileName the name of the CSV file to read from
     * @return none
     */
    public void hashCSV(String fileName) throws IOException 
    {

        // Creates a variable to hold the start time of the hashing process
        long startTime = System.currentTimeMillis();


        // Creates a new buffered reader to read the CSV file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        

            // Reads each line of the CSV file and splits it into columns
            String line;
            while ((line = reader.readLine()) != null) {
                
                try 
                {
                    // Split the line by comma and take only the first column
                    String[] columns = line.split(",");

                    // If the line contains at least one column, hash the first column
                    if (columns.length > 0) 
                    {
                        
                        // Trim the first column and check if it is not empty before hashing
                        String firstColumn = columns[0].trim();

                        // Check if the first column is not empty before hashing
                        if (!firstColumn.isEmpty()) 
                        {
                            // Hash the first column and add it to the hash map
                            hashAdd(firstColumn);
                        }
                    }

                }

                // If the first column is not a valid string, catch the exception and print an error message
                catch (NumberFormatException e) 
                {
                    System.err.println("Skipping invalid line: " + line);
                }
            }
        }

        // Print the contents the time taken to hash the words
        System.out.println("Time taken to hash the words: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    

}




