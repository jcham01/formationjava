package principal;

import metier.*;

public class Program {

	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle(1, 10, 1, 5);
		Rectangle r2 = new Rectangle(2, 7, 0, 8);
		Rectangle r3 = new Rectangle(2, 12, 6, 8);
		System.out.println("r1 collisione r2 ?" + Rectangle.isCollision(r1, r2));
		System.out.println("r1 collisione r3 ?" + Rectangle.isCollision(r1, r3));
		System.out.println("r2 collisione r3 ?" + Rectangle.isCollision(r2, r3));
		
		System.out.println(r1.getAire());
		

		Produit p1 = new Produit(1, "table tek noire", 79.99, 2.5);
		System.out.println(p1);
		System.out.println("15 tables = " + p1.getPrice(15));
		
		
	}

}
