package com.amaranth10.cr.handler.api;

import com.amaranth10.cr.handler.AbstarctHandler;
import com.amaranth10.cr.mapper.CommonMapper;
import com.amaranth10.cr.model.RequestModel;
import com.amaranth10.cr.util.MessageManager;
import com.amaranth10.cr.util.RedisManager;
import klago.log.utils.RequestInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * 추상 핸들러를 상속받아 구현한 실제 Handler 객체입니다.
 * 
 * @author douzone
 *
 */
@Component("SA001A010")
public class SA001A010 extends AbstarctHandler {

	@Autowired
	MessageManager messageManager;
	
	@Autowired
	RedisManager redisManager;


	@Autowired
	CommonMapper commonMapper;


	@Override
	public String getAPICode() {
		return "SA001A010";
	}

	/**
	 * API명과 요청 받은 API의 명을 비교하여 메소드를 분기합니다.
	 */
	@Override
	public Object handle(RequestInfo requestInfo, RequestModel requestModel, String ApiCode, Locale locale) {
		// 결과값 변수 선언합니다.
		Map<String, Object> result = null;
		Map<String, Object> params = new HashMap<>();
		params = (Map<String, Object>) requestModel.getData();
		
		// 쿼리에 필요한 파라미터값을 사용자 정보에서 추출합니다.
		params.put("login_id", requestModel.getSessionInfo().getUcUserInfo().getLoginId());
		params.put("lang_code", requestModel.getSessionInfo().getUcUserInfo().getLangCode());
		
		//redis에서 고객사 정보를 가져옵니다.
		params.putAll(redisManager.getCustInfoByGroupSeq((String)params.get("groupSeq")));
		result = (Map<String, Object>) commonMapper.selectUserName(params);
		return result;
	}
	
}