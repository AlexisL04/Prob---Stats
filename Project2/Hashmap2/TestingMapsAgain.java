package Project2.Hashmap2;

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
