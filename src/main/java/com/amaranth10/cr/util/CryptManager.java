package com.amaranth10.cr.util;

import com.amaranth10.backendcommon.util.helper.CryptUtil;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


/**
 * 암호화 관련 Manager입니다. 공통 JAR파일의 CrypoUtil을 사용하여 함호화
 * 
 * @author
 *
 */
@Component
public class CryptManager {

	// SHA256
	public static String getSHA256(String source) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return CryptUtil.getSHA256(source);
	}

	// HMAC
	public static String getHMAC(String key, String value) throws Exception {
		return CryptUtil.hmac(key, value);
	}
}
