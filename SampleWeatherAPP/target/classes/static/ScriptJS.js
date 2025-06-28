function getWeather() {
    let city = document.getElementById("cityInput").value;
    if (!city) {
        alert("Please enter a city name");
        return;
    }

    fetch(`/api/weather/${city}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("weatherResult").innerHTML =
                `<p>Temperature: ${data.main.temp}°C</p>
                 <p>Weather: ${data.weather[0].description}</p>
				<p>Wind Speed : ${data.wind.speed}`;
        })
        .catch(error => console.error("Error fetching weather:", error));
}
