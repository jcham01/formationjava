package tempUtils;

public class TemperatureFormatException extends RuntimeException {

	public TemperatureFormatException() {
		super("unite non supportée, utiliser K,C ou F");
	}
	
	

}
