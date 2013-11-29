package net.cortexx.otp;

import static org.junit.Assert.assertTrue;
import net.cortexx.otp.Base32String.DecodingException;
import net.cortexx.otp.HmacBasedOneTimePassword.Algorithm;

import org.junit.Test;

public class HmacBasedOneTimePasswordTest {

	@Test
	public void testHmacBasedOneTimePassword() throws DecodingException {
		HmacBasedOneTimePassword hotpBasedOneTimePassword = new HmacBasedOneTimePassword(
				Algorithm.SHA1, 6, Base32String.decode("2222"));
		Integer p = hotpBasedOneTimePassword.generatePassword(1);
		System.out.println(p);
		assertTrue(p.toString().length()== 6);
	}
}
