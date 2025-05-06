/*
 * Author: Alexis Lopez
 * 
 * This class tests the simple hash map implementation by adding, removing, and checking for the presence of words in the hash map.
 * We also read a CSV file and hash the words in it and time it to see how long it takes to hash the words.
 * 
 * Overall, having implemented a simple hash map, I feel as though i have a better understanding of how hash maps work and how they are implemented
 * Using this new info, i can better implement hash maps into my own projects and understand how they work under the hood rather than going
 * in blind and having to spend time trying to figure out how they work and how to use them on the internet
 */
package Project2.Hashing;
import java.io.IOException;

public class AlexisLopezSimpleHashMapTest {

    public static void main(String[] args) throws IOException {

        //Testing hashing
        AlexisLopezSimpleHashMap map = new AlexisLopezSimpleHashMap(3);
        map.hashAdd("hello");
        map.hashAdd("world");
        map.hashAdd("java");

        System.out.println(map.contains("hello")); // true
        System.out.println(map.contains("world")); // true
        System.out.println(map.contains("java")); // true
        System.out.println(map.contains("pythonn")); // false

        System.out.println(map.hashSize());
        System.out.println(map.hashRevealAll());

        System.out.println("Removing java");

        map.hashRemove("java");

        System.out.println(map.hashRevealAll());

        System.out.println("adding 2 words to resize map");

        map.hashAdd("python");
        map.hashAdd("c++");

        System.out.println(map.hashSize());
        System.out.println(map.hashRevealAll());

        // Hashing a CSV file

        AlexisLopezSimpleHashMap map2 = new AlexisLopezSimpleHashMap(3);

        System.out.println("Hashing 100Words.csv");
        map2.hashCSV("100Words.csv");
        System.out.println(map2.hashRevealAll());
        System.out.println(map2.hashSize());

        AlexisLopezSimpleHashMap map3 = new AlexisLopezSimpleHashMap(3);

        System.out.println("Hashing 1000Words.csv");
        map2.hashCSV("1000Words.csv");
        System.out.println(map3.hashRevealAll());
        System.out.println(map3.hashSize());


        

    }
}
