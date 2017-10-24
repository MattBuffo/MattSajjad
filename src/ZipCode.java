import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZipCode {

	private String zipCode;
	private Location[] place;
	private String barcode;
	private File ZipCodesCity;

	public ZipCode(String code)
	{
		place = new Location[25];
		zipCode = code;
		ZipCodesCity = new File("ZipCodesCity.txt");
	}

	/**public String getZipCode(File ZipCodes) throws FileNotFoundException
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
**/ //redundant method
	
	private void setLocation()
	{
		Scanner cityReader = new Scanner(System.in);
		File file = new File(cityReader.nextLine());
		cityReader = new Scanner(ZipCodesCity);
		for (int i = 0; i < place.length; i++ )
		while (cityReader.hasNext()) {
			String location = cityReader.next();
			if (location.substring(0, 6).equals(zipCode)) {
				place[i] = new Location(location);
			}
		}
	}

	public String convertToBarcode(int n)
	{
		switch (n) {
		case 0: return ":::||";
		case 1: return "::|:|";
		case 2: return "::|:|";
		case 3: return "::||:";
		case 4: return ":|::|";
		case 5: return ":|:|:";
		case 6: return ":||::";
		case 7: return "|:::|";
		case 8: return "|::|:";
		case 9: return "|:|::";
		default: return "Invalid Input";

		}
	}

	public String getBarcode()

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

	public String toString()
	{
		if(!checkSum) {
			return ("|" + barCode + "|" + "------>" + "ERROR: INVALID CHECKSUM");
		}
		else {
			String returnStr = "";
			returnStr += ("ZipCode: " + this.getZipCode(File ZipCodes) + "\n");
			returnStr += ("Postal BarCode: " + "|" + this.getBarCode() + "|" + "\n");
			returnStr += ("Readable Barcode: | ");
			String[] tempBar = this.getBarCodeAsSegments();
			for(String segment: tempBar) {
				returnStr += segment + " ";
			}
			returnStr += "| \n";
			return returnStr;
		}
	}
}


}
