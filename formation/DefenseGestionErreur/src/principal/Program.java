package principal;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws Exception
	{
		Scanner reader = new Scanner(System.in);
		String saisie = "";
		int age = 0;
		while (true) {
			try {
				System.out.println("saisissez votre age:");
				saisie = reader.nextLine();
				age = Integer.parseInt(saisie);
				System.out.println("vous avez " + age + " ans");
				break;
			}
			catch (NumberFormatException ex) {
				System.out.println("erreur format declenchée : " + ex.getMessage());
				System.out.println("recommencez svp");
			}
			catch (Exception ex) {
				System.out.println("erreur autre : " + ex.getMessage());
				// je ne sais pas gérer clea
				// donc je redéclenche une nouvelle exception
				// pour indique l'erreur "annulation de la saisie"
				Exception myexception = new Exception("saisie annulée");
				throw myexception;
			}
		}
		System.out.println("fin programme");
	}

}
