package projektEvolution;

public interface IAlgorithm {
	/* Interfejs definiuj�cy metody wymagane do zaimplementowania przez konkretne klasy algorytm�w.
	 * Na razie wszystkie zwracaj� Object..
	 * */
	int POP_SIZE = 100000;

	public Object Mutation();
	public Object Crossover();
	public Object SurvivorSelection();
	public Object StopCondition();
	public Object Run();
	public Object ReturnResultPopulation();
}
