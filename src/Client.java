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
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws FileNotFoundException{
		File ZipCodes = new File("ZipCodes.txt");
		File ZipCodesCity = new File("ZipCodesCity.txt");
		File ZipBarCodes = new File("ZipBarCodes.txt");
		ZipCode[] zipCodeArray = new ZipCode[10];
		Barcode[] barCodeArray = new Barcode[10];
		Scanner in = new Scanner(ZipBarCodes);
		for(Barcode bar : barCodeArray) {
			bar = new Barcode(in.next());
			System.out.println(bar);
		}
	}
}
