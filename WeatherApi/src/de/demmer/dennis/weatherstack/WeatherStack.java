package de.demmer.dennis.weatherstack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.JSONObject;

import de.demmer.dennis.weatherstack.exception.WeatherStackApiException;
import de.demmer.dennis.weatherstack.model.Location;
import de.demmer.dennis.weatherstack.model.Weather;

public class WeatherStack {

	private String apiKey;

	public WeatherStack(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * 
	 * @param location a town or region
	 * @return a Weather object
	 * @throws WeatherStackApiException
	 */
	public Weather getWeatherFromLocation(String location) throws WeatherStackApiException{
		
		try {
			location = location.replaceAll(" ", "%");
		
		 	URL url = new URL("http://api.weatherstack.com/current?access_key="+ apiKey +"&query="+location);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        con.setRequestMethod("GET");
	        int responseCode = con.getResponseCode();
	        
	        if(responseCode != 200) {
	        	throw new WeatherStackApiException(responseCode);
	        }

	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

	        String inputLine;
	        StringBuffer content = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	            content.append(inputLine);
	        }
	        in.close();
	        con.disconnect();
	        
			return parseJSON(content.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	
	}

	private Weather parseJSON(String request) throws WeatherStackApiException {
		Weather weather = new Weather();
		JSONObject weatherJSON = new JSONObject(request);

		if (!weatherJSON.isNull("error")) {
			int code = weatherJSON.getJSONObject("error").getInt("code");
			throw new WeatherStackApiException(code);
		}

		JSONObject current = weatherJSON.getJSONObject("current");
		weather.setTemperature(current.getDouble("temperature"));
		weather.setObservationTime(current.getString("observation_time"));
		weather.setCloudcover(current.getInt("cloudcover"));
		weather.setWeatherDescriptions((List<String>) (List<?>) current.getJSONArray("weather_descriptions").toList());
		weather.setWeatherIcons((List<String>) (List<?>) current.getJSONArray("weather_icons").toList());
		weather.setWindSpeed(current.getDouble("wind_speed"));

		Location location = new Location();
		JSONObject locationJson = weatherJSON.getJSONObject("location");
		location.setCountry(locationJson.getString("country"));
		location.setName(locationJson.getString("name"));
		location.setRegion(locationJson.getString("region"));
		location.setLocaltime(locationJson.getString("localtime"));
		location.setLat(locationJson.getDouble("lat"));
		location.setLon(locationJson.getDouble("lon"));

		weather.setLocation(location);
		return weather;
	}

}
