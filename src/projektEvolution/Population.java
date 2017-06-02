package projektEvolution;

import java.util.ArrayList;

public class Population {
	ArrayList<Point> pointList;
	public Population() {
		this.pointList = new ArrayList<Point>();
	}
	public Population(ArrayList<Point> pointList) {
		this.pointList = pointList;
	}
	public void addPoint(Point p) {
		this.pointList.add(p);
	}
	public ArrayList<Point> getPointList() {
		return this.pointList;
	}
}