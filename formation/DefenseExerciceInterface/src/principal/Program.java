package principal;

import java.util.Arrays;
import java.util.Random;

import banque.CompteLCL;
import banque.CompteSG;
import banque.ICompteBancaire;

public class Program {

	public static void main(String[] args) {
		
		Random rd = new Random();
		ICompteBancaire[] comptes = new ICompteBancaire[10];
		
		for (int i = 0; i < comptes.length; i++) {
			if (rd.nextBoolean())
				comptes[i] = new CompteLCL(rd.nextDouble() * 500.0 + 100.0, "LCL"+i);
			else
				comptes[i] = new CompteSG(rd.nextDouble() * 500.0 + 100.0, "SG"+i);
		}
		
		for (ICompteBancaire ic : comptes) {
			System.out.println(ic);
		}
		System.out.println("----------------------");
		transfert(comptes[0], comptes[1], 50.0);
		
		
		Arrays.sort(comptes);
		for (ICompteBancaire ic : comptes) {
			System.out.println(ic);
		}
		
		
	}
	
	public static boolean transfert(ICompteBancaire source,
									ICompteBancaire destination,
									double montant) {
		
		if (source.retirer(montant)) 
		{
			destination.deposer(montant);
			return true;
		}
		return false;
	}

}
