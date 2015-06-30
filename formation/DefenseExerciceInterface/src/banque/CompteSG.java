package banque;

public class CompteSG implements ICompteBancaire
{

	private double solde;
	private String noCompte;
	
	public CompteSG(double soldeInitial, String noCompte) 
	{
		this.solde = soldeInitial;
		this.noCompte =noCompte;
	} 
	
	@Override
	public void deposer(double montant) {
		this.solde += montant;
	}

	@Override
	public boolean retirer(double montant) {
		if (montant <= solde)
		{
			solde -= montant;
			return true;
		}
		return false;
	}

	@Override
	public double getSolde() {
		return solde;
	}

	@Override
	public String toString() {
		return "CompteSG [solde=" + solde + ", noCompte=" + noCompte + "]";
	}
	
	@Override
	public int compareTo(ICompteBancaire o) {
		System.out.println("comparaison de " + this.noCompte + " avec autre compte");
		if (this.getSolde() > o.getSolde())
			return 1;
		if (this.getSolde() < o.getSolde())
			return -1;
		return 0;
	}
	

	
}
