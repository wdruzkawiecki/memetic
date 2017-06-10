package projektEvolution;

import java.util.*;

public class RandomGen {
    
    public double randDouble(double x, double y)
    {
        Random r = new Random();
        double zakres = y-x;
        double number = r.nextDouble()*zakres;
        number = number + x;
        return number;
    }
    
    public double[][] randFunctionDouble(double ax, double ay, double bx, double by, int ilePunktow)
    // a - punkt początkowy zakresu na osiach x,y // b - punkt końcowy zakresu na osiach x,y //
    {
        double[][] finalTab;
        finalTab = new double[ilePunktow][2];               // Generacja tablicy punktów puli początkowej //
        for(int iter = 0; iter < ilePunktow; iter++)
        {
            finalTab[iter][0] = randDouble(ax, ay); // Wspolrzedna pozioma
            finalTab[iter][1] = randDouble(bx, by); // Wspolrzedna pionowa   
        } 
        return finalTab;
    }
}