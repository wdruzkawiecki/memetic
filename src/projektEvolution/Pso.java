package projektEvolution;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Random;

public class Pso implements IAlgorithm {
    private Random generator = new Random();
    private Population pop = new Population();

    private double[] valueRastriginList = new double[POP_SIZE];
    private double[] pBest = new double[POP_SIZE];

    //do rastrigina
    public Point p1 = new Point;
    public double[] vector;
    private double z;

    //stałe?
    double w;
    double c1 = 2.0;
    double c2 = 2.0;


    //obliczanie wartości funkcji
    public void calculateRastrigin() {
        vector = p1.getVector();
        int A = 10;
        int n = 2;
        // f(x) = A * n + E(xi^2 - A * cos(2pi * xi))
        z = A * n;
        for(int i = 0; i < n; i++) {
            z += (Math.pow(p1.vector[i], 2) - A * Math.cos(2 * Math.PI * p1.vector[i]));
        }
    }

    //do pętli zwrot wartości
    public double valueRastrigin() {
        for(int i=0; i<POP_SIZE; i++) {
            calculateRastrigin();
            valueRastriginList[i] = z;
        }
    }

    public void Mutation(CreatureA a) {
        for(int i=0; i<POP_SIZE; i++) {
            double[] x = a.getVector();
            double[] v = a.getVelocity();
            double r1 = generator.nextDouble();
            double r2 = generator.nextDouble();
            for(int i=0; i<x.length; i++) {
                v[i] = (w * v[i]) + ( c1 * r1 * (pBestLocation.get(i).getLoc()[0] - x[i]) + ( c2 * r2  * (gBestLocation.getLoc()[0] - x[i]);
                x[i] = x[i] + v[i];
            }
        }
    };

    public void Crossover() {
        if(x[i].xlb<xgb)
            xgb=x[i].xlb;
    };

    public void SurvivorSelection() {
        for (int i; i<POP_SIZE; i++)
            if(x[i]>xgb)
                xgb=x[i];
    };

    public void StopCondition() {

    };

    public void Run() {
        initializePopulation();
        valueRastrigin();

/*
        int i,j;
        for (i=0; i<iter; i++) {
            for (j=0; j<POP_SIZE; j++) {
                Mutation();
                Crossover();
                SurvivorSelection();
            }
        }*/

				double r1 = generator.nextDouble();
				double r2 = generator.nextDouble();

				Point v = new Point(); //speed
                Point p = new Point(); //vector

                //speed
				double[] newSpeed = new double[2];
				newSpeed[0] = (w * v.getVector()[0]) +
							(r1 * c1) * (pBestLocation.get(i).getLoc()[0] - p.getVector()[0]) +
							(r2 * c2) * (gBestLocation.getLoc()[0] - p.getVector()[0]);
				newSpeed[1] = (w * v.getVector()[1]) +
							(r1 * c1) * (pBestLocation.get(i).getLoc()[1] - p.getVector()[1]) +
							(r2 * c2) * (gBestLocation.getLoc()[1] - p.getVector()[1]);
                v.setVector(newSpeed);

                //vector
				double[] newVector = new double[2];
				newVector[0] = p.getVector()[0] + newSpeed[0];
				newVector[1] = p.getVector()[1] + newSpeed[1];
                p.setVector(newVector);

				CreatureA c = new CreatureA(newVector, newSpeed);
                pop.addPoint(c);
			}
    };

    public void ReturnResultPopulation() {

    };

    public void initializePopulation() {
        for (int i=0; i<POP_SIZE; i++) {
            Point p = new Point();

            double[] vector = new double[2];
            vector[0] = X1 + generator.nextDouble() * (X2 - X1);
            vector[1] = X1 + generator.nextDouble() * (X2 - X1);
            p.setVector(vector);

            Point v = new Point();

            double[] speed = new double[2];
            speed[0] = V1 + generator.nextDouble() * (V2 - V1);
            speed[1] = V1 + generator.nextDouble() * (V2 - V1);
            v.setVector(speed);

            CreatureA c = new CreatureA(vector, speed);

            pop.addPoint(c);
        }
    }
}
