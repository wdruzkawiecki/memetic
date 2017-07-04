package projektEvolutionReadWrite;
import projektEvolution.Point;

public class Findings {
	
	Point pointsResult;
	
	int iterationCount;
	int localExtremum;
	int globalExtremum;
	
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
	
	void setLocalExtremum(int param)
	{
		localExtremum = param;
	}
	
	int getLocalExtremum()
	{
		return localExtremum;
	}
	
	void setGlobalExtremum(int param)
	{
		globalExtremum = param;
	}
	
	int getGlobalExtremum()
	{
		return globalExtremum;
	}
	
	
	
}
