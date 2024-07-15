package h.inherit.ex3;

public class CircleController {
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return "면적 : " + c.toString() +" / " + c.getRadius() * c.getRadius() * Math.PI;
	}
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return "둘레 : "+ c.toString() +" / " + 2 * Math.PI * c.getRadius();
	}
}
