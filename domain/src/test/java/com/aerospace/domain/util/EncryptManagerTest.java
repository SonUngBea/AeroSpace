package com.aerospace.domain.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by coupang on 2017. 8. 27..
 */
public class EncryptManagerTest {

	@Test
	public void test_encrypt() throws Exception {
		String origin = "TEST";
		String key = "alpha";
		String expect = EncryptManager.encryptWithSalt(origin, key);

		assertEquals(origin, EncryptManager.decryptWithSalt(expect, key));
	}

	@Test
	public void test_encrypt_equlas() throws Exception {
		String origin = "TEST";
		String key = "alpha";

		for (int index = 0; index < 10; index++) {
			assertEquals(EncryptManager.encryptWithSalt(origin, key), EncryptManager.encryptWithSalt(origin, key));
		}
	}
}