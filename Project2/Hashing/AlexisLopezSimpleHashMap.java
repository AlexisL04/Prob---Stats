package Project2.Hashing;

import java.util.LinkedList;

public class AlexisLopezSimpleHashMap {
    
    public LinkedList<String>[] data;

    public AlexisLopezSimpleHashMap(){
        
        data = new LinkedList[3];
        
        for (int i = 0; i < data.length; i++)
        {
            data[i] = new LinkedList<String>();
        }

    }

    public AlexisLopezSimpleHashMap(int size){
        
        data = new LinkedList[size];
        
        for (int i = 0; i < data.length; i++)
        {
            data[i] = new LinkedList<String>();
        }

    }

    public int simpleHash(String word)
    {
        return word.length();
    }



    public boolean contains(String word){
        
        int index = simpleHash(word) % data.length;
        return data[index].contains(word);

    }
    
    public void resize()
    {
        LinkedList<String>[] newData = new LinkedList[data.length * 2];

        for (int i = 0; i < data.length; i++)
        {

            newData[i] = new LinkedList<String>();

        }

        for (LinkedList<String> list : data)
        {
            for (String word : list)
            {
                int index = simpleHash(word) % newData.length;
                newData[index].add(word);
            }
        }

        data = newData;
        
    }

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

    public String hashRevealAll()
    {
        StringBuilder result = new StringBuilder();
        
        for (LinkedList<String> list : data)
        {
            for (String word : list)
            {
                result.append(word).append(" ");
            }
        }
        
        return result.toString().trim();
    }


}




