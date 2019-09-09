package fruitstore.utility.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Encrypt {
	
	public static String SHA1(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			byte[] result = md.digest(input.getBytes());
			StringBuffer sb = new StringBuffer();
			
			for(int i=0; i < result.length; i++)
				sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
			
			return sb.toString();
		} catch(NoSuchAlgorithmException nsae) {
			throw new RuntimeException(nsae);
		}
	}

}
