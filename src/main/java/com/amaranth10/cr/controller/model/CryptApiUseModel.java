package com.amaranth10.cr.controller.model;

/**
 * 암호화 API 호출시 적용되는 Model 입니다.
 * @author CryptApiUseModel
 *
 */
public class CryptApiUseModel {
	String cryptKey;
	String cryptValue;
	
	
	public String getCryptKey() {
		return cryptKey;
	}
	public void setCryptKey(String cryptKey) {
		this.cryptKey = cryptKey;
	}
	public String getCryptValue() {
		return cryptValue;
	}
	public void setCryptValue(String cryptValue) {
		this.cryptValue = cryptValue;
	}
}
