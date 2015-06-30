package tempUtils;

public class TempConverter {
	public static final double CELSIUS_OFFSET = 273.15;
	public static final double FAHRENHEIT_OFFSET = 32;
	public static final double FAHRENHEIT_FACTOR = 1.8;
	public static final double KELVIN_MINIMUM = 0.0;
	

	public void setTemperatureAsString(String saisie) throws TemperatureFormatException,
															TemperatureValueException 
	{
		saisie = saisie.toUpperCase();
		// le dernier caractere est il un chiffre
		char unite = 'K';
		char lastCharacter = saisie.charAt(saisie.length() - 1);
		if (!Character.isDigit(lastCharacter))
		{
			if (lastCharacter == 'K' || lastCharacter == 'C' || lastCharacter == 'F')
			{
				unite = lastCharacter;
			}
			else
			{
				throw new TemperatureFormatException();
			}
			// comme la saisie contenait une unite
			// on l'enleve de la saisie (on enleve le dernier caractere)
			saisie = saisie.substring(0, saisie.length() - 1);
		}
		// si erreur il y a, remonter a l'appelant
		double t = Double.parseDouble(saisie);
		switch (unite) {
			case 'K':
				setTemperatureKelvin(t);
				break;
			case 'C':
				setTemperatureCelsius(t);
				break;
			case 'F':
				setTemperatureFahrenheit(t);
				break;
		}
	}
	
	
	private double temperatureKelvin;

	public double getTemperatureKelvin() {
		return temperatureKelvin;
	}
	public void setTemperatureKelvin(double temperatureKelvin) {
		if (temperatureKelvin < KELVIN_MINIMUM) {
			throw new TemperatureValueException(temperatureKelvin);
		}
		this.temperatureKelvin = temperatureKelvin;
	}
	
	
	public double getTemperatureCelsius() {
		return getTemperatureKelvin() - CELSIUS_OFFSET;
	}
	public void setTemperatureCelsius(double temperatureCelsius) {
		setTemperatureKelvin(temperatureCelsius + CELSIUS_OFFSET);
	}
	
	public double getTemperatureFahrenheit() {
		return (getTemperatureKelvin() - CELSIUS_OFFSET) 
				* FAHRENHEIT_FACTOR + FAHRENHEIT_OFFSET;
	}
	public void setTemperatureFahrenheit(double temperatureFahrenheit) {
		setTemperatureKelvin((temperatureFahrenheit - FAHRENHEIT_OFFSET)
		 					/ FAHRENHEIT_FACTOR + CELSIUS_OFFSET);
	}
	
	
	

}
