package principal;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("annee ?");
		int annee = Integer.parseInt(reader.nextLine());
		System.out.println("mois");
		int mois = Integer.parseInt(reader.nextLine());
		
		System.out.println(calendrier(annee, mois));

	}
	
	public static String calendrier(int annee, int mois) {
		return header(annee, mois)
				+ corps(annee, mois);
	}
	
	public static String corps(int annee, int mois) {
		StringBuilder sb = new StringBuilder();
		int nbjours = nbJoursMois(annee, mois);
		int debut = jourDebut(annee, mois);
		sb.append("nbjours = " + nbjours + " debut = " + debut);
		return sb.toString();
	}
	
	
	public static int jourDebut(int annee, int mois) {
		int jours = 2; //on commence un mercredi
		
		// commencer une boucle le 1er janvier 1800
		for(int an=1800; an < annee; an++) {
			jours += (estBissextile(an)? 366 : 365);
		}
		// je suis sur le 1er janvier de l'année qui m'intéresse
		for (int m = 1; m < mois; m++) {
			jours+= nbJoursMois(annee, m);
		}
		// on est sur le 1er du mois qui nous intéresse
		return jours % 7;
	}
	
	
	public static int nbJoursMois(int annee, int mois) {
		switch(mois) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				return (estBissextile(annee)? 29 : 28);
		}
		return 0;
	}
	
	
	public static boolean estBissextile(int annee) {
		return (annee % 4 == 0 && annee % 100 != 0 || annee % 400 == 0);
	}
	
	
	
	public static String header(int annee, int mois) {
		StringBuilder sb = new StringBuilder("----------------------------\n");
		sb.append("      ");
		sb.append(nomMois(mois));
		sb.append(" ");
		sb.append(annee);
		sb.append("\n----------------------------\n");
		sb.append(  "LUN MAR MER JEU VEN SAM DIM\n");
		return sb.toString();
	}
	
	public static String nomMois(int mois) {
		String[] tabmois = {"janvier", "fevrier", "mars", "avril", "mai",
					"juin", "juillet", "aout", "septembre", "octobre",
					"novembre", "decembre" };
		
		if (mois < 1 || mois > 12)
			return "";
		return tabmois[mois -1];
	}
	
	

}
