package projektEvolution;

import projektEvolution.notify.ISubject;

import java.util.ArrayList;

public class Population implements ISubject {
	Domain domain;
	ArrayList<Point> pointList;

	public Population() {
		this.pointList = new ArrayList<Point>();

		double[] topLeft = new double[2];
		double[] bottomRight = new double[2];

		topLeft[0] = -1000;
		topLeft[1] = 1000;
		bottomRight[0] = 1000;
		bottomRight[1] = -1000;

		Point topLeftCorner = new Point(topLeft);
		Point bottomRightCorner = new Point(bottomRight);

		this.domain = new Domain(topLeftCorner, bottomRightCorner);
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
