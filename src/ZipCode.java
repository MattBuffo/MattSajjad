/**
 * @author Sajjad Shuaybi
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZipCode {

	private String zipCode;
	private Location[] place;
	private String barcode;
	private String readableBarcode;
	private File ZipCodesCity;
	private int checkSum;

	public ZipCode(String code) 
	{
		
		place = new Location[25];
		zipCode = code;
		barcode = "";
		setBarcode();
		setReadableBarcode();
		ZipCodesCity = new File("ZipCodesCity.txt");
		setLocation();
		
		
		
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
		
		try {
			Scanner cityReader = new Scanner(ZipCodesCity);
		
		for (int i = 0; i < place.length; i++ ){
			boolean tempBool = false;
			while (cityReader.hasNextLine() && !(tempBool)) {
				String location = cityReader.nextLine();
				if(location.substring(0, 5).equals(zipCode)) {
					place[i] = new Location(location);
					tempBool = true;
				}
			}
		}
		cityReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	private void getCheckSum() {
		int sum = 0;
		for(int i = 0; i<zipCode.length(); i++) {
			sum += zipCode.charAt(i);
		}
		if (sum%10 != 0) {
			checkSum = 10 - sum%10;
		}
		else {
			checkSum = 0;
		}
	}

	public void setBarcode() {
		for(int i = 0; i<zipCode.length(); i++) {
			barcode += convertToBarcode(Integer.parseInt(zipCode.substring(i,i+1)));
		}
		barcode += convertToBarcode(checkSum);
	}
	public String getBarcode() {
		return barcode;
	}
	private void setReadableBarcode() {
		readableBarcode = "";
		for(int i = 0; i<barcode.length(); i+=5) {
			
			readableBarcode += barcode.substring(i , i+5) + " ";
		}
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Location[] getPlace() {
		return place;
	}

	public void setPlace(Location[] place) {
		this.place = place;
	}

	public String toString()
	{

		String returnStr = "";
		returnStr += ("ZipCode: " + zipCode + "\n");
		returnStr += ("Postal BarCode: " + "|" + barcode + "|" + "\n");
		returnStr += ("Readable Barcode: | " + readableBarcode + "|" + "\n");

		returnStr += "Matching Cities: \n";

		for(Location location : place) {
			if(location != null) {
				returnStr += location;
			}
		}
		return returnStr;

	}



}
