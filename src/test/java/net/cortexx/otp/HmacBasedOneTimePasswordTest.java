package net.cortexx.otp;

import static org.junit.Assert.assertTrue;
import net.cortexx.otp.Base32String.DecodingException;
import net.cortexx.otp.HmacBasedOneTimePassword.Algorithm;

import org.junit.Test;

public class HmacBasedOneTimePasswordTest {

	@Test
	public void testHmacBasedOneTimePassword() throws DecodingException {
		int numberOfDigits = 6;
		HmacBasedOneTimePassword hotpBasedOneTimePassword = new HmacBasedOneTimePassword(
				Algorithm.SHA1, numberOfDigits, Base32String.decode("AAAQEAYEAUDAOCAJBIFQYDIOB4"));
		
		for (int i=0; i<10; ++i) {
			Integer p = hotpBasedOneTimePassword.generatePassword(i);
			System.out.println(p);
			assertTrue(p.toString().length()== numberOfDigits);
		}
	}
}
