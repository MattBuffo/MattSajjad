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
		barCode = null;
		barCodeAsSegments = null;
		checkSum = true;
		zipCodeWithCheck = null;
		zipCode = null;
	}
	/**Constructs a Barcode object with the instance element barCode set to the passed string with the first and last characters removed
	 * 
	 * @param code barcode string from ZipBarCodes.txt
	 */
	public Barcode(String code){
		barCode = code.substring(1, code.length() -1);
		barCodeAsSegments = new String[barCode.length()/5];
		convertToSegments();
		convertToZip();
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
	private void checkSum() {
		
	}
	/**
	 * Converts a the string instance variable barcode to an instance array of five bar segments
	 */
	private void convertToSegments(){
		for(int i = 0; i < barCodeAsSegments.length; i++) { //clears array for conversion, otherwise null values are stored from array constructor
			barCodeAsSegments[i] = "";
		}
		for(int i = 0; i < barCode.length(); i ++) {
			barCodeAsSegments[i/5] += barCode.charAt(i);
			
		}
	}
	private void convertToZip() {
		String[] tempArray = barCodeAsSegments;
		String tempCode = "";
		for(String segment : tempArray) {
			System.out.println(segment);
			for(int i = 0; i < segment.length(); i ++) {
				if(segment.charAt(i) == '|') {
					segment = segment.substring(0, i) + "1" + segment.substring(i+1);
				}
				else {
					segment = segment.substring(0, i) + "0" + segment.substring(i+1);
				}
			}
		
			
			if((Integer.parseInt(segment.substring(0,1)) * 7) + (Integer.parseInt(segment.substring(1,2)) * 4) > 0) {} // FIX THIS 
		}
	}
}
