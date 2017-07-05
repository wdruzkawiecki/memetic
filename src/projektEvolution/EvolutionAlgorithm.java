package projektEvolution;

import projektEvolution.notify.Notifier;

import java.util.*;

public class EvolutionAlgorithm implements IAlgorithm {

    private static double spare;
    private static boolean isSpareReady = false;
    public Population initialPopulation;
	public Population resultPopulation;
	IFunction function;
	double tau1 = 1/(Math.sqrt(2*Math.sqrt(2)));
	double tau2 = 1/(Math.sqrt(4));
	Notifier<Population> notifier;
    private int initialPopulationSize = 0;
    private int iterationsCount = 0;
    private int maxIterations = 0;


	public EvolutionAlgorithm(Population initialPopulation, IFunction function, int maxIterations) {
		this.initialPopulation = initialPopulation;
		this.resultPopulation = new Population(initialPopulation);
		this.function = function;
		this.initialPopulationSize = initialPopulation.pointList.size();
		this.maxIterations = maxIterations;
		this.notifier = new Notifier<Population>();
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

	public void Mutation() {

		double sigmaX = 1;
		double sigmaY = 1;
		for(int i = 0; i<resultPopulation.pointList.size(); i++) {
            sigmaX = sigmaX * Math.exp(getGaussian(0, tau1) + getGaussian(0, tau2));
            sigmaY = sigmaY*Math.exp(getGaussian(0, tau1) + getGaussian(0, tau2));
			resultPopulation.pointList.get(i).vector[0] = getGaussian(resultPopulation.pointList.get(i).vector[0], sigmaX);
			resultPopulation.pointList.get(i).vector[1] = getGaussian(resultPopulation.pointList.get(i).vector[1], sigmaY);
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
		resultPopulation.addPoint(p3);
	}

	public void SurvivorSelection() {
        HashMap<Point, Double> hashArray = new HashMap<>();

        for (Point point : this.resultPopulation.getPointList()) {
            hashArray.put(point, this.function.getValue(point));
        }

        HashMap<Point, Double> sortedHashMap = this.sortByValues(hashArray);

        this.resultPopulation = new Population();

        int i = 0;
        for (Map.Entry<Point, Double> entry : sortedHashMap.entrySet()) {
            if (i < 100) {
                this.resultPopulation.addPoint(entry.getKey());
                System.out.println("(" + entry.getKey().getVector()[0] + ", " + entry.getKey().getVector()[1] + ") : " + entry.getValue());
                i++;
            }
        }
    }

    private HashMap<Point, Double> sortByValues(HashMap<Point, Double> map) {
        List list = new LinkedList<>(map.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        HashMap sortedHashMap = new LinkedHashMap<>();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

	public Boolean StopCondition() {
		int condition = 0;

		while (this.iterationsCount >= this.maxIterations) {
			condition++;
		}

		return condition > 0;
	}

	public void Run() {
		while(!StopCondition()) {
			Mutation();
			Crossover();
			SurvivorSelection();
			this.iterationsCount++;
			this.notifier.notify(resultPopulation);
		}
	}

	public Population ReturnResultPopulation() {
		return this.resultPopulation;
	}

	public void Crossover() {
		for(int i=0; i<resultPopulation.pointList.size(); i++) {
			if(i%2 == 0 && i < (resultPopulation.pointList.size() - 1)) {
				Crossover(resultPopulation.pointList.get(i), resultPopulation.pointList.get(i));
			}
		}

    }

	@Override
	public Notifier getNotifier() {
		return this.notifier;
	}

}
