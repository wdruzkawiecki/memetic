package projektEvolution;

public class CreatureA extends Point {
    private double[] velocity;
    private double value;

    public CreatureA(double[] position, double[] velocity) {
        super(position);
        setVelocity(velocity);

        //WAT?!
        Point tmp = new tmp;
        tmp.setVector(position);
        setValue(tmp);
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

    public void setValue(Point position) {
        IFunction rastr = new RastriginFunction();
        this.value = rastr.getValue(position);
    }

    public double getValue() {
        return this.value;
    }
}
