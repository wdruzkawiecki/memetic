package projektEvolutionReadWrite;
import java.util.ArrayList;
import java.util.List;
import projektEvolution.Point;

public class Findings {
	
	Point pointsResult;
	
	int iterationCount;
	
	public Findings()
	{
		pointsResult = new Point();
		iterationCount = 0;
	}
	
	void setPoint(Point pointParam)
	{
		pointsResult = pointParam;
	}
	
	void setIterationCount(int param)
	{
		iterationCount = param;
	}
	
	Point getPointsResult()
	{
		return pointsResult;
	}
	
	int getIterationCount()
	{
		return iterationCount;
	}
}
