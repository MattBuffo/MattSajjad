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
	 */
	public Barcode() {
		barCode = "";
		barCodeAsSegments = null;
		checkSum = true;
		zipCodeWithCheck = "";
		zipCode = new ZipCode();
	}
	/**Constructs a Barcode object with the instance element barCode set to the passed string with the first and last characters removed
	 * 
	 * @param code barcode string from ZipBarCodes.txt
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
		System.out.println(zipCodeWithCheck);
		checkSum();
		System.out.println(checkSum);
		
	}
	// Getter Methods
	/** Returns instance array of barcode segments
	 * 
	 * @return barCodeAsSegments
	 */
	public String[] getBarCodeAsSegments() {
		return barCodeAsSegments;
	}
	// Helper Methods
	/**
	 * Checks the validity of the instance zipcode with checksum digit and returns the result
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
	 */
	private void convertToSegments(){
		
		for(int i = 0; i < barCode.length(); i ++) {
			barCodeAsSegments[i/5] += barCode.charAt(i);
			
		}
	}
	/**
	 * Converts the instance array of barcode segments to a six digit numeric zipcode with a checksum digit
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
}
