package projektEvolution;

public interface IAlgorithm {
	/* Interfejs definiuj�cy metody wymagane do zaimplementowania przez konkretne klasy algorytm�w.
	 * Na razie wszystkie zwracaj� Object..
	 * */
	int POP_SIZE = 100000;
	double X1 = -5;
	double Y1 = 5;
	double X2 = 5;
	double Y2 = -5;
    double V1 = -1;
    double V2 = 1;

	public Object Mutation();
	public Object Crossover();
	public Object SurvivorSelection();
	public Object StopCondition();
	public Object Run();
	public Object ReturnResultPopulation();
}
