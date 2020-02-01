package com.felix.probe.common.util;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

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

	public static RSAPublicKey getRsaPublicKey(String rsaPublicKey)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		byte[] keyBytes = rsaPublicKey.getBytes();
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return (RSAPublicKey) keyFactory.generatePublic(keySpec);
	}

	public static RSAPrivateKey getRsaPrivateKey(String rsaPrivateKey)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		byte[] keyBytes = rsaPrivateKey.getBytes();
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
	}

	public static ECPublicKey getEcPublicKey(String ecPublicKey)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		byte[] keyBytes = ecPublicKey.getBytes();
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("EC");
		return (ECPublicKey) keyFactory.generatePublic(keySpec);
	}

	public static ECPrivateKey getEcPrivateKey(String ecPrivateKey)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		byte[] keyBytes = ecPrivateKey.getBytes();
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("EC");
		return (ECPrivateKey) keyFactory.generatePrivate(keySpec);
	}

}
