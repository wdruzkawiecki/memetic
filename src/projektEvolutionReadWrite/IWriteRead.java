package projektEvolutionReadWrite;
import projektEvolutionReadWrite.Findings;

public interface IWriteRead {

	String Save(Findings param);
	Findings Read();
}
