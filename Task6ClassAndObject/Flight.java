package Task6ClassAndObject;

public class Flight {
	private String flightNumber;
    private String airline;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private double price;
    private int availableSeats;
    
    private static int totalFlights = 0;
    
	public Flight(String flightNumber, String airline, String source, String destination, String departureTime,
			String arrivalTime, double price, int availableSeats) {
		super();
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
		this.availableSeats = availableSeats;
	}
	
	
	

	public String getFlightNumber() {
		return flightNumber;
	}
	public String getAirline() {
		return airline;
	}
	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public double getPrice() {
		return price;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public static int getTotalFlights() {
        return totalFlights;
    }
	
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", airline=" + airline + ", source=" + source + ", destination="
				+ destination + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", price=" + price
				+ ", availableSeats=" + availableSeats + "]";
	}

}
