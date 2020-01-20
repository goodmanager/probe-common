package com.felix.probe.util;

import org.apache.commons.codec.binary.Base64;

public class Base64Utils {

	public static String encode(byte[] data) {
		return Base64.encodeBase64URLSafeString(data);
	}

	public static byte[] decode(String data) {
		return Base64.decodeBase64(data);
	}
}
