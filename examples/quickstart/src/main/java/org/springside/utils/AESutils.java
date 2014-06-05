package org.springside.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.cryptonode.jncryptor.AES256JNCryptor;
import org.cryptonode.jncryptor.CryptorException;
import org.cryptonode.jncryptor.InvalidHMACException;
import org.cryptonode.jncryptor.JNCryptor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springside.examples.quickstart.rest.EventRestController;

public class AESutils {
	
	private static Logger log = LoggerFactory.getLogger(AESutils.class);
	

	/**
	 * AES加密(算法:password+md5)
	 * @param ciphertext
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public static byte[] decryptData(byte[] ciphertext, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		log.debug("before[" + ciphertext + "]");
		StringBuffer sb = new StringBuffer();
//		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] array = md5.digest(password.getBytes("utf-8"));
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			JNCryptor cryptor = new AES256JNCryptor();
			try {
				return cryptor.decryptData(ciphertext, sb.toString().toCharArray());
			} catch (InvalidHMACException e) {
				return (e.getMessage() + "," + e.getStackTrace()[0].toString()).getBytes();
			} catch (CryptorException e) {
				return (e.getMessage() + "," + e.getStackTrace()[0].toString()).getBytes();
			}


	}

	public static byte[] decrypt(byte[] ciphertext, String password) {
		JNCryptor cryptor = new AES256JNCryptor();
		try {
			return cryptor.decryptData(ciphertext, password.toCharArray());
		} catch (InvalidHMACException e) {
			return (e.getMessage() + "," + e.getStackTrace()[0].toString()).getBytes();
		} catch (CryptorException e) {
			return (e.getMessage() + "," + e.getStackTrace()[0].toString()).getBytes();
		}

	}

}
