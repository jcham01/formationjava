package echec;

public class Pion extends Piece {

	public Pion(int positionX, int positionY, int couleur) {
		super(positionX, positionY, couleur);
	}

	@Override
	public String getMouvements() {
		return getDeplacements(0, (getCouleur() == BLANCHE)? 1 : -1, 1);
	}

	
	
	/*
	
	@Override
	public String getMouvements() {
		int deplY = 0;
		// je détermine la direction du mouvement en Y en fonction de la couleur
		// les pions blanc monte vers les case du haut
		// le pions noir descende
		if (getCouleur() == BLANCHE) {
			deplY = 1;
		}
		else {
			deplY = -1;
		}
		// je genere la nouvelle position en fonction de la direction
		int newPos = getPositionY() + deplY;
		// je vérifie que l'on ne sort pas de l'echiquier
		if (newPos >= 1 || newPos <= 8) {
			// conversion pour affichage de la colonne en lettre
			return "" + colonnes.charAt(getPositionX() - 1) + newPos;
		}
		else {
			// on est au bord de l'echiquier, le pion ne peu plus se déplacer
			return "";
		}
	}
*/
}
