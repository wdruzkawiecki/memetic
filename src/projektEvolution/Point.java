package projektEvolution;

public class Point {
	double[] vector;
	double substract(Point a, Point b) {
		return 0;
	}
	double absoluteValue(double a) {
		return a > 0 ? a : (-a);
	}

	public Point(){

	}

	public Point(Point point){
		this.vector = new  double[point.getVector().length];
		for(int i=0; i < point.getVector().length; i++){
			this.vector[i] = point.getVector()[i];
		}
	}

	public void setVector(double[] vector) {
		this.vector = vector;
	}

	public double[] getVector() {
		return this.vector;
	}

	public double getValue(){
		return Math.sqrt(absoluteValue(vector[0])*absoluteValue(vector[0]) + absoluteValue(vector[1])*absoluteValue(vector[1]));
	}
}
