package org.springside.test.aes;

import org.cryptonode.jncryptor.AES256JNCryptor;
import org.cryptonode.jncryptor.CryptorException;
import org.cryptonode.jncryptor.JNCryptor;

public class AesTest {

	public static void main(String[] args) {
		JNCryptor cryptor = new AES256JNCryptor();
		byte[] plaintext = "Hello, World!".getBytes();
		String password = "secretsquirrel";

		try {
			System.out.println(new String(plaintext));
			byte[] ciphertext = cryptor.encryptData(plaintext, password.toCharArray());
			System.out.println(new String(ciphertext));

			byte[] plaintext2 = decryptData(ciphertext, password);
			System.out.println(new String(plaintext2));

		} catch (CryptorException e) {
			// Something went wrong
			e.printStackTrace();
		}
	}

	private static byte[] decryptData(byte[] ciphertext, String password) throws CryptorException {
		JNCryptor cryptor = new AES256JNCryptor();
		return cryptor.decryptData(ciphertext, password.toCharArray());

	}

}
