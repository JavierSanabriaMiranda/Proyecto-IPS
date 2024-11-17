package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradorDePassword {

	public static String cifrarPassword(char[] password) {
		// Convertir char[] a byte[]
        byte[] passwordBytes;
		try {
			passwordBytes = new String(password).getBytes("UTF-8");
			// Algoritmo de hash SHA-256
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hashedPassword = digest.digest(passwordBytes);
	        StringBuilder hexString = new StringBuilder();
	        for (byte b : hashedPassword) {
	            String hex = Integer.toHexString(0xff & b);
	            if (hex.length() == 1) hexString.append('0'); // Asegura que siempre haya dos dígitos
	            hexString.append(hex);
	        }
	        return hexString.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        return null;
	}
}
