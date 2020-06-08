package de.demmer.dennis.weatherstack.model;

import java.util.List;

public class Weather {
	
	private Location location;
    private String observationTime;
    private double temperature;
    private List<String> weatherDescriptions;
    private List<String> weatherIcons;
    private double windSpeed;
    private int cloudcover;
    
    
    
    
    
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getObservationTime() {
		return observationTime;
	}
	public void setObservationTime(String observationTime) {
		this.observationTime = observationTime;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public List<String> getWeatherDescriptions() {
		return weatherDescriptions;
	}
	public void setWeatherDescriptions(List<String> weatherDescriptions) {
		this.weatherDescriptions = weatherDescriptions;
	}
	public List<String> getWeatherIcons() {
		return weatherIcons;
	}
	public void setWeatherIcons(List<String> weatherIcons) {
		this.weatherIcons = weatherIcons;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public int getCloudcover() {
		return cloudcover;
	}
	public void setCloudcover(int cloudcover) {
		this.cloudcover = cloudcover;
	}
	
	
	@Override
	public String toString() {
		return "Weather [location=" + location + ", observationTime=" + observationTime + ", temperature=" + temperature
				+ ", weatherDescriptions=" + weatherDescriptions + ", weatherIcons=" + weatherIcons + ", windSpeed="
				+ windSpeed + ", cloudcover=" + cloudcover + "]";
	}
    

	
	

	

}
