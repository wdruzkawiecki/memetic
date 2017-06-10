package projektEvolution;

public interface IAlgorithm {
	/* Interfejs definiuj¹cy metody wymagane do zaimplementowania przez konkretne klasy algorytmów.
	 * Na razie wszystkie zwracaj¹ void..
	 * */
	public void Mutation();
	public void Crossover();
	public void SurvivorSelection();
	public void StopCondition();
	public void Run();
	public void ReturnResultPopulation();
}
