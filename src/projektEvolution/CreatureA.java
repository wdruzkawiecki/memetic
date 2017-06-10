package projektEvolution;

public class CreatureA extends Point {
    private double[] velocity;

    public CreatureA(double[] positon, double[] velocity) {
        super(positon);
        setVelocity(velocity);
    }

    double substract(Point a, Point b) {
        return 0;
    }

    double absoluteValue(double a) {
        return a > 0 ? a : (-a);
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public double[] getVelocity() {
        return this.velocity;
    }
}
