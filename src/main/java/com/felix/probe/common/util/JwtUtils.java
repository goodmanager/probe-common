package com.felix.probe.common.util;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.felix.probe.common.constant.JwtAlgorithmType;

public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	/**
	 * 创建jwt token
	 * 当采用RSA和EC加密算法的时候需要相应的私钥和公钥
	 * 当采用SHA相关算法的时候只需秘钥
	 * 
	 * @param privateKey
	 * @param publicKey
	 * @param jwtAlgorithmType
	 * @param headerClaims
	 * @param payloadClaims
	 * @return
	 */
	public static String createJwtToken(String privateKey, String publicKey, JwtAlgorithmType jwtAlgorithmType,
			Map<String, Object> headerClaims, Map<String, Object> payloadClaims) {
		try {
			Algorithm algorithm = getAlgorithm(privateKey, publicKey, jwtAlgorithmType);
			Builder jwtBuilder = JWT.create();
			jwtBuilder.withHeader(headerClaims);
			payloadClaims.forEach((key, value) -> {
				jwtBuilder.withClaim(key, String.valueOf(value));
			});
			return jwtBuilder.sign(algorithm);
		} catch (JWTCreationException | InvalidKeySpecException | NoSuchAlgorithmException exception) {
			logger.error("创建jwtToken失败", exception);
		}
		return null;
	}

	/**
	 * 验证jwt token:当采用RSA和EC加密算法的时候需要相应的私钥和公钥 当采用SHA相关算法的时候只需秘钥
	 * 
	 * @param privateKey
	 * @param publicKey
	 * @param jwtToken
	 * @param jwtAlgorithmType
	 * @param headerClaims
	 * @param payloadClaims
	 * @return
	 */
	public static DecodedJWT verifyJwtToken(String privateKey, String publicKey, String jwtToken,
			JwtAlgorithmType jwtAlgorithmType, Map<String, Object> headerClaims, Map<String, Object> payloadClaims) {
		try {
			Algorithm algorithm = getAlgorithm(privateKey, publicKey, jwtAlgorithmType);
			Builder jwtBuilder = JWT.create();
			jwtBuilder.withHeader(headerClaims);
			payloadClaims.forEach((key, value) -> {
				jwtBuilder.withClaim(key, String.valueOf(value));
			});
			Verification require = JWT.require(algorithm);
			payloadClaims.forEach((key, value) -> {
				require.withClaim(key, String.valueOf(value));
			});
			return require.build().verify(jwtToken);
		} catch (JWTVerificationException | InvalidKeySpecException | NoSuchAlgorithmException exception) {
			logger.error("jwtToken验证失败", exception);
		}
		return null;
	}

	private static Algorithm getAlgorithm(String privateKey, String publicKey, JwtAlgorithmType jwtAlgorithmType)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		if (jwtAlgorithmType == JwtAlgorithmType.HS256) {
			return Algorithm.HMAC256(privateKey);
		} else if (jwtAlgorithmType == JwtAlgorithmType.HS512) {
			return Algorithm.HMAC512(privateKey);
		} else if (jwtAlgorithmType == JwtAlgorithmType.RS256) {
			RSAPrivateKey rsaPrivateKey = CryptUtils.getRsaPrivateKey(privateKey);
			RSAPublicKey rsaPublicKey = CryptUtils.getRsaPublicKey(publicKey);
			return Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
		} else if (jwtAlgorithmType == JwtAlgorithmType.RS512) {
			RSAPrivateKey rsaPrivateKey = CryptUtils.getRsaPrivateKey(privateKey);
			RSAPublicKey rsaPublicKey = CryptUtils.getRsaPublicKey(publicKey);
			return Algorithm.RSA512(rsaPublicKey, rsaPrivateKey);
		} else if (jwtAlgorithmType == JwtAlgorithmType.ES256) {
			ECPrivateKey ecPrivateKey = CryptUtils.getEcPrivateKey(privateKey);
			ECPublicKey ecPublicKey = CryptUtils.getEcPublicKey(publicKey);
			return Algorithm.ECDSA256(ecPublicKey, ecPrivateKey);
		} else {
			ECPrivateKey ecPrivateKey = CryptUtils.getEcPrivateKey(privateKey);
			ECPublicKey ecPublicKey = CryptUtils.getEcPublicKey(publicKey);
			return Algorithm.ECDSA512(ecPublicKey, ecPrivateKey);
		}
	}
}
