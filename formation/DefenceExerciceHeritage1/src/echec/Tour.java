package echec;

public class Tour extends Piece {

	public Tour(int positionX, int positionY, int couleur) {
		super(positionX, positionY, couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMouvements() {
		// deplacement vers le haut, le bas
		// la gauche et la droite
		return getDeplacements(1, 0, 7) 
			+ getDeplacements(-1, 0, 7)
			+ getDeplacements(0, 1, 7)
			+ getDeplacements(0, -1, 7);
	}

}
