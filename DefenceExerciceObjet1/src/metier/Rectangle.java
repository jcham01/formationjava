package metier;

public class Rectangle {

	// attributs
	
	public static final int X1_DEFAUT = 0;
	public static final int X2_DEFAUT = 3;
	public static final int Y1_DEFAUT = 0;
	public static final int Y2_DEFAUT = 2;
	public final String style;
	
	private int x1, x2, y1, y2;

	// getter / setter
	public int getX1() {return x1;}
	public void setX1(int x1) {
		if (x1 < 0)
			this.x1 = X1_DEFAUT;
		else
			this.x1 = x1;
	}
	public int getX2() {return x2;}
	public void setX2(int x2) {this.x2 = x2;}
	public int getY1() {return y1;}
	public void setY1(int y1) {this.y1 = y1;}
	public int getY2() {return y2;}
	public void setY2(int y2) {this.y2 = y2;}
	
	// constructeurs
	
	public Rectangle() { this(X1_DEFAUT, X2_DEFAUT, Y1_DEFAUT, Y2_DEFAUT );}
	public Rectangle(int x1, int x2, int y1, int y2) {
		style="dotted";
		setX1(x1);
		setX2(x2);
		setY1(y1);
		setY2(y2);
		
	}
	
	
	// methodes
	
	public double getAire() {
		return (getX2() - getX1()) * (getY2() - getY1());
	}
	
	public void affichage() {
		System.out.println("rectangle (" + getX1() + "," + getX2()
							+ "," + getY1() + "," + getY2()+ ")");
	}
	
	public static boolean isCollision(Rectangle r1, Rectangle r2) {
		return !(r1.getX2() < r2.getX1() ||
			    r1.getX1() > r2.getX2() ||
			    r1.getY2() < r2.getY1() ||
			    r1.getY1() > r2.getY2());
		
	}
	
	
}
