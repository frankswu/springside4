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
			byte[] ciphertext = cryptor.encryptData(plaintext, password.toCharArray());
		} catch (CryptorException e) {
			// Something went wrong
			e.printStackTrace();
		}
	}

}
