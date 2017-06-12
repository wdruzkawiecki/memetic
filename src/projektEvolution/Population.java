package projektEvolution;

import projektEvolution.notify.ISubject;

import java.util.ArrayList;
import java.util.List;

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

	public void addPoint(Point p) {
		this.pointList.add(p);
	}

	public ArrayList<Point> getPointList() {
		return this.pointList;
	}

	public Point getPoint(int i){
		return pointList.get(i);
	}

	public static Population CreateInitialPopulation(int populationSize)
	{

		//TODO: Initial population
		return new Population();
	}

	public void setPoint(int i, Point point) {
		this.pointList.set(i, point);
	}

}
