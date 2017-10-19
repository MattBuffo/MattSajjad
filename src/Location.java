
public class Location {

	private String city;
	private String state;
	
	public Location()
	{
		
	}
	
	public Location(String city)
	{
		
	}
	
	public Location(String state)
	{
		
	}
	
	public Location(String location)
	{
		
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
		return (city + ", " + state);
	}
	
}
