package com.amaranth10.cr.service.impl;

import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.backendcommon.util.model.SessionInfo;
import com.amaranth10.backendcommon.util.model.UCUserInfo;
import com.amaranth10.cr.handler.HandlerManager;
import com.amaranth10.cr.handler.IHandler;
import com.amaranth10.cr.mapper.CommonMapper;
import com.amaranth10.cr.model.RequestModel;
import com.amaranth10.cr.service.IKlagoService;
import com.amaranth10.cr.util.MessageManager;
import com.amaranth10.cr.util.QueryManager;
import com.amaranth10.cr.util.RedisManager;
import com.amaranth10.cr.util.SessionManager;
import com.fasterxml.jackson.annotation.JsonInclude;
import klago.log.service.KlagoLog;
import klago.log.utils.RequestInfo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KlagoService implements IKlagoService {
	
	@Autowired
	SessionManager sessionManager;

	@Autowired
	CommonMapper commonMapper;

	@Autowired
	SqlSession sqlSession;

	@Autowired
	MessageManager messageManager;
	
	@Autowired
	HandlerManager handlerManager;
	
	@Autowired
	RedisManager redisManager;

	/**
	 * API 핸들러 구조의 action을 담당하는 메소드
	 * @param requestInfo
	 * @param requestModel
	 * @param ApiCode
	 * @return
	 */
	public Object action(RequestInfo requestInfo, RequestModel requestModel, String ApiCode) {
		//사용자 언어 코드를 따라 다국어 정의 
		Locale locale = MessageManager.checkLocale(requestModel.getSessionInfo());
		
		IHandler handler = null;
		//결과값 객체 선언
		APIResult result = new APIResult();
		try{
			//요청 URL의 서비스 명에 맞는 핸들러를 가져옵니다.
			handler = handlerManager.get(ApiCode);
		}catch(Exception e) {
			// 로직중 에러 로그 처리를 위하여 에러 로그 함수를 사용합니다.
			KlagoLog.logError(requestInfo, "개발자 입력 정보" + e.getMessage());
		}
		
		if(handler == null) {
			result.setResultCode(500);
			//다국어 처리를 사용하여 결과 메시지를 정의합니다.
			result.setResultMsg(messageManager.getMessage("SA2000", locale) + ApiCode);
			// 로직중 에러 로그 처리를 위하여 에러 로그 함수를 사용합니다.
			KlagoLog.logError(requestInfo, "개발자 입력 정보");
			return result;
		}else {
			try {
				//결과 코드 설정
				result.setResultCode(200);
				//결과 메시지 설정
				result.setResultMsg("");
				//결과값 설정
				result.setResultData(handler.handle(requestInfo, requestModel, ApiCode, locale));
			}catch(Exception e) {
				//결과 코드 설정
				result.setResultCode(500);
				//다국어 처리를 사용하여 결과 메시지 정의
				result.setResultMsg(messageManager.getMessage("SA1000", locale) + e.toString());
				// 로직중 에러 로그 처리를 위하여 에러 로그 함수를 사용합니다.
				KlagoLog.logError(requestInfo, "개발자 입력 정보"+e,e);
			}
			
		}
		
		return result;
	}
	
	/**
	 * DB 테스트를 위한 고객사 리스트 반환 메소드
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getCustList(RequestInfo requestInfo, RequestModel requestModel, Map<String, Object> params){

		//결과값 변수 선언합니다.
		List<Map<String, Object>> result = null;
		
		//DAO를 이용하여 DB 정보 조회합니다.
		result = (List<Map<String, Object>>) commonMapper.selectCompList(params);
		
		//결과값을 반환합니다.
		return result;
	}
	
	
	/**
	 * 쿼리 아이디와 파라미터로 쿼리를 조회하여 반환한다.
	 * @return
	 */
	@Override
	public String getQueryById(RequestInfo requestInfo, Map<String, Object> params) {
		String queryId = (String) params.get("queryId");
		Collection<String> coll = sqlSession.getConfiguration().getMappedStatementNames();
		Iterator<String> iter = coll.iterator();
		
		while (iter.hasNext()) {
			String id = iter.next();
			if (id.equals(queryId))
				break;
		}

		String ret = QueryManager.getQueryString(requestInfo, sqlSession, queryId, params);
		
		return ret;
	}
	
	/**
	 * 쿼리 아이디를 리스트로 반환한다.
	 * @return
	 */
	@Override
	public List<String> getQueryIdList(RequestInfo requestInfo){
		return QueryManager.getQueryIdList(sqlSession);
	}
	
	/**
	 * 개발용 로그인 메소드
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	@Override
	public Map<String, Object> devLogin(RequestInfo requestInfo, Map<String, Object> param) throws Exception{
		String token = null;
		
		//redis에서 고객사 정보를 가져옵니다.
		Map<String, String> params = redisManager.getCustInfoByGroupSeq((String)param.get("groupSeq"));
		
		param.put("DB_NEOS", params.get("DB_NEOS"));

		//모델객체로 DB를 가져오는부분입니다.
		// 파라미터값의 확인을 위하여 모델로 진행하는것을 지양합니다.
		UCUserInfo ucUserInfo = commonMapper.devLogin(param);
		
		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo.setUcUserInfo(ucUserInfo);
		
		SessionManager sessionManager = new SessionManager();
		
		return sessionManager.setSessionInfo(token, sessionInfo);
	}

	/**
	 * 문자열 NULL 체크 메소드
	 * @param value
	 * @return
	 */
	public String nullCheck(String value) {
		if (value == null)
			value = "";
		return value;
	}
}