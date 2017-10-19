/** A program which processes postal zip codes from text files
 *  
 *<ul><li>
 * 		Converts 5 digit zip codes to barcodes 
 *</li><li>
 * 		Finds the matching city(ies) for given zip codes
 *</li><li>
 *		Converts from a series of barcodes to 5 digit zip codes and checks for accuracy with a checksum digit
 *</li></ul>
 * @author Matt Buffo
 * @version 2.0
 */
import java.io.File;
import java.util.Scanner;

public class Client {
	private File ZipCodes = new File("ZipCodes.txt");
	private File ZipCodesCity = new File("ZipCodesCity.txt");
	private File ZipBarCodes = new File("ZipBarCodes.txt");
	public static void main(String[] args) {
		Barcode test = new Barcode("||:|:::||::||:::::||:|:|::::||:|");
	}
}
