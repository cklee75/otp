package net.cortexx.otp;

import static org.junit.Assert.assertTrue;
import net.cortexx.otp.Base32String.DecodingException;

import org.junit.Test;

public class Base32StringTest {


	@Test
	public void testBase32String() throws DecodingException {
		// Need at least 1 byte, 8 characters: twenty-six letters A-Z and six digits 2-7
		String secret = "ABCD7777";
		byte[] afterDecode = Base32String.decode(secret);
		System.out.println(afterDecode);
		String afterEncode = Base32String.encode(afterDecode);
		System.out.println(afterEncode);
		assertTrue(secret.equals(afterEncode));
		
	}

}
