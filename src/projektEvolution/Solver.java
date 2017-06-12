package projektEvolution;

import projektEvolution.notify.Notifier;
import projektEvolution.notify.Observer;

public class Solver extends Notifier<Population> {
	private IAlgorithm algorithm;
	private Domain domain;
	private IFunction function;
	private Population initialPopulation;
	private Observer<Population> observer;
	
	private void solve(){
		EvolutionAlgorithm evolutionAlgorithm = new EvolutionAlgorithm(initialPopulation, function);

		evolutionAlgorithm.notifyAll();
	}

	public Solver(IAlgorithm algorithm, Domain domain, IFunction function, Population initialPopulation) {
		this.algorithm = algorithm;
		this.domain = domain;
		this.function = function;
		this.initialPopulation = initialPopulation;
		this.observer = new PopulationObserver(algorithm.getNotifier());
	}
	
	public Population getSolution() {
		// metoda zwracaj¹ca wynikow¹ populacjê
		this.solve();
		return new Population();
	}

}
