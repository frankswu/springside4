package org.springside.test.aes;

import static org.junit.Assert.*;

import java.security.MessageDigest;

import javax.crypto.Cipher;

import org.cryptonode.jncryptor.AES256JNCryptor;
import org.cryptonode.jncryptor.CryptorException;
import org.cryptonode.jncryptor.JNCryptor;
import org.junit.Assert;
import org.junit.Test;

public class AesTest {

	public static void main(String[] args) {
		try {
	    	encoding_decoding();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAes() throws Exception {
		JNCryptor cryptor = new AES256JNCryptor();
		byte[] plaintext = "Hello, World!".getBytes();
		String password = "freeteam";

		try {
			printByteArray(plaintext);
			byte[] ciphertext = cryptor.encryptData(plaintext, password.toCharArray());
			printByteArray(ciphertext);

			byte[] plaintext2 = decryptData(ciphertext, password);
			printByteArray(plaintext2);

		} catch (CryptorException e) {
			// Something went wrong
		}
	}
	
	private static void encoding_decoding() {
		try {
			
			// Without the unlimited strength policy files this results in 128, 
//			after they have been installed properly the result is 2147483647.
			int maxKeyLen = Cipher.getMaxAllowedKeyLength("AES");
		    System.out.println(maxKeyLen);
		    
			String password = MD5("1234");
		    System.out.println(password);
			
			byte[] plaintext = "Hello, World!".getBytes("utf-8");

			printArray(plaintext);
			AES256JNCryptor cryptor = new AES256JNCryptor();
			byte[] ciphertext;
			ciphertext = cryptor.encryptData(plaintext, password.toCharArray());
			// Check version
			// assertEquals(AES256v3Ciphertext.EXPECTED_VERSION, ciphertext[0]);
			printArray(ciphertext);

			byte[] plaintext2 = cryptor.decryptData(ciphertext,
					password.toCharArray());
			printArray(plaintext2);
			System.out.println(new String(plaintext2,"utf-8"));
//			System.out.println("plaintext[" ++ "]");
//			System.out.println("plaintext2[" +plaintext2+ "]");
			Assert.assertArrayEquals(plaintext, plaintext2);
//			Assert.assertarray
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	private static void printArray(byte[] arrayChar) {
		// TODO Auto-generated method stub
		System.out.print("[");
		for (byte b : arrayChar) {
			System.out.print(b);
		}
		System.out.print("]\n");
		
	}
	
	
	private static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
            
        }catch(Exception e){
        	e.printStackTrace();
        }
        return null;
	}
	
    public int solution(int[] A) {
        // write your code in Java SE 7
    	Integer o = 955;
    	System.out.println(Integer.toBinaryString(955));
    	
        //去除不符合条件的输入
        if(A == null) return -1;
        if(A.length == 0 || A.length > 100000) return -1;
        
        int theLenghtOfA = A.length;

		for (int i = 0,jumpNum = 1 ; i < theLenghtOfA && jumpNum > theLenghtOfA; jumpNum++) {
			if (A[i] < -1000000 ||  A[i] > 1000000) {
				return -1;
			}
			int jumpSize = A[i];
			i = i + jumpSize;
			if(i > theLenghtOfA) return jumpNum;
		}
        
        return -1;
    }
	
	private static byte[] decryptData(byte[] ciphertext, String password) throws CryptorException {
		JNCryptor cryptor = new AES256JNCryptor();
		return cryptor.decryptData(ciphertext, password.toCharArray());

	}

	
	private static void printByteArray(byte[] byteArray) {
		// TODO Auto-generated method stub
		for (int i = 0; i < byteArray.length; i++) {
			System.out.print(byteArray[i]);
		}
		System.out.println();
	}

}
