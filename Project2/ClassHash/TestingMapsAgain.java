/*
 * Author: Alexis Lopez
 * 
 * This class is a test for hashmaps as we have gone over in class.
 * 
 * This was pretty fun as my professor for DSA 1 briefly covered the topic rather than going into detail about it.
 * Although I have used hashmaps previously for this course, I have had to research the topic in order to understand how I can implement it
 * into my code. This was the first time I have really had the chance to properly learn about it in a lecture and ask questions about it.
 */
package Project2.ClassHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class TestingMapsAgain {
    
    public static void main(String[] args) {
        
        TreeMap<String, Integer> hm = new TreeMap<>();

        hm.put("Tom", 1);
        hm.put("Brandon", 22);
        hm.put("Lisa", 3);
        hm.put("Brandon", 2);
        hm.put("Jerry", 3);

        //Sometimes helpfull to have a "super" data structure
        HashMap<String, ArrayList<String>> shm = new HashMap<>();
        HashMap<HashMap<String, Integer>, ArrayList<String>> shm2 = new HashMap<>();


        System.out.println("The size of my map is: " + hm.size());
        System.out.println("What is Lisa? " + hm.get("Lisa"));

        for (String singleValue : hm.keySet()){
            System.out.println(singleValue);
        }

    }
}
