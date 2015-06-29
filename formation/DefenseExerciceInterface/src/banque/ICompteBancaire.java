package banque;

public interface ICompteBancaire extends Comparable<ICompteBancaire>
{
	public void deposer(double montant);
	public boolean retirer(double montant);
	public double getSolde();

}
