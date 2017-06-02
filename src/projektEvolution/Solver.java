package projektEvolution;

import projektEvolution.notify.Notifier;

public class Solver extends Notifier<Population> {
	private IAlgorithm algorithm;
	private Domain domain;
	private IFunction function;
	private Population initialPopulation;
	private Notifier<Population> notifier;
	
	private void solve(){
		// metoda, kt�ra b�dzie odpowiada�a za konkretne obliczenia
	}
	
	public Solver(IAlgorithm algorithm, Domain domain, IFunction function, Population initialPopulation) {
		this.algorithm = algorithm;
		this.domain = domain;
		this.function = function;
		this.initialPopulation = initialPopulation;
		this.notifier = new Notifier<Population>();
	}
	
	public Population getSolution() {
		// metoda zwracaj�ca wynikow� populacj�
		this.solve();
		return new Population();
	}

	public Notifier<Population> getNotifier(){
		return notifier;
	}
}
