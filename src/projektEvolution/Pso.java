package projektEvolution;

/**
 * Created by tcias on 03.06.2017.
 */

import java.util.Random;

public class Pso implements IAlgorithm {
    private Random generator = new Random();
    private Point p = new Point();
    private Population pop = new Population();

    public void Mutation() {
        x[i].v[j]=w*x[i].v[i-1]+a1*(xlb-x[i-1])+a2*(x[i-1].xgb-x[i-1]);
        x[i]=x[i-1]+x[i].v[i];
    };

    public void Crossover() {
        if(x[i].xlb<xgb)
            xgb=x[i].xlb;
    };

    public void SurvivorSelection() {
        for (int i; i<Populaion.size; i++)
            if(x[i]>xgb)
                xgb=x[i];
    };

    public void StopCondition() {

    };

    public void Run() {
        initializePopulation();
        int i,j;
        for (i=0; i<iter; i++) {
            for (j=0; j<population.size; j++) {
                Mutation();
                Crossover();
                SurvivorSelection();
            }
        }
    };

    public void ReturnResultPopulation() {

    };

    public void initializePopulation() {
        for (int i=0; i<population.size; i++) {
            p = new Point();

            double[] vector = new double[2];
            vector[0] = 5;
            vector[1] = 5;
            p.setVector(vector);

            double[] speed = new double[2];
            speed[0] = 2;
            speed[1] = 2;
            p.setSpeed(speed);

            pop.addPoint(p);
        }
    }
}
