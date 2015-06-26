package metier;

public abstract class Personne // extends Object
{
	private String nom;
	protected String prenom;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Personne() {
		this("", "");
	}
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	}
	

	public final void afficher() {
		System.out.println(this.toString());
	}
	
	public abstract void contacter(String message);
	
	
	
	
}
