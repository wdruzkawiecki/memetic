package projektEvolution;

import java.util.Comparator;

public class FitnessComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        return (p1.getValue() < p2.getValue()) ? -1 : (p1.getValue() == p2.getValue()) ? 0 : 1;
    }
}
