package net.cortexx.otp;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import net.cortexx.otp.Base32String.DecodingException;
import net.cortexx.otp.HmacBasedOneTimePassword.Algorithm;

import org.junit.AfterClass;
import org.junit.Test;

public class TimeBasedOneTimePasswordTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testTimeBasedOneTimePassword() throws DecodingException {
		TimeBasedOneTimePassword totp = new TimeBasedOneTimePassword(30,
				TimeUnit.SECONDS, 2);
		HmacBasedOneTimePassword hotp = new HmacBasedOneTimePassword(
				Algorithm.SHA1, 6, Base32String.decode("JBSWY3DPEHPK3PXP"));
		int p = totp.generatePassword(hotp);
		System.out.println(p);
		assertTrue(totp.validate(p, hotp));
	}

}
