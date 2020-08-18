package com.org.user.util;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Component;

public class EncryptText {
    
	// complex but better - could not decode the encrypted text
	
	/*
	 * private static final Random RANDOM = new SecureRandom(); private static final
	 * String ALPHABET =
	 * "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; private
	 * static final int ITERATIONS = 10000; private static final int KEY_LENGTH =
	 * 256;
	 * 
	 * public static String getSalt(int length) { StringBuilder returnValue = new
	 * StringBuilder(length); for (int i = 0; i < length; i++) {
	 * returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()))); }
	 * return new String(returnValue); } public static byte[] hash(char[] password,
	 * byte[] salt) { PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS,
	 * KEY_LENGTH); Arrays.fill(password, Character.MIN_VALUE); try {
	 * SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	 * return skf.generateSecret(spec).getEncoded(); } catch
	 * (NoSuchAlgorithmException | InvalidKeySpecException e) { throw new
	 * AssertionError("Error while hashing a password: " + e.getMessage(), e); }
	 * finally { spec.clearPassword(); } } public static String
	 * generateSecurePassword(String password, String salt) { String returnValue =
	 * null; byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
	 * 
	 * returnValue = Base64.getEncoder().encodeToString(securePassword);
	 * 
	 * return returnValue; }
	 * 
	 * 
	 * public static String generateDecryptPassword(String secureEncryptedPassword)
	 * { byte[] decoded=Base64.getDecoder().decode(secureEncryptedPassword); return
	 * decoded.toString();
	 * 
	 * }
	 * 
	 * public static boolean verifyUserPassword(String providedPassword, String
	 * securedPassword, String salt) { boolean returnValue = false;
	 * 
	 * // Generate New secure password with the same salt String newSecurePassword =
	 * generateSecurePassword(providedPassword, salt);
	 * 
	 * // Check if two passwords are equal returnValue =
	 * newSecurePassword.equalsIgnoreCase(securedPassword);
	 * 
	 * return returnValue; }
	 */

	private static Random rand = new Random((new Date()).getTime());

	public static String encrypt(String str) {
		byte[] salt = new byte[8];
		rand.nextBytes(salt);
		
		return Base64.getEncoder().encodeToString(salt) + Base64.getEncoder().encodeToString(str.getBytes());

	}

	public static String decrypt(String encstr) {
		if (encstr.length() > 12) {
			String cipher = encstr.substring(12);
			return new String(Base64.getDecoder().decode(cipher));

		}

		return null;
	}
}
