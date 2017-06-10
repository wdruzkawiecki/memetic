package projektEvolution;

public class Creature {
    Point positon;
    Point velocity;

    public Creature(Point positon, Point velocity) {
        setPositon(positon);
        setVelocity(velocity);
    }

    public void setPositon(Point positon) {
        this.positon = positon;
    }

    public Point getPosition() {
        return this.positon;
    }

    public void setVelocity(Point velocity) {
        this.velocity = velocity;
    }

    public Point getVelocity() {
        return this.velocity;
    }
}
