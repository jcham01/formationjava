package principal;

import echec.Piece;
import echec.Pion;

public class Program {

	public static void main(String[] args) {
		Piece p1 = new Pion(3, 4, Piece.BLANCHE);
		Piece p2 = new Pion(5, 7, Piece.NOIRE);
		
		System.out.println(p1.getMouvements());
		System.out.println(p2.getMouvements());
		
		

	}

}
