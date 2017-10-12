import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Test Class containing the main method and information on the flight,
 * passenger, and booking reservations
 * 
 * @author Nicholas Sycz 
 * 		   COSC 210 Section 002
 * 		   2017/10/03
 */
public class Test {

	/**
	 * Main Method of the program. It takes information on the passenger, flight,
	 * booking, and reservations. It adds reservations to the format displayed in
	 * the printItinerary method, printBoardingPasses method, and uses the
	 * Calculations method to calculate flight details.
	 * 
	 * @param args
	 *            arguments for the main method to carry throughout the program
	 */
	public static void main(String[] args) {

		// Information for the First Passenger
		Passenger passenger = new Passenger("Bill Jones", "BJ103");

		Flight flight25 = new Flight(LocalTime.of(06, 50), LocalTime.of(07, 15), "Latrobe", "Pittsburgh", 59, 25);
		Flight flight54 = new Flight(LocalTime.of(8, 00), LocalTime.of(9, 00), "Pittsburgh", "Charlotte", 438, 54);
		Flight flight96 = new Flight(LocalTime.of(9, 40), LocalTime.of(10, 55), "Charlotte", "Orlando", 513, 96);

		Booking booking = new Booking(passenger);

		booking.addReservations(new Reservation(LocalDate.of(2017, 9, 27), flight25, "1A"));
		booking.addReservations(new Reservation(LocalDate.of(2017, 9, 27), flight54, "5F"));
		booking.addReservations(new Reservation(LocalDate.of(2017, 9, 27), flight96, "10C"));

		booking.calculations();
		booking.printItinerary();
		booking.printBoardingPasses();

		// Information for Second Passenger
		Passenger passenger2 = new Passenger("Rick Sanchez", "RS130");

		Flight flight0009 = new Flight(LocalTime.of(06, 50), LocalTime.of(12, 15), "Pittsburgh", "Washington D.C.", 246,
				9);
		Flight flight0054 = new Flight(LocalTime.of(18, 00), LocalTime.of(23, 45), "Washington D.C.", "Los Angeles",
				2668, 54);

		Booking booking2 = new Booking(passenger2);

		booking2.addReservations(new Reservation(LocalDate.of(2017, 10, 17), flight0009, "40A"));
		booking2.addReservations(new Reservation(LocalDate.of(2017, 10, 17), flight0054, "12A"));

		booking2.calculations();
		booking2.printItinerary();
		booking2.printBoardingPasses();

		// Information for Third Passenger
		Passenger passenger3 = new Passenger("Samantha Barns", "SB004");

		Flight flight0737 = new Flight(LocalTime.of(12, 50), LocalTime.of(14, 15), "Boston", "New York", 216, 737);
		Flight flight0033 = new Flight(LocalTime.of(14, 30), LocalTime.of(18, 23), "New York", "Montgomery", 1034, 33);
		Flight flight0002 = new Flight(LocalTime.of(20, 00), LocalTime.of(23, 42), "Montgomery", "Key West", 845, 2);

		Booking booking3 = new Booking(passenger3);

		booking3.addReservations(new Reservation(LocalDate.of(2017, 12, 13), flight0737, "21B"));
		booking3.addReservations(new Reservation(LocalDate.of(2017, 12, 13), flight0033, "07C"));
		booking3.addReservations(new Reservation(LocalDate.of(2017, 12, 13), flight0002, "05A"));

		booking3.calculations();
		booking3.printItinerary();
		booking3.printBoardingPasses();

	}
}
