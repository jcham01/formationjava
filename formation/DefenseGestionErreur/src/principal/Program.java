package principal;

import java.util.Scanner;

import mylib.AgeException;

public class Program {

	public static void main(String[] args) throws Exception
	{
		Scanner reader = new Scanner(System.in);
		String saisie = "";
		int age = 0;
		while (true) {
			try {
				age = saisieAge();
				System.out.println("vous avez " + age + " ans");
				break;
			}
			catch (AgeException ex) {
				System.out.println("erreur sur l'age " + ex.getMessage());
				break;
			}
			catch (Exception ex) {
				System.out.println("erreur autre dans main: " + ex.getMessage());
				// je ne sais pas gérer clea
				// donc je redéclenche une nouvelle exception
				// pour indique l'erreur "annulation de la saisie"
				Exception myexception = new Exception("saisie annulée");
				throw myexception;
			}
		}
		System.out.println("fin programme");
	}
	
	public static int saisieAge() throws AgeException
	{
		Scanner reader = new Scanner(System.in);
		String saisie = "";
		int age = 0;
		while (true) {
			try {
				System.out.println("saisissez votre age:");
				saisie = reader.nextLine();
				age = Integer.parseInt(saisie);
				if (age < 0 || age > 250)
				{
					AgeException ae = new AgeException(age);
					throw ae;
				}
				return age;
			}
			catch (NumberFormatException ex) {
				System.out.println("erreur format declenchée dans saisieAge: " + ex.getMessage());
				System.out.println("recommencez svp");
			}
			finally {
				System.out.println("nettoyage dans saisieAge");
			}
		}
		
	}

}
