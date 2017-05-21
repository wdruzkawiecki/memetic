package projektEvolution;

public class Solver {
	private IAlgorithm algorithm;
	private Domain domain;
	private IFunction function;
	private Population initialPopulation;
	
	private void solve(){
		// metoda, która bêdzie odpowiada³a za konkretne obliczenia
	}
	
	public Solver(IAlgorithm algorithm, Domain domain, IFunction function, Population initialPopulation) {
		this.algorithm = algorithm;
		this.domain = domain;
		this.function = function;
		this.initialPopulation = initialPopulation;
	}
	
	public Population getSolution() {
		// metoda zwracaj¹ca wynikow¹ populacjê
		this.solve();
		return new Population();
	}
}
