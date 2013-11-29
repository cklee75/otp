package net.cortexx.otp;

import static org.junit.Assert.assertEquals;

import java.security.SecureRandom;

import net.cortexx.otp.Base32String.DecodingException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class Base32StringTest {


	@Test
	public void testBase32String() throws DecodingException {
		// twenty-six letters A-Z and six digits 2-7
		String acceptedString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
		char[] chars = acceptedString.toCharArray();
		// Need multiple of 1 byte/8 characters:
		int count = 16;
		// Cheaper but not true random
		// String secret = RandomStringUtils.random(16, acceptedString);
		String secret = RandomStringUtils.random(count, 0, chars.length, false, false, chars, new SecureRandom());
		assertEquals(secret.length(), count);
		byte[] afterDecode = Base32String.decode(secret);
		System.out.println(afterDecode);
		String afterEncode = Base32String.encode(afterDecode);
		System.out.println(afterEncode);
		assertEquals(secret, afterEncode);
		
	}
	
	

}
