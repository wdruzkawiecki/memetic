package projektEvolution;

public interface IAlgorithm {
	public Object Mutation();
	public Object Crossover();
	public Object SurvivorSelection();
	public Object StopCondition();
	public Object Run();
	public Object ReturnResultPopulation();
}
