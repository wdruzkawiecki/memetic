package projektEvolution;

import java.util.*;

public class RandomGen {
    
    int randInt(int x, int y)
    {
        Random r = new Random();
        int number = r.nextInt(y)-x;
        return number;
    }
    
    int[][] randFunction(int ax, int ay, int bx, int by)
    {
        int[][] finalTab;
        finalTab = new int[ay-ax][2];
        int limiter = ay-ax;
        for(int iter = 0; iter < limiter; iter++)
        {
            finalTab[iter][0] = randInt(ax, ay); // wspolrzedna pozioma
            finalTab[iter][1] = randInt(bx, by); // wspolrzedna pionowa
        } 
        return finalTab;
    }
}