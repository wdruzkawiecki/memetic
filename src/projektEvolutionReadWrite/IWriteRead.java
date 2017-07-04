package projektEvolutionReadWrite;
import projektEvolutionReadWrite.Findings;

public interface IWriteRead {

	Boolean Save(Findings param);
	Findings Read();
}
