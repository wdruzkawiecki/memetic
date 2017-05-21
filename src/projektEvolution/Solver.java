package projektEvolution;

public class Solver {
	private IAlgorithm algorithm;
	private Domain domain;
	private IFunction function;
	private Population initialPopulation;
	
	private void solve(){
		// metoda, kt�ra b�dzie odpowiada�a za konkretne obliczenia
	}
	
	public Solver(IAlgorithm algorithm, Domain domain, IFunction function, Population initialPopulation) {
		this.algorithm = algorithm;
		this.domain = domain;
		this.function = function;
		this.initialPopulation = initialPopulation;
	}
	
	public Population getSolution() {
		// metoda zwracaj�ca wynikow� populacj�
		this.solve();
		return new Population();
	}
}
