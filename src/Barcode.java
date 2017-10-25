/**
 * 
 * @author Matt Buffo
 * @version 1.0
 * 
 *
 */
public class Barcode {
	private String barCode;
	private String[] barCodeAsSegments;
	private ZipCode zipCode;
	private String zipCodeWithCheck;
	private boolean checkSum;
	/**
	 * NoArgs constructor, sets checksum to default true, initializes all other variables to null
	 * @preconditions none
	 * @postconditions none
	 */
	public Barcode() {
		barCode = "";
		barCodeAsSegments = null;
		checkSum = true;
		zipCodeWithCheck = "";
		zipCode = new ZipCode(null);
	}
	//Constructors 
	/** Constructs a barcode object from a ZipCode class 
	 * 
	 * @param code ZipCode object
	 * @preconditions ZipCode object has to be constructed
	 * @postconditions Barcode object constructed and all instance data declared
	 */
	public Barcode(ZipCode code) {
		
	}
	/**Constructs a Barcode object with the instance element barCode set to the passed string with the first and last characters removed
	 * 
	 * @param code barcode string from ZipBarCodes.txt
	 * @preconditions code must be obtained from file
	 * @postconditions object is constructed and all instance data declared 
	 */
	public Barcode(String code){
		barCode = code.substring(1, code.length() -1);
		barCodeAsSegments = new String[barCode.length()/5];
		for(int i = 0; i < barCodeAsSegments.length; i++) { //clears array for conversion, otherwise null values are stored from array constructor
			barCodeAsSegments[i] = "";
		}
		zipCodeWithCheck = "";
		convertToSegments();
		convertToZip();
		checkSum();
		if(checkSum) {
			zipCode = new ZipCode(zipCodeWithCheck.substring(0, zipCodeWithCheck.length() -1));
		}

	}
	// Getter Methods (Accessor) 
	/** Gets the zipCode Object
	 * 
	 * @return zipCode
	 * @preconditions zipCode object must be passed or convertToZip called
	 * @postconditions none
	 */
	public ZipCode getZipCodeClass() {
		return zipCode;
	}
	/** Returns true if valid zipcode and false if invalid 
	 * 
	 * @return checkSum
	 * @preconditions checkSum method must be run
	 * @postconditions none
	 */
	public boolean getCheckSum() {
		return checkSum;
	}
	/** Gets the barcode as a string 
	 * 
	 * @return barCode
	 * @preconditions barcode must be obtained from passed string or passed zipcode object
	 * @postconditions none
	 */
	public String getBarCode() {
		return barCode;
	}
	/** Gets the numeric zipcode represented by the barcode
	 * 
	 * @return numeric zip code derived from zipCodeWithCheck
	 * @preconditions barcode converted to zipCodeWithCheck or zipCodeWithCheck obtained from passed object
	 * @postconditions none
	 */
	public String getZipCode() {
		return zipCodeWithCheck.substring(0, zipCodeWithCheck.length() -1);
	}
	/**Gets zipCodeWithCheck instance variable
	 * 
	 * @return zipCodeWithCheck
	 * @preconditions barcode converted to zipCodeWithCheck or zipCodeWithCheck obtained from passed object
	 * @postconditions none
	 */
	public String getZipCodeWithCheck() {
		return zipCodeWithCheck;
	}
	/** Returns instance array of barcode segments
	 * 
	 * @return barCodeAsSegments
	 * @preconditions barcode must be converted to segments
	 * @postconditions none
	 */
	public String[] getBarCodeAsSegments() {
		return barCodeAsSegments;
	}
	// Helper Methods
	/**
	 * Checks the validity of the instance zipcode with checksum digit and returns the result
	 * @preconditions barcode must be converted to zipCodeWithCheck or obtained from passed zipCode object
	 * @postconditions checkSum is initalized to true if barcode is valid, false if barcode is not
	 */
	private void checkSum() {
		int sum = 0;
		for(int i = 0; i < zipCodeWithCheck.length(); i ++) {
			sum += Integer.parseInt(zipCodeWithCheck.substring(i, i+1));
		}
		if (sum % 10 == 0) {
			checkSum = true;
		}
		else {
			checkSum = false;
		}
	}
	/**
	 * Converts a the string instance variable barcode to an instance array of five bar segments
	 * @preconditions <ul><li>ipcode must be converted to barcode, if applicable<li>
	 * 					  <li>barcode must be declared and initalized</li></ul>
	 * @postconditions barcodeAsSegments is initalized to an array of five bar segments
	 */
	private void convertToSegments(){

		for(int i = 0; i < barCode.length(); i ++) {
			barCodeAsSegments[i/5] += barCode.charAt(i);

		}
	}
	/**
	 * Converts the instance array of barcode segments to a six digit numeric zipcode with a checksum digit
	 *@preconditions barcode must be converted to segments
	 *@postconditions zipCodeWithCheck is initialized to match the barcode with a checksum digit
	 */
	private void convertToZip() {

		String[] tempArray = barCodeAsSegments;
		String tempCode = "";
		for(String segment : tempArray) {
			for(int i = 0; i < segment.length(); i ++) {
				if(segment.charAt(i) == '|') {
					segment = segment.substring(0, i) + "1" + segment.substring(i+1);
				}
				else {
					segment = segment.substring(0, i) + "0" + segment.substring(i+1);
				}
			}

			if((Integer.parseInt(segment.substring(0,1)) * 7) 
					+ (Integer.parseInt(segment.substring(1,2)) * 4) 
					+ (Integer.parseInt(segment.substring(2,3)) * 2)
					+ (Integer.parseInt(segment.substring(3,4))) == 11) {
				zipCodeWithCheck += 0;
			}
			else {
				zipCodeWithCheck += ((Integer.parseInt(segment.substring(0,1)) * 7) 
						+ (Integer.parseInt(segment.substring(1,2)) * 4) 
						+ (Integer.parseInt(segment.substring(2,3)) * 2)
						+ Integer.parseInt(segment.substring(3,4)));
			}


		}
	}
	/**
	 * Constructs and returns a complex string representing the Barcode in readable and postal formats, the associated zipcode, and any matching cities.
	 * @return  <ul><li>returnStr_Line1: "ZipCode: " and associated numeric zipcode</li>
	 * 			<li>returnStr_Line2: "Postal Barcode:" and barcode with no spacing</li>
	 * 			<li>returnStr_Line3: "Readable Barcode:" and barcode with spacing between formatting bars and each segment</li>
	 * 			<li>returnStr_Line4: "Matching Cities:"</li>
	 * 			<li>rerurnStr_Line5+: Matching Cities in City, State format</li></ul>
	 * @preconditions   <ul><li>conversion from barcode to segment</li>
	 * 					<li>constriction of a zipcode with method to get matching locations</li></ul>
	 * @postconditions none
	 */
	public String toString() {
		if(!checkSum) {
			return ("|" + barCode + "|" + "------>" + "ERROR: INVALID CHECKSUM");
		}
		else {
			String returnStr = "";
			returnStr += ("ZipCode: " + this.getZipCode() + "\n");
			returnStr += ("Postal BarCode: " + "|" + this.getBarCode() + "|" + "\n");
			returnStr += ("Readable Barcode: | ");
			String[] tempBar = this.getBarCodeAsSegments();
			for(String segment: tempBar) {
				returnStr += segment + " ";
			}
			returnStr += "| \n";
			returnStr += "Matching Cities: \n";

			/*Location[] tempLocations = zipCode.getPlace();
			for(Location place : tempLocations) {
				returnStr += place.toString() + "\n";
			}*/
			return returnStr;
		}
	}
}
