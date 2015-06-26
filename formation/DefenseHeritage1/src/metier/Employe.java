package metier;

public class Employe extends Personne {

	private String noTel;
	
	public String getNoTel() {
		return noTel;
	}

	public void setNoTel(String noTel) {
		this.noTel = noTel;
	}


	public Employe(String nom, String prenom, String noTel) {
		super(nom, prenom);
		this.noTel = noTel;
	}

	@Override
	public void contacter(String message) {
		System.out.println("appel pour " + message + " a " + getNoTel());

	}

}
