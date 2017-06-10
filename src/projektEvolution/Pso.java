package projektEvolution;

import java.util.Random;

public class Pso implements IAlgorithm {
    private Random generator = new Random();
    private Population pop = new Population();
    private double[] valueList = new double[POP_SIZE];

    //stałe?
    double w;
    double c1 = 2.0;
    double c2 = 2.0;

    //do pętli zwrot wartości
    private double getValueList(Point p) {
            IFunction rastr = new RastriginFunction();
            return rastr.getValue(p);
    }

    //pozycja najmniejsza w liście
    public static int getMinPos(double[] list) {
        int pos = 0;
        double minValue = list[0];
        for(int i=0; i<list.length; i++) {
            if(list[i] < minValue) {
                pos = i;
                minValue = list[i];
            }
        }
        return pos;
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
    }

    public void Crossover() {
        if(x[i].xlb<xgb)
            xgb=x[i].xlb;
    }

    public void SurvivorSelection() {
        for (int i; i<POP_SIZE; i++)
            if(x[i]>xgb)
                xgb=x[i];
    }

    public void StopCondition() {

    }

    public void Run() {
        initializePopulation(domain, v, pop_size);
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

    public void ReturnResultPopulation() {

    }

    //Podajemy dziedzinę, z jakiej mamy korzystać A(x0, y0), B(x1, y1), początkowy wektor v(-1,1), populację 1000
    private void initializePopulation(Domain domain, Point v, int pop_size) {
        for (int i = 0; i < pop_size; i++) {
            //Dwa punkty, które określają dziedzinę
            Point A, B;
            //Wyciągamy lewy górny róg i prawy dolny róg
            A = domain.getTopLeftCorner();
            B = domain.getBottomRightCorner();

            Point p = new Point();

            double[] vector = new double[2];
            vector[0] = A.getVector()[0] + generator.nextDouble() * (B.getVector()[0] - A.getVector()[0]);
            vector[1] = B.getVector()[1] + generator.nextDouble() * (A.getVector()[1] - B.getVector()[1]);
            p.setVector(vector);

            double[] speed = new double[2];
            speed[0] = v.getVector()[0] + generator.nextDouble() * (v.getVector()[1] - v.getVector()[0]);
            speed[1] = v.getVector()[0] + generator.nextDouble() * (v.getVector()[1] - v.getVector()[0]);
            v.setVector(speed);

            CreatureA c = new CreatureA(vector, speed);

            pop.addPoint(c);
        }
    }
}
