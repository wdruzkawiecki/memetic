package projektEvolutionReadWrite;
import java.util.ArrayList;
import java.util.List;
import projektEvolution.Point;

public class Findings {
	
	List<Point> pointsResult;
	
	int iterationCount;
	
	public Findings()
	{
		pointsResult = new ArrayList<Point>();
		iterationCount = 0;
	}
	
	void addPoint(Point pointParam)
	{
		pointsResult.add(pointParam);
	}
	
	void setIterationCount(int param)
	{
		iterationCount = param;
	}
	
	List<Point> getPointsResult()
	{
		return pointsResult;
	}
	
	int getIterationCount()
	{
		return iterationCount;
	}
}
