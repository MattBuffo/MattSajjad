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
	public Barcode(String barCode){
		
	}
	public void checkSum() {
		
	}
}
