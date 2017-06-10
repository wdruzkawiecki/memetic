package projektEvolution;

import java.util.ArrayList;
import java.util.List;

public class EvolutionAlgorithm implements IAlgorithm {

	public Population initialPopulation;
	public Population resultPopulation;
	private int initialPopulationCount = 0;
	IFunction function;
	private static double spare;
	private static boolean isSpareReady = false;
	double tau1 = 1/(Math.sqrt(2*Math.sqrt(2)));
	double tau2 = 1/(Math.sqrt(4));
	
	public EvolutionAlgorithm(Population initialPopulation, IFunction function) {
		this.initialPopulation = initialPopulation;
		this.function = function;
		this.initialPopulationCount = initialPopulation.pointList.size();
	}
	
	public void Mutation() {
		double sigmaX = 1;
		double sigmaY = 1;
		for(int i = 0; i<initialPopulation.pointList.size(); i++) {
			sigmaX = sigmaX*Math.exp(getGaussian(0, tau1) + getGaussian(0, tau2)); //TODO: drugi gaussian do poprawy
			sigmaY = sigmaY*Math.exp(getGaussian(0, tau1) + getGaussian(0, tau2));
			initialPopulation.pointList.get(i).vector[0] = getGaussian(initialPopulation.pointList.get(i).vector[0], sigmaX);
			initialPopulation.pointList.get(i).vector[1] = getGaussian(initialPopulation.pointList.get(i).vector[1], sigmaY);
		}
	}

	public void Crossover(Point p1, Point p2) {
		double waga1 = Math.random();
		double waga2 = 1 - waga1;
		
		Point p3 = new Point();
		
		double [] vectorZ = new double[2];
		vectorZ[0] = waga1 * p1.vector[0] + waga2 * p2.vector[0];
		vectorZ[1] = waga1 * p1.vector[1] + waga2 * p2.vector[1];
		
		p3.setVector(vectorZ);
		initialPopulation.addPoint(p3);
	}

	public void SurvivorSelection() {
		for (int i = 0; i < initialPopulation.pointList.size(); i++) {
			//TODO: Zrobiæ dopasowanie dla punktów, posortowaæ i zwróciæ najlepsze do initialPopulationSize
			
		}
	}

	public Boolean StopCondition() {
		return false;
	}

	public void Run() {
		while(!StopCondition()) {
			Mutation();
			Crossover();
			SurvivorSelection();
		}
	}

	public void ReturnResultPopulation() {
		
	}

	public void Crossover() {
		for(int i=0; i<initialPopulation.pointList.size(); i++) {
			if(i%2 == 0 && i < (initialPopulation.pointList.size() - 1)) {
				Crossover(initialPopulation.pointList.get(i), initialPopulation.pointList.get(i));
			}
		}
		
	}
	
	private static synchronized double getGaussian(double mean, double stdDev) {
	    if (isSpareReady) {
	        isSpareReady = false;
	        return spare * stdDev + mean;
	    } else {
	        double u, v, s;
	        do {
	            u = Math.random() * 2 - 1;
	            v = Math.random() * 2 - 1;
	            s = u * u + v * v;
	        } while (s >= 1 || s == 0);
	        double mul = Math.sqrt(-2.0 * Math.log(s) / s);
	        spare = v * mul;
	        isSpareReady = true;
	        return mean + stdDev * u * mul;
	    }
	}
	
	
	
}
