public class Disc {
	
	private int layer;
	private int height = 50;
	private int width;
	private Peg pegOn;
	
	public Disc(Peg peg) {
		pegOn = peg;
		layer = pegOn.getDiscs().size()+1;
		width = 200/layer;
	}
	
	public int getWidth() {return width;}
	
	public int getLayer() {
		return layer;
	}
	
	public String toString() {
		return ("Disc at Layer " + layer + ": Width of " + width);
	}
}
