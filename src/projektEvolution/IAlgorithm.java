package projektEvolution;

import projektEvolution.notify.Notifier;

public interface IAlgorithm {
	/* Interfejs definiuj�cy metody wymagane do zaimplementowania przez konkretne klasy algorytm�w.
	 * Na razie wszystkie zwracaj� void..
	 * */
	public void Mutation();
	public void Crossover();
	public void SurvivorSelection();
	public Boolean StopCondition();
	public void Run();
	public Population ReturnResultPopulation();
	public Notifier getNotifier();
}
