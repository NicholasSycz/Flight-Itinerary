import java.time.LocalTime;
/**
 * Flight Class containing information on the flight's times, cities, and miles.
 * 
 * @author Nicholas Sycz
 * 		   COSC 210 Section 002 
 *		   2017/10/03
 */
public class Flight {

	LocalTime timeOfDepart;
	LocalTime timeOfArrive;
	private String cityOfDepart;
	private String cityOfArrive;
	private int miles;
	private int flightNum;

	/**
	 * Flight Constructor for declaring the times for departing / arriving, cities
	 * of departing / arriving, miles per flight, and the flight numbers
	 * 
	 * @param timeOfDepart
	 *            the time the plane will leave the terminal
	 * @param timeOfArrive
	 *            the time the plane will arrive at the destination
	 * @param cityOfDepart
	 *            the city where the plane will take off
	 * @param cityOfArrive
	 *            the city where the plane will arrive
	 * @param miles
	 *            the mileage per flight
	 * @param flightNum
	 *            the number of the flight
	 */
	public Flight(LocalTime timeOfDepart, LocalTime timeOfArrive, String cityOfDepart, String cityOfArrive, int miles,
			int flightNum) {
		this.timeOfDepart = timeOfDepart;
		this.timeOfArrive = timeOfArrive;
		this.cityOfDepart = cityOfDepart;
		this.cityOfArrive = cityOfArrive;
		this.miles = miles;
		this.flightNum = flightNum;
	}

	/**
	 * Getter Method for acquiring the departure time
	 * 
	 * @return returns the departure time
	 */
	public LocalTime getTimeOfDepart() {
		return timeOfDepart;
	}

	/**
	 * Getter Method for acquiring the arrival time
	 * 
	 * @return the arrival time
	 */
	public LocalTime getTimeOfArrive() {
		return timeOfArrive;
	}

	/**
	 * Getter Method for acquiring the city where the plane will depart
	 * 
	 * @return the city where the plane will depart
	 */
	public String getCityOfDepart() {
		return cityOfDepart;
	}

	/**
	 * Getter Method for acquiring the city where the plane will arrive
	 * 
	 * @return the city where the plane will arrive
	 */
	public String getCityOfArrive() {
		return cityOfArrive;
	}

	/**
	 * Getter Method for acquiring the miles for each flight
	 * 
	 * @return the miles for each flight
	 */
	public int getMiles() {
		return miles;
	}

	/**
	 * Getter Method for acquiring the flight number of each flight
	 * 
	 * @return the flight number
	 */
	public int getFlightNum() {
		return flightNum;
	}

}
