package projektEvolution;

public class Program {
	public static void main(String args[]) {

        /**
         * TODO
         * Prawidłowa dziedzina przyjdzie z GUI
         */
        Domain domain = new Domain(new Point(new double[]{-10, 10}), new Point(new double[]{10, -10}));

        Population initialPopulation = Population.CreateInitialPopulation(domain, 100);

        Solver solver = new Solver(
                new EvolutionAlgorithm(initialPopulation, new RastriginFunction(), 50),
                domain,
                new RastriginFunction(),
                initialPopulation
        );

        Population result = solver.getSolution();

        System.out.print(result);

	}

}
