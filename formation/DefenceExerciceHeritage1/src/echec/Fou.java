package echec;

public class Fou extends Piece {

	public Fou(int positionX, int positionY, int couleur) {
		super(positionX, positionY, couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMouvements() {
		return getDeplacements(-1, -1, 7) +
			getDeplacements(-1, 1, 7) +
			getDeplacements(1, 1, 7) +
			getDeplacements(1, -1, 7);
	}

}
