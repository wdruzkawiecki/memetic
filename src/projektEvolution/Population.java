package projektEvolution;

import projektEvolution.notify.ISubject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Population implements ISubject {
	ArrayList<Point> pointList;

	public Population() {
		this.pointList = new ArrayList<Point>();
	}

	public Population(ArrayList<Point> pointList) {
		this.pointList = pointList;
	}

	public Population(Population population) {
		this.pointList = new ArrayList<Point>();

		for(Point point : population.pointList){
			this.pointList.add(new Point(point));
		}
	}

    public static Population CreateInitialPopulation(Domain domain, int populationSize) {
        Population population = new Population();

        double maxX = domain.getTopLeftCorner().getVector()[1];
        double minX = domain.getBottomRightCorner().getVector()[0];

        double maxY = domain.getTopLeftCorner().getVector()[1];
        double minY = domain.getBottomRightCorner().getVector()[0];

        for (int i = 0; i < populationSize; i++) {
            Point newPoint = new Point(new double[]{
                    ThreadLocalRandom.current().nextDouble(minX, maxX + 1),
                    ThreadLocalRandom.current().nextDouble(minY, maxY + 1)
            });
            population.addPoint(newPoint);
        }

        return population;
    }

	public void addPoint(Point p) {
		this.pointList.add(p);
	}

	public ArrayList<Point> getPointList() {
		return this.pointList;
	}

	public Point getPoint(int i){
		return pointList.get(i);
	}

	public void setPoint(int i, Point point) {
		this.pointList.set(i, point);
	}

}
