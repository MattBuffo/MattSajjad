/**
 * @author Sajjad Shuaybi
 * this class performs the zipcode class functions
 * as per the project description
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZipCode {
	//instance data
	private String zipCode;
	private Location[] place;
	private String barcode;
	private String readableBarcode;
	private File ZipCodesCity;
	private int checkSum;
	/**
	 * constructor method
	 * @preconditions none
	 * @postconditions none
	 * @param code - zipcode object
	 */
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
	 **/ //redundant method, barcode class is already doing this-miscommunication

	/**
	 * setter method that adds to the locations from the zipcodes
	 * no return value, just modifies the place instance array
	 */
	private void setLocation() 
	{

		try {
			Scanner cityReader = new Scanner(ZipCodesCity); //read in the file of locations

			//creation of the array of locations
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
		} catch (FileNotFoundException e) { //fixes the scanner leak error
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param n, n is each digit of the zipcode
	 * @return the matching barcode segment - to be built later
	 */
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
		default: return "Invalid Input"; //in case number passed in is not between 0-9

		}
	}
	/**
	 * modifies the checksum instance data
	 * to be used for barcode construction
	 * @preconditions zipcode must be declared and initialized
	 */

	private void getCheckSum() {
		int sum = 0;	//add up all digits of zipcode
		for(int i = 0; i<zipCode.length(); i++) {
			sum += zipCode.charAt(i);
		}
		if (sum%10 != 0) {		//checksum cannot be 10
			checkSum = 10 - sum%10;
		}
		else {
			checkSum = 0;
		}
	}

	/**
	 * constructs the barcode using the segments and checksum
	 * @preconditons zipcode must be declared and initialized
	 * @postconditions no return value, modifies barcode instance data
	 */

	public void setBarcode() {
		for(int i = 0; i<zipCode.length(); i++) {
			barcode += convertToBarcode(Integer.parseInt(zipCode.substring(i,i+1)));
		}
		barcode += convertToBarcode(checkSum);
	}

	/**
	 * getter method for barcode object
	 * @preconditions barcode object must be instantiated
	 * @returns initalized barcode
	 */

	public String getBarcode() {
		return barcode;
	}

	/**
	 * @preconditions barcode object must be instantiated and initialized
	 * setter method that creates a readable barcode
	 * @postconditions no return method, modifies readablebarcode instance data
	 * 
	 */
	private void setReadableBarcode() {
		readableBarcode = "";
		for(int i = 0; i<barcode.length(); i+=5) {

			readableBarcode += barcode.substring(i, i+5) + " "; //adds space after each segment
		}
	}
	/**
	 * setter method sets zipcode to external zipcode string
	 * @param zipCode
	 */

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * getter method 
	 * @return array of places
	 */

	public Location[] getPlace() {
		return place;
	}
	/**
	 * setter method sets place to external place array
	 * @param place
	 */

	public void setPlace(Location[] place) {
		this.place = place;
	}
	/**
	 * tostring method
	 * prints all the project requirements with correct formatting
	 * @preconditions all the above methods must have fulfilled their intended roles
	 * @postconditions none
	 */

	public String toString()
	{
//build one big string with all the required output
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
