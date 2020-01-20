package com.felix.probe.util;

import org.apache.commons.codec.digest.DigestUtils;

public class CryptUtils {

	public static String md5Encrypt(String text, String key) throws Exception {
		// 加密后的字符串
		String encodeStr = DigestUtils.md5Hex(text + key);
		return encodeStr;
	}

	public static boolean md5Verify(String text, String key, String md5Source) throws Exception {
		// 根据传入的密钥进行验证
		String md5Text = md5Encrypt(text, key);
		if (md5Text.equalsIgnoreCase(md5Source)) {
			return true;
		}
		return false;
	}

	public static String sha256Encypt(String text, String key) {
		String sha256Hex = DigestUtils.sha256Hex(text + key);
		return sha256Hex;
	}

	public static boolean sha256Verify(String text, String key, String sha256Source) throws Exception {
		// 根据传入的密钥进行验证
		String sha256Text = sha256Encypt(text, key);
		if (sha256Text.equalsIgnoreCase(sha256Source)) {
			return true;
		}
		return false;
	}

	public static String sha512Encypt(String text, String key) {
		String sha256Hex = DigestUtils.sha512Hex(text + key);
		return sha256Hex;
	}

	public static boolean sha512Verify(String text, String key, String sha512Source) throws Exception {
		// 根据传入的密钥进行验证
		String sha512Text = sha512Encypt(text, key);
		if (sha512Text.equalsIgnoreCase(sha512Source)) {
			return true;
		}
		return false;
	}

}
