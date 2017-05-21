package projektEvolution;

public class Domain {
	public Point topLeftCorner;
	public Point bottomRightCorner;
	
	public Domain(Point topLeftCorner, Point bottomRightCorner) {
		this.topLeftCorner = topLeftCorner;
		this.bottomRightCorner = bottomRightCorner;
	}
	public void setTopLeftCorner(Point topLeftCorner) {
		this.topLeftCorner = topLeftCorner;
	}
	public void setBottomRightCorner(Point bottomRightCorner) {
		this.bottomRightCorner = bottomRightCorner;
	}
	public Point getTopLeftCorner() {
		return this.topLeftCorner;
	}
	public Point getBottomRightCorner() {
		return this.bottomRightCorner;
	}
}
