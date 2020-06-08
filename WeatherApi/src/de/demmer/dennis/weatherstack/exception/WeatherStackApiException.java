package de.demmer.dennis.weatherstack.exception;


public class WeatherStackApiException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private int code;
	
	public WeatherStackApiException(int code) {
		super("The server at responded with code: " + code  + ".\nPlease look at https://weatherstack.com/documentation#api_error_codes for more information");
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
	
	

}
