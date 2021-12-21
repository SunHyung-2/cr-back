package com.amaranth10.cr.service;

import com.amaranth10.cr.model.RequestModel;
import klago.log.utils.RequestInfo;

import java.util.List;
import java.util.Map;


/**
 * 서비스 인터페이스입니다.
 * 
 * @author douzone
 *
 */
public interface IKlagoService {
	
	//API 핸들러 구조의 action을 담당하는 메소드입니다.
	public Object action(RequestInfo servletRequest, RequestModel requestModel, String ApiCode);
	
	//고객정보를 가져오는 메소드입니다.
	public List<Map<String, Object>> getCustList(RequestInfo req, RequestModel requestModel, Map<String, Object> params);
		
	
	
	//아래내역은 지우실 필요가 없습니다.
	//sql 쿼리를 반환하는 메소드입니다.
	public String getQueryById(RequestInfo req, Map<String, Object> params);
	
	//sqlSession에 저장되어 있는 queryId 반환하는 메소드입니다.
	public List<String> getQueryIdList(RequestInfo req);
	
	//개발용 로그인 메소드입니다. GW 모듈에만 탑재될 예정입니다.
	public Map<String, Object> devLogin(RequestInfo requestInfo, Map<String, Object> param) throws Exception;
	
	//NULL 체크 메소드입니다.
	public String nullCheck(String value);

}