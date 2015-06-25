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
		return header(annee, mois);
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
