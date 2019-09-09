package fruitstore.utility.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypt {
	
	public static String MD5(String input) {
		try {
			//MessageDigest class provides the application the functionality of an MD algorithm (SHA-1, SHA-256)
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			//Performs "digest" on the input using specified array of bytes
			byte[] messageDigest = md.digest(input.getBytes());
			
			//"number" variable gets the array of bytes (messageDigest) by converting to BigNumber type
			BigInteger number = new BigInteger(1, messageDigest);
			
			//"hashtext" variable gets the String-converted value of the variable "number"
			String hashtext = number.toString(16);
			
			while(hashtext.length() < 32)
				hashtext = "0" + hashtext;
			return hashtext;
		} catch(NoSuchAlgorithmException nsae) {
			throw new RuntimeException(nsae);
		}
	}
}
