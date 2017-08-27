package com.aerospace.domain.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * Created by coupang on 2017. 8. 27..
 */
@Slf4j
public class EncryptManager {

	private static byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private static IvParameterSpec ivspec = new IvParameterSpec(iv);

	public static String encryptWithSalt(String origin, String key) {
		try {
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, makeKey(key), ivspec);
			byte[] encrypted = c.doFinal(origin.getBytes("UTF-8"));
			String enStr = new String(Base64.encodeBase64(encrypted));

			return enStr;
		} catch (Exception e) {
			return StringUtils.EMPTY;
		}
	}

	public static String decryptWithSalt(String origin, String key) {
		try {
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, makeKey(key), ivspec);

			byte[] byteStr = Base64.decodeBase64(origin.getBytes());

			return new String(c.doFinal(byteStr), "UTF-8");
		} catch (Exception e) {
			return StringUtils.EMPTY;
		}
	}

	private static Key makeKey(String key) throws Exception {
		byte[] keyBytes = new byte[16];
		byte[] byteKey = key.getBytes("UTF-8");
		int len = byteKey.length > keyBytes.length ? keyBytes.length : byteKey.length;
		System.arraycopy(byteKey, 0, keyBytes, 0, len);
		return new SecretKeySpec(keyBytes, "AES");
	}
}
