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
	}
	private void checkSum() {
		
	}
	private void convertToSegments(){
		for(int i = 0; i < barCode.length(); i ++) {
			barCodeAsSegments[i/5] =  0; //FIX THIS;
		}
	}
}
