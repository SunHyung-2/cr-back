package com.amaranth10.cr.util;

import com.amaranth10.backendcommon.util.model.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageManager {

	@Autowired
	MessageSource messageSource;
	
	/**
	 * 다국어 처리용 메소드입니다.
	 */
	public String getMessage(String code, Locale locale) {
		return messageSource.getMessage(code, null, locale);
	}
	
	/**
	 * 다국어 처리용 메소드입니다.
	 */
	public String getMessage(String code, Object[] args, Locale locale) {
		return messageSource.getMessage(code, args, null, locale);
	}
	
	/**
	 * 다국어를 처리하기 위하여 사용자의 landCode에 따른 locale을 구하는 메소드입니다.
	 * @param sessionInfo
	 * @return
	 */
	public static Locale checkLocale(SessionInfo sessionInfo) {
		Locale locale = Locale.KOREAN;
		if(sessionInfo == null || sessionInfo.getUcUserInfo() == null)
		{
			return locale;
		}
		switch (sessionInfo.getUcUserInfo().getLangCode()) {
		case "en":
			locale = Locale.US;
			break;
		}
		return locale;
	}
}
