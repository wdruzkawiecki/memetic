package projektEvolution;

public interface IAlgorithm {
	/* Interfejs definiuj¹cy metody wymagane do zaimplementowania przez konkretne klasy algorytmów.
	 * Na razie wszystkie zwracaj¹ Object..
	 * */
	public Object Mutation();
	public Object Crossover();
	public Object SurvivorSelection();
	public Object StopCondition();
	public Object Run();
	public Object ReturnResultPopulation();
}
