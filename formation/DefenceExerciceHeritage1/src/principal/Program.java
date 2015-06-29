package principal;

import echec.*;

public class Program {

	public static void main(String[] args) {
		Piece p1 = new Pion(3, 4, Piece.BLANCHE);
		Piece p2 = new Pion(5, 7, Piece.NOIRE);
		Piece p3 = new Tour(5, 7, Piece.NOIRE);
		Piece p4 = new Fou(5, 7, Piece.BLANCHE);
		
		System.out.println(p1.getMouvements());
		System.out.println(p2.getMouvements());
		System.out.println(p3.getMouvements());
		System.out.println(p4.getMouvements());
		
		

	}

}
