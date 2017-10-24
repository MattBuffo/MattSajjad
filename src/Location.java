
public class Location {

	private String city;
	private String state;
	
	public Location()
	{
		city = "";
		state = "";
	}
	public Location(String location)
	{
		city = location.substring(7, location.length() -3);
		state = location.substring(location.length()-2);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String toString()
	{
		return (city + ", " + state + "\n");
	}
	
}
