package gov.ifms.common.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * The Class EncryptDecryptUtil.
 */
@Component
public class EncryptDecryptUtil {
	
	
	/** The environment. */
	@Autowired
	private Environment environment;

	/** The salt. */
	private static final byte[] SALT = { (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12, (byte) 0xde, (byte) 0x33,
			(byte) 0x10, (byte) 0x12, };

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(EncryptDecryptUtil.class);

	/**
	 * Encrypt.
	 *
	 * @param property the property
	 * @return the string
	 */
	public String encrypt(String property) {
		SecretKeyFactory keyFactory;
		try 
		{
			String keyValue = environment.getProperty(Constant.SPRING_ENCRYPT_KEY);
			if(keyValue==null)
				return null;
			keyFactory = SecretKeyFactory.getInstance(Constant.SECURE_ALGO);
			SecretKey key = keyFactory.generateSecret(new PBEKeySpec(keyValue.toCharArray()));
			Cipher pbeCipher = Cipher.getInstance(Constant.SECURE_ALGO);
			pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
			return base64Encode(pbeCipher.doFinal(property.getBytes(Constant.UTF8)));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		}
	}

	/**
	 * Base 64 encode.
	 *
	 * @param bytes the bytes
	 * @return the string
	 */
	public String base64Encode(byte[] bytes) {
		return Base64.getEncoder().encodeToString(bytes);
	}

	/**
	 * Decrypt.
	 *
	 * @param property the property
	 * @return the string
	 */
	public String decrypt(String property) {
		SecretKeyFactory keyFactory;
		try {
			String keyValue = environment.getProperty(Constant.SPRING_ENCRYPT_KEY);
			if(keyValue==null)
				return null;
			keyFactory = SecretKeyFactory.getInstance(Constant.SECURE_ALGO);
			SecretKey key = keyFactory.generateSecret(new PBEKeySpec(keyValue.toCharArray()));
			Cipher pbeCipher = Cipher.getInstance(Constant.SECURE_ALGO);
			pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
			return new String(pbeCipher.doFinal(base64Decode(property)), Constant.UTF8);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		}
	}

	/**
	 * Base 64 decode.
	 *
	 * @param property the property
	 * @return the byte[]
	 */
	public byte[] base64Decode(String property){
		return Base64.getDecoder().decode(property);
	}

}
