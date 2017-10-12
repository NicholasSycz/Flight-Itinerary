import java.time.LocalDate;

/**
 * Reservation Class containing the constructor and getters / setters for the
 * date of flight, the flight class, and the seat number
 * 
 * @author Nicholas Sycz
 * 		   COSC 210 Section 002 
 *		   2017/10/03
 */
public class Reservation {

	private LocalDate dateOfFlight;
	private Flight flight;
	private String seat;

	/**
	 * Reservation Constructor which declares the flight date, flight class, and
	 * seat number
	 * 
	 * @param dateOfFlight
	 *            the date of a flight's departure
	 * @param flight
	 *            access to the information in the flight class
	 * @param seat
	 *            the seat number of the passenger
	 */
	public Reservation(LocalDate dateOfFlight, Flight flight, String seat) {
		super();
		this.dateOfFlight = dateOfFlight;
		this.flight = flight;
		this.seat = seat;
	}

	/**
	 * Getter Method for acquiring the information in the flight class
	 * 
	 * @return flight class information
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * Setter Method for setting details in flight constructor's parameters
	 * 
	 * @param flight
	 *            declares flight
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	/**
	 * Getter Method for acquiring seating information
	 * 
	 * @return the seat number of the passenger
	 */
	public String getSeat() {
		return seat;
	}

	/**
	 * Setter Method for setting seating information
	 * 
	 * @param seat
	 *            declares the seat number
	 */
	public void setSeat(String seat) {
		this.seat = seat;
	}

	/**
	 * Getter Method for acquiring the date of the flights
	 * 
	 * @return the date of the flights
	 */
	public LocalDate getDateOfFlight() {
		return dateOfFlight;
	}

	/**
	 * Setter Method for setting the date for flights
	 * 
	 * @param dateOfFlight
	 *            declares the flight date
	 */
	public void setDateOfFlight(LocalDate dateOfFlight) {
		this.dateOfFlight = dateOfFlight;
	}

}
