package sample.weather.weatherTesting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {
	private final String API_KEY = "af011ed0a20c4d08f74f9d52c80597a6";
	private final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
	
	@GetMapping("/weather")
		public ResponseEntity<String> getWeather (@RequestParam String city)
		{
			String url = BASE_URL + "?q="+ city + "&appid="+ API_KEY + "&units=metric";
			RestTemplate template = new RestTemplate();
			try {
	            // ✅ Call the API and get a response
	            String response = template.getForObject(url, String.class);

	            // ✅ Return response with 200 OK
	            return ResponseEntity.ok(response);

	        } catch (HttpClientErrorException.NotFound e) {
	            // ✅ Handle 404 City Not Found Error
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body("❌ City Not Found: " + city);

	        } catch (HttpClientErrorException.BadRequest e) {
	            // ✅ Handle 400 Bad Request (wrong parameter, invalid API key, etc.)
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("❌ Bad Request. Please check your input or API Key.");

	        } catch (Exception e) {
	            // ✅ Handle 500 Internal Server Error or Any Unknown Error
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("❌ Something went wrong. Please try again later.");
	        }
			
		}
}
