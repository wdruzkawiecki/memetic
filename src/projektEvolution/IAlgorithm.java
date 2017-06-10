package projektEvolution;

public interface IAlgorithm {
	/* Interfejs definiuj�cy metody wymagane do zaimplementowania przez konkretne klasy algorytm�w.
	 * Na razie wszystkie zwracaj� void..
	 * */
	public void Mutation();
	public void Crossover();
	public void SurvivorSelection();
	public void StopCondition();
	public void Run();
	public void ReturnResultPopulation();
}
