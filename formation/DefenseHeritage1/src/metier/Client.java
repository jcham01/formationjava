package metier;

public final class Client extends Personne
{
	private String email;
	private double solde;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client(String nom,
				String prenom,
				String email,
				double solde) {
		super(nom, prenom);
		setEmail(email);
		setSolde(solde);
	}
	
	@Override
	public String toString() {
		return super.toString() + " et " + getEmail();
	}
	/*
	public void afficher() {
		
	}*/
	@Override
	public void contacter(String message) {
		System.out.println("envoie " + message + " a " + getEmail());
		
	}
	
	
	
	
	
	
}
