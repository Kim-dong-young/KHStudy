package h.inherit.ex3;

public class RectangleController {
	private Rectangle r = new Rectangle();
	
	public String calcArea(int x,int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		return "면적 : "+ r.toString() +" / " + r.getWidth() * r.getHeight();
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		return "둘레 : "+ r.toString() +" / " + (r.getWidth() + r.getHeight()) * 2;
	}
	
}
