import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZipCode {

	private String zipCode;
	private Location[] place;
	
	public ZipCode(String code)
	{
		place = new Location[25];
		zipCode = code;
	}
	
	public String getZipCode(File ZipCodes) throws FileNotFoundException
	{
		Scanner zipReader = new Scanner(System.in);
		File file = new File(zipReader.nextLine());
		zipReader = new Scanner(ZipCodes);
		while (zipReader.hasNext()){
			zipCode = zipReader.next();
		}
		zipReader.close();
		return zipCode;
	}
	
	public String getLocation()
	{
		
	}
	
	public String convertToBarcode()
	{
		
	}
	
	public String toString()
	{
		
	}

/*	public String getZipCode() {
		return zipCode;
	}
*/
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Location[] getPlace() {
		return Place;
	}

	public void setPlace(Location[] place) {
		Place = place;
	}


}
