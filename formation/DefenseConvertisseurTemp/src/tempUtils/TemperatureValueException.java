package tempUtils;

public class TemperatureValueException extends RuntimeException {

	private double temperature;
	public double getTemperature() {
		return temperature;
	}


	public TemperatureValueException(double temperature) {
		super("temperature impossible : " + temperature);
		this.temperature = temperature;
	}

	
}
