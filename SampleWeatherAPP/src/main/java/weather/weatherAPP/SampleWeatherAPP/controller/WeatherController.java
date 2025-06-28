package weather.weatherAPP.SampleWeatherAPP.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
	private final String API_KEY = "af011ed0a20c4d08f74f9d52c80597a6";
	private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";
	
	@GetMapping("/{city}")
	public ResponseEntity<String> getWeather(@PathVariable String city)
	{
		String url = String.format(BASE_URL, city, API_KEY);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
	}
}
