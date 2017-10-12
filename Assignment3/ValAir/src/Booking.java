import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Booking class containing the calculations, out-print statements, and pulls
 * from the other classes
 * 
 * @author Nicholas Sycz
 * 		   COSC 210 Section 002
 * 		   2017/10/03
 */
public class Booking {

	private Passenger passenger;
	private Reservation[] reservations = new Reservation[10];
	private int numReservations = 0;
	private int airTime;
	private int travelTime;
	private int layover;
	private int miles;

	/**
	 * Booking constructor pulling information from the passenger class
	 * 
	 * @param passenger
	 *            information about the passenger including the name of the flyer
	 *            and the flyer number
	 */
	public Booking(Passenger passenger) {
		super();
		this.passenger = passenger;
	}

	/**
	 * Method for adding reservations to the array
	 * 
	 * @param reservation
	 *            used to call the method
	 * 
	 */
	public void addReservations(Reservation reservation) {
		reservations[numReservations++] = reservation;
	}

	/**
	 * Getter Method for number of reservations
	 * 
	 * @return returns the number of reservations
	 */
	public int getNumReservations() {
		return numReservations;
	}

	/**
	 * Getter Method for the reservations array
	 * 
	 * @param i
	 *            used to display the contents as integers
	 *            
	 * @return returns the place of the reservation in the array
	 */
	public Reservation getReservation(int i) {
		return reservations[i];
	}

	/**
	 * Calculations Method for calculating the lay over time, total miles, and total
	 * travel time
	 */
	public void calculations() {
		LocalTime t1;
		LocalTime t2;

		// for-loop to pull flight times throughout the array
		for (int i = 0; i < numReservations; i++) {
			t1 = getReservation(i).getFlight().getTimeOfDepart();
			t2 = getReservation(i).getFlight().getTimeOfArrive();
			airTime += Math.abs(ChronoUnit.MINUTES.between(t1, t2));

			if (getReservation(i + 1) != null) {
				t1 = getReservation(i).getFlight().getTimeOfArrive();
				t2 = getReservation(i + 1).getFlight().getTimeOfDepart();
				layover += Math.abs(ChronoUnit.MINUTES.between(t2, t1));
			}

			// Calculates miles earned (each trip earns at least 500 miles)
			miles += Math.max(500, getReservation(i).getFlight().getMiles());

		}

		// calculates total travel time
		travelTime = airTime + layover;
	}

	// Methods helping with the calculations method
	private int getHours(int timeHours) {
		return timeHours / 60;
	}

	private int getMinutes(int timeMinutes) {
		return timeMinutes % 60;
	}

	// Time formatting to convert the time into Western time.
	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
	// Date formatting to convert the date into the month, day, year format.
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	/**
	 * printItineraryMethod prints the layout of the Itinerary. It contains the
	 * passenger, destination, stops, total travel time, lay-over time, miles
	 * earned, and the flight information.
	 */
	public void printItinerary() {

		System.out.printf("                           V a l   A i r%n");
		System.out.println();
		System.out.printf("                             Itinerary%n");
		System.out.println();
		System.out.printf("Passenger:            %-20s%n", passenger.getName());
		System.out.printf("Flyer No:             %-20s%n", passenger.getFlyerNum());
		System.out.println();
		System.out.printf("From:                 %-20s%n", reservations[0].getFlight().getCityOfDepart());
		System.out.printf("To:                   %-20s%n",
				reservations[numReservations - 1].getFlight().getCityOfArrive());
		System.out.printf("Stops:                %-20s%n", numReservations - 1);
		System.out.printf("Total Travel Time:    %s Hours %s Minutes%n", getHours(travelTime), getMinutes(travelTime));
		System.out.printf("Layover Time:         %s Hours %s Minutes%n", getHours(layover), getMinutes(layover));
		System.out.printf("Miles Earned:         %-20s%n", miles);
		System.out.println();
		System.out.printf("                                       Flights%n");
		System.out.println();
		System.out.printf("   Date       Flight   Depart                     Arrive                    Miles %n");

		// for-loop for printing out multiple reservations
		for (int i = 0; i < numReservations; i++) {
			Reservation reservations = getReservation(i);

			Flight flight = reservations.getFlight();

			System.out.printf("%s     %04d    %-15s %s   %-15s %s   %4d%n",
					reservations.getDateOfFlight().format(dateFormatter), flight.getFlightNum(),
					flight.getCityOfDepart(), flight.getTimeOfDepart().format(timeFormatter), flight.getCityOfArrive(),
					flight.getTimeOfArrive().format(timeFormatter), flight.getMiles());

		}
		System.out.println();
	}

	/**
	 * printBoardingPass Method containing the layout for the boarding pass. It
	 * displays the flight details of the passenger with boarding and departure
	 * times.
	 */
	public void printBoardingPasses() {

		for (int i = 0; i < numReservations; i++) {
			Reservation reservation = getReservation(i);
			Flight flight = reservation.getFlight();
			LocalTime boarding = flight.getTimeOfDepart().minusMinutes(30);
			System.out.println();
			System.out.printf("ValAir Boarding Pass%n");
			System.out.printf("Flight details%n");
			System.out.println();
			System.out.printf("Passenger            Seat      Boarding     Depart%n");
			System.out.printf("%-15s      %-3s       %-5s      %-5s", passenger.getName(), reservation.getSeat(),
					boarding.format(timeFormatter), flight.getTimeOfDepart().format(timeFormatter));
			System.out.println();
		}

		System.out.println();
		System.out.println();
	}
}