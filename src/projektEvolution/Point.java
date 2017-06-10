package projektEvolution;

public class Point {
	double[] vector;
	public Point(double[] vector) {
		setVector(vector);
	}
	public Point() {

	}
	double substract(Point a, Point b) {
		return 0;
	}
	double absoluteValue(double a) {
		return a > 0 ? a : (-a);
	}
	public void setVector(double[] vector) {
		this.vector = vector;
	}
	public double[] getVector() {
		return this.vector;
	}
}