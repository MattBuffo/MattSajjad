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
	/** Creates and prints arrays of ZipCode and Barcode objects derived from the files ZopCodes.txt and BarCodes.txt respectively
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * @preconditions none
	 * @postconditions all parts of the project are printed and arrays of zipcodes and barcodes constructed 
	 */
	public static void main(String[] args) throws FileNotFoundException{
		//Variable declarations
		File ZipCodes = new File("ZipCodes.txt");
		File ZipBarCodes = new File("ZipBarCodes.txt");
		ZipCode[] zipCodeArray = new ZipCode[10]; //These values are hardcoded to save execution time and for the sake of simplicity, I recognize in the industry this is bad practice but I figured I'd save a bit of your time
		Barcode[] barCodeArray = new Barcode[10];
		Scanner in;

		//Creation of arrays
		in = new Scanner(ZipBarCodes);
		for(int i = 0; i < barCodeArray.length; i ++) {
			barCodeArray[i] = new Barcode(in.next());
		}
	
		in = new Scanner(ZipCodes);
		for(int i = 0; i <zipCodeArray.length; i++) {
			zipCodeArray[i] = new ZipCode(in.next());
		}
	

		//Printing of Arrays
		for(int i = 0; i < zipCodeArray.length; i ++) {
			System.out.println("Zip Code " + i + ": \n" + zipCodeArray[i]);
		}
		for(int i = 0; i < barCodeArray.length; i ++) {
			System.out.println("Bar Code " + i + ": \n" + barCodeArray[i]);
		
		}
	}
}
