/**
 * 
 * @author Sajjad Shuaybi
 * 
 * creates location object to be used in zipcode class
 *
 */
public class Location {
//instance data
	private String city;
	private String state;
	
	/**
	 * constructor - noArgs
	 * @preconditions none
	 * @postconditions none
	 * 
	 */
	public Location()
	{
		city = "";
		state = "";
	}
	
	/**
	 * constructor for initializing city and state data
	 * sets city and state instances to equivalent portions of the location that is read in
	 * @param location
	 */
	public Location(String location)
	{
		city = location.substring(6, location.length() -3);
		state = location.substring(location.length()-2);
	}
	
	/**
	 * getter/accessor method
	 * @preconditions state instance data must be declared and initialized
	 * @postconditions none
	 * @return state of the location
	 */

	public String getState() {
		return state;
	}
	
	/**
	 * setter/mutator method
	 * complementary function to the above getState method
	 * @preconditions state instance data must be declared and initialized
	 * @postconditions none
	 * @param state
	 */

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * getter/accessor method
	 * @preconditions city instance data must be declared and initialized
	 * @postconditions none
	 * @return city of the location
	 */

	public String getCity() {
		return city;
	}
	
	/**
	 * setter/mutator method
	 * complementary function to the above getCity method
	 * @preconditions city instance data must be declared and initialized
	 * @postconditions none
	 * @param city
	 */

	public void setCity(String city) {
		this.city = city;
	}
	
	/** 
	 * toString method
	 * prints the output of this class with proper formatting/spacing
	 * @preconditions all the above methods must have completed their intended roles
	 * @postconditions none
	 */
	public String toString()
	{
		return (city + ", " + state + "\n");
	}
	
}
