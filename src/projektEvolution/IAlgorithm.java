package projektEvolution;

public interface IAlgorithm {
	public int Mutation();
	public int Crossover();
	public int SurvivorSelection();
	public int StopCondition();
	public int Run();
	public int ReturnResultPopulation();
}
