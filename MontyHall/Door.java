package MontyHall;

import java.util.Random;

public class Door {
    
    private String[] gameShow;

    public Door(){
        gameShow = new String[3];
    }

    //This class should be able to set doors 1-3 with 1 prize and 2 duds. It uses rng to set one of the possibilites to one door
    public void setDoor()
    {
        String[] prizes = {"goat", "goat", "car"};

        boolean[] isSet = new boolean[3];

        Random random = new Random();

        for(int i = 0; i < gameShow.length; i++)
        {
            int randomNum = random.nextInt(3);

            while(isSet[randomNum])
            {
                randomNum = random.nextInt(3);
            }

            gameShow[randomNum] = prizes[i];
            isSet[randomNum] = true;
        }

    }

    public String getDoor(int doorNum){

        if (doorNum >= 0 && doorNum < gameShow.length)
        {
            return gameShow[doorNum];
        }
        else
        {
            return "Invalid Door";
        }

    }

}
