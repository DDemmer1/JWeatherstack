package de.demmer.dennis.weatherstack.model;

public class Location {

	private String name;
	private String country;
	private String region;
	private double lat;
	private double lon;
	private String localtime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getLocaltime() {
		return localtime;
	}

	public void setLocaltime(String localtime) {
		this.localtime = localtime;
	}

	@Override
	public String toString() {
		return "Location [name=" + name + ", country=" + country + ", region=" + region + ", lat=" + lat + ", lon="
				+ lon + ", localtime=" + localtime + "]";
	}

}
