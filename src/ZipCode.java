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
	
	public String getLocation(File ZipCodesCity)
	{
		Scanner cityReader = new Scanner(System.in);
		File file = new File(cityReader.nextLine());
		cityReader = new Scanner(ZipCodesCity);
		while (cityReader.hasNext()) {
			place = cityReader.next();
		}
	}
	
	public String convertToBarcode()
	{
		String barcodeDigit;
		switch (barcodeCreator) {
			case 0: barcodeDigit = ":::||";
			case 1: barcodeDigit = "::|:|";
			case 2: barcodeDigit = "";
			case 3: barcodeDigit = "";
			case 4: barcodeDigit = "";
			case 5: barcodeDigit = "";
			case 6: barcodeDigit = "";
			case 7: barcodeDigit = "";
			case 8: barcodeDigit = "";
			case 9: barcodeDigit = "";
			default: barcodeDigit = "Invalid Input";
		
		}
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
