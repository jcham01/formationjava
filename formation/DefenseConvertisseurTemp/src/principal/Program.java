package principal;

import java.util.Scanner;

import tempUtils.TempConverter;
import tempUtils.TemperatureFormatException;
import tempUtils.TemperatureValueException;

public class Program {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		String saisie = "";
		while (true) {
			try {
				System.out.println("saisie temperature (finir par F,C ou K pour l'unite");
				saisie = reader.nextLine();
				TempConverter tc = new TempConverter();
				tc.setTemperatureAsString(saisie);
				
				System.out.println("resultat:");
				System.out.println("en Fahrenheit : " + tc.getTemperatureFahrenheit());
				System.out.println("en Kelvin : " + tc.getTemperatureKelvin());
				System.out.println("en Celsius : " + tc.getTemperatureCelsius());
				break;
			}
			catch (TemperatureFormatException ex) {
				System.out.println("probleme d'unite : " + ex.getMessage());
			}
			catch (TemperatureValueException ex) {
				System.out.println("probleme de valeur : " + ex.getMessage());
			}
			catch (NumberFormatException ex) {
				System.out.println("saisissez une valeur numérique svp!");
			}
		}
		reader.close();

	}

}
