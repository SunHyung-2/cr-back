package com.amaranth10.cr.handler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 해당 클래스가 빈에 등록되면서 IHandler 인터페이스 타입의 빈을 불러와 handlerMap에 저장하는 클래스입니다.
 *
 * @author douzone
 *
 */
@Component("HandlerManager")
public class HandlerManager implements InitializingBean{

	@Autowired
	ApplicationContext applicationContext;

	private Map<String, IHandler> handlerMap = new HashMap<String, IHandler>();

	/**
	 * 빈에 등록시 실행되는 메소드
	 * 빈에 등록되어있는 IHandler 인터페이스 타입의 빈객체를 불러와 handlrMap에 저장합니다.
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, IHandler> beansMap = applicationContext.getBeansOfType(IHandler.class);
		for (IHandler handler : beansMap.values()) {
			handlerMap.put(handler.getAPICode(), handler);
		}
	}

	/**
	 * handlerMap에서 키값이 서비스명인 객체를 반환합니다.
	 * @param serviceName
	 * @return
	 */
	public IHandler get(String serviceName) {
		return handlerMap.get(serviceName);
	}

}