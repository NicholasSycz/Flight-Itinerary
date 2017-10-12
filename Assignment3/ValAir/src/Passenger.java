/**
 * Passenger class containing a passenger's most common personal information
 * 
 * @author Nicholas Sycz
 * 		   COSC 210 Section 002 
 *		   2017/10/03
 */
public class Passenger {

	private String name;
	private String flyerNum;

	/**
	 * Passenger Constructor with parameters for a passenger's name and flyer number
	 * 
	 * @param name
	 *            for the passenger's name
	 * @param flyerNum
	 *            for the passenger's flyer number
	 */
	public Passenger(String name, String flyerNum) {

		this.name = name;
		this.flyerNum = flyerNum;
	}

	/**
	 * Getter Method to allow classes to get a name
	 * 
	 * @return returns the name of passenger
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter Method to allow classes to get a flyer number
	 * 
	 * @return returns the flyer number of the passenger
	 */
	public String getFlyerNum() {
		return flyerNum;
	}
}
