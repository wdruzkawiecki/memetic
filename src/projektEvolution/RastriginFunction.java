package projektEvolution;

public class RastriginFunction implements IFunction {
	private int A = 10;
	private int n = 2;
	
	public double getValue(Point p) {
		// f(x) = A * n + E(xi^2 - A * cos(2pi * xi))
		double z = A * n;
		for(int i = 0; i < n; i++) {
			z += (Math.pow(p.vector[i], 2) - A * Math.cos(2 * Math.PI * p.vector[i]));
		}
		return z;
	}

}
