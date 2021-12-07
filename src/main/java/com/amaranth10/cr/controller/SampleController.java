package com.amaranth10.cr.controller;

import com.amaranth10.backendcommon.util.helper.ExtractUtil;
import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.backendcommon.util.model.SessionInfo;
import com.amaranth10.cr.controller.model.CryptApiUseModel;
import com.amaranth10.cr.model.RequestModel;
import com.amaranth10.cr.service.impl.KlagoService;
import com.amaranth10.cr.util.CryptManager;
import com.amaranth10.cr.util.SessionManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import klago.log.service.KlagoLog;
import klago.log.utils.RequestInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * API코드 정의 입니다.
 * 
 * SA001A001 - test
 * SA001A002 - cryptAPI
 * SA001A003 - cryptAPIUseModel
 * SA001A004 - ApiSample
 * SA001A005 - getUserInfo
 * SA001A006 - getQuery
 * SA001A007 - queryList
 * SA001A008 - setSessionInfo
 * SA001A009 - devLogin
 * 
 * SA001A010 ~ - HandlerSample apiCode에 따라 이에 맞는 핸들러로 분기되어 처리됩니다.
 * 
 * @author douzone
 *
 */
@RestController
public class SampleController {

	@Autowired
	SessionManager sessionManager;

	@Autowired
	KlagoService service;

	/**
	 * 공용 로그함수 사용 샘플
	 * 
	 * @param servletRequest http 서블릿 요청 정보
	 * @param servletResponse http 서블릿 리턴 정보
	 * @return param {테스트용으로 logSql을 사용하기 위한 파라미터 값으로 임의의 맵 객체를 파라미터로 전달해주시면됩니다.}
	 * @throws IOException 
	 */
	@RequestMapping(value = "/SA001A001", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object Test(HttpServletRequest servletRequest, HttpServletResponse servletResponse ,
			@RequestBody Map<String, Object> param) throws IOException {
		
		// 헤더 정보 파싱 함수를 사용하여 헤더 정보의 필요 값들을 객체로 가져옵니다.
		// 공용 로그 라이브러리를 사용할때에도 해당 헤더 정보가 필요하기 때문에 모든 로직상에 파라미터로 전달되어야합니다.
		RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
		
		KlagoLog.logStart(KlagoLog.getLogInstance("backendCommon", "Filter", "Filter"), "requestInfo : " + requestInfo);

		// API의 시작을 로그로 남기기 위하여 API시작시 시작 로그 함수를 사용합니다.
		//[INFO ][2019-10-29 09:08:07](SampleController.java:59)[][test] - start 개발자 입력 정보
		KlagoLog.logStart(requestInfo, "개발자 입력 정보");
		
		// 종료 로그 함수에서 시작시간을 파악하기 위하여 사용합니다.
		long startTime = System.currentTimeMillis();

		// 로직중 에러 로그 처리를 위하여 에러 로그 함수를 사용합니다.
		//[ERROR][2019-10-29 09:08:07](SampleController.java:64)[][test] - Exception 개발자 입력 정보
		KlagoLog.logError(requestInfo, "개발자 입력 정보");
		
		// 로직 처리중 디버깅이 필요한 경우 디버그 로그함수를 사용합니다.
		//[DEBUG][2019-10-29 09:08:07](SampleController.java:66)[][test] - debug 개발자 입력 정보
		KlagoLog.logDebug(requestInfo, "개발자 입력 정보");
		
		// 로직 처리중 trace 레벨 로그 출력 필요 시 trace 로그함수를 사용합니다.
		KlagoLog.logTrace(requestInfo, "개발자 입력 정보");
		
		// 클라고에서는 로그에 쿼리 본문을 남기지 않기 때문에 쿼리를 조회하는 함수에 사용하기 위하 해당 쿼리 로그 함수로 쿼리아이디와 파라미터만을
		// 로그에 출력하기 위하여 로그함수를 사용합니다.
		//[DEBUG][2019-10-29 09:08:07](SampleController.java:71)[][test] - sql 개발자 입력 정보 {"test":"test"}
		KlagoLog.logSql(requestInfo, (HashMap<String, Object>) param, "개발자 입력 정보");

		// 단일화된 결과값을 반환하기 위하여 공용 모듈의 결과 함수를 사용합니다.
		APIResult result = new APIResult();
		result.setResultCode(200); // 결과 코드(int)
		result.setResultMsg("테스트 메세지 입니다."); // 결과 메시지(String)
		result.setResultData(HttpServletResponse.SC_OK); // 결과 값(Object)

		// API의 종료를 로그로 남기기 위하여 API 종료시 종료 로그 함수를 사용합니다. (파라미터의 startTime은 API처리 시간을
		// 계산하기 위하여 넘겨주셔야합니다.)
		//[INFO ][2019-10-29 09:08:07](SampleController.java:81)[][test] - end ET[2] 개발자 입력 정보
		KlagoLog.logEnd(requestInfo, startTime, "개발자 입력 정보");
		// 결과값을 반환합니다.
		return result;
	}

	/**
	 * Map 사용 param = {key, value} 암호화 샘플 API 입니다.
	 * @param servletRequest http 서블릿 요청 정보
	 * @param servletResponse http 서블릿 리턴 정보
	 * @param param = {key, value} key가 null이거나 ""인경우 SHA256방식입니다.
	 * @return 암호화된 값을 리턴합니다.(String)
	 * @throws NoSuchAlgorithmException
	 * @throws IOException 
	 */
	@RequestMapping(value = "/SA001A002", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object cryptAPI(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
			@RequestBody Map<String, Object> param) throws NoSuchAlgorithmException, IOException {

		// Start 로그는 AOP 방식 적용으로 자동으로 출력됩니다.
		
		// 헤더 정보 파싱 함수를 사용하여 헤더 정보의 필요 값들을 객체로 가져옵니다.
		// 공용 로그 라이브러리를 사용할때에도 해당 헤더 정보가 필요하기 때문에 모든 로직상에 파라미터로 전달되어야합니다.
		RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
		
		// 결과값
		String result = null;
		if ((String) param.get("cryptKey") == null || param.get("cryptKey") == "") {
			// 입력받은 value값을 SHA256으로 암호화 하여 반환
			result = CryptManager.getSHA256((String) param.get("cryptValue"));
		} else {
			try {
				// 입력받은 value값과 key값을 사용하여 HMAC으로 암호화 하여 반환
				result = CryptManager.getHMAC((String) param.get("cryptKey"), (String) param.get("cryptValue"));
			} catch (Exception e) {
				// 에러 로그 함수 사용
				KlagoLog.logError(requestInfo, "개발자 입력 정보");
			}
		}
		
		// End 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		return result;

	}

	/**
	 * 모델(CryptApiUseModel.java) 사용을 사용한 암호화 샘플 API 입니다.
	 * 정확한 파라미터 체크를 위하여 모델 사용을 권장합니다.
	 * 
	 * @param servletRequest http 서블릿 요청 정보
	 * @param servletResponse http 서블릿 리턴 정보
	 * @param model {key, value} key가 null이거나 ""인경우 SHA256방식입니다.
	 * @return 암호화된 값을 리턴합니다.(String)
	 * @throws NoSuchAlgorithmException
	 * @throws IOException 
	 */
	@RequestMapping(value = "/SA001A003", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object cryptAPIUseModel(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
			@RequestBody CryptApiUseModel model) throws NoSuchAlgorithmException, IOException {

		// Start 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		// 헤더 정보 파싱 함수를 사용하여 헤더 정보의 필요 값들을 객체로 가져옵니다.
		// 공용 로그 라이브러리를 사용할때에도 해당 헤더 정보가 필요하기 때문에 모든 로직상에 파라미터로 전달되어야합니다.
		RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
		
		// 결과값
		String result = null;
		if (model.getCryptKey() == null || model.getCryptKey() == "") {
			// 입력받은 value값을 SHA256으로 암호화 하여 반환합니다.
			result = CryptManager.getSHA256(model.getCryptValue());
		} else {
			try {
				// 입력받은 value값과 key값을 사용하여 HMAC으로 암호화 하여 반환합니다.
				result = CryptManager.getHMAC(model.getCryptKey(), model.getCryptValue());
			} catch (Exception e) {
				// 로직중 에러 로그 처리를 위하여 에러 로그 함수를 사용합니다.
				KlagoLog.logError(requestInfo, "암호화 처리중 에러가 발생하였습니다. " + e.toString());
			}
		}

		// End 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		// 결과값을 반환합니다.
		return result;

	}

	/**
	 * API Handler 구조 구현 샘플입니다.
	 * @param servletRequest http 서블릿 요청 정보
	 * @param servletResponse http 서블릿 리턴 정보
	 * @param param {ApiCode에 맞는 API의 요청 파라미터}
	 * @param ApiCode SA010A001 예) http://localhost:8080/sample/SA001A010
	 * @return ApiCode에 매칭되는 API핸들러의 결과값이 반환됩니다.
	 * @throws Exception
	 */
	@RequestMapping(value = "{ApiCode}", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object APIHandler(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
			@RequestBody Object param, @PathVariable String ApiCode) throws Exception {
		
		// Start 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		// 헤더 정보 파싱 함수를 사용하여 헤더 정보의 필요 값들을 객체로 가져옵니다.
		// 공용 로그 라이브러리를 사용할때에도 해당 헤더 정보가 필요하기 때문에 모든 로직상에 파라미터로 전달되어야합니다.
		RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);

		// 토큰 키값으로 인증이 완료되어 레디스에 저장된 사용자의 정보를 반환한다.
		// 토큰 키 값은 헤더 정보 파싱 함수를 사용하여 가져온다.
		SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

		// 해당 API요청에서 사용될 사용자 정보와 요청 파라미터를 담을 모델을 생성합니다.
		RequestModel requestModel = new RequestModel();
		// 요청 객체에 사용자 정보를 지정합니다.
		requestModel.setSessionInfo(userInfo);
		// 요청 객체에 요청 파라미터를 저장합니다.
		requestModel.setData(param);

		// 비즈니스 로직 처리를 위한 핸들러 서비스단을 호출합니다.
		Object result = null;
		result = service.action(requestInfo, requestModel, ApiCode);

		// End 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		// 결과값을 반환합니다.
		return result;

	}

	/**
	 * 실제 API 구현 샘플입니다.
	 * @param servletRequest http 서블릿 요청 정보
	 * @param servletResponse http 서블릿 리턴 정보
	 * @param request {해당 API의 요청 파라미터}
	 * @return list 고객 리스트를 반환합니다.
 	 * @throws Exception
	 */
	@RequestMapping(value = "/SA001A004", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object APISample(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
			@RequestBody Map<String, Object> request) throws Exception {

		// Start 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		// 헤더 정보 파싱 함수를 사용하여 헤더 정보의 필요 값들을 객체로 가져옵니다.
		// 공용 로그 라이브러리를 사용할때에도 해당 헤더 정보가 필요하기 때문에 모든 로직상에 파라미터로 전달되어야합니다.
		RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);

		// 토큰 키값으로 인증이 완료되어 레디스에 저장된 사용자의 정보를 반환한다.
		// 토큰 키 값은 헤더 정보 파싱 함수를 사용하여 가져온다.
		SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

		// 해당 API요청에서 사용될 사용자 정보와 요청 파라미터를 담을 모델을 생성합니다.
		RequestModel requestModel = new RequestModel();
		// 요청 객체에 사용자 정보를 지정합니다.
		requestModel.setSessionInfo(userInfo);
		// 요청 객체에 요청 파라미터를 저장합니다.
		requestModel.setData(request);
		
		// 비즈니스 로직 처리를 위한 서비스단 호출합니다.
		Object result = null;
		result = service.getCustList(requestInfo, requestModel, request);

		// End 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		// 결과값을 반환합니다.
		return result;

	}

	/**
	 * 토큰키로 레디스에서 인증된 사용자 정보를 반환하기 위한 사용자 정보 반환 API 입니다.
	 * @param servletRequest http 서블릿 요청 정보
	 * @param servletResponse http 서블릿 리턴 정보
	 * @param request {token_key}
	 * @return SessionInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/SA001A005", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getUserInfo(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
			@RequestBody Map<String, Object> request) throws Exception {

		// Start 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		// 헤더 정보 파싱 함수를 사용하여 헤더 정보의 필요 값들을 객체로 가져옵니다.
		// 공용 로그 라이브러리를 사용할때에도 해당 헤더 정보가 필요하기 때문에 모든 로직상에 파라미터로 전달되어야합니다.
		RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
		
		Object result = null;

		// 레디스에서 인증된 사용자 정보를 반환하기 위한 API입니다.
		result = sessionManager.getSessionInfo((String) request.get("token_key"));

		// End 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		return result;
	}

	/**
	 * 쿼리 아이디와 파라미터로 쿼리 조회 API Klago 공용로그를 사용하여 남긴 로그를 복사하여 해당 API로 요청시 파라미터가 적용된
	 * sql쿼리를 반환하는 API
	 * 
	 * @param servletRequest http 서블릿 요청 정보
	 * @param servletResponse http 서블릿 리턴 정보
	 * @param param {sqlLog로 남긴 로그의 내용을 그대로 복사하여 사용합니다.}
	 * @throws Exception
	 */
	@RequestMapping(value = "/SA001A006", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public void getQuery(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
			@RequestBody Map<String, Object> param) throws Exception {

		// Start 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		// 헤더 정보 파싱 함수를 사용하여 헤더 정보의 필요 값들을 객체로 가져옵니다.
		// 공용 로그 라이브러리를 사용할때에도 해당 헤더 정보가 필요하기 때문에 모든 로직상에 파라미터로 전달되어야합니다.
		RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
		
		String ret = service.getQueryById(requestInfo, param);

		servletResponse.setContentType("text/plain;charset=utf-8");
		servletResponse.getWriter().write(ret);
		servletResponse.getWriter().close();

		// End 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		return;
	}

	/**
	 * 쿼리 아이디 리스트 조회 API
	 * 
	 * @param servletRequest http 서블릿 요청 정보
	 * @param servletResponse http 서블릿 리턴 정보
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/SA001A007", method = { RequestMethod.GET })
	@ResponseBody
	public Object getQueryList(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
			throws Exception {
		
		// Start 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		// 헤더 정보 파싱 함수를 사용하여 헤더 정보의 필요 값들을 객체로 가져옵니다.
		// 공용 로그 라이브러리를 사용할때에도 해당 헤더 정보가 필요하기 때문에 모든 로직상에 파라미터로 전달되어야합니다.
		RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
		
		Object result = null;

		result = service.getQueryIdList(requestInfo);

		// End 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		return result;
	}

	/**
	 * 테스트 세션 저장 API입니다.
	 * 해당 API는 테스트 부분이긴 하지만 인증 이후 사용가능한 API입니다.
	 * 
	 * @param servletRequest http 서블릿 요청 정보
	 * @param servletResponse http 서블릿 리턴 정보
	 * @param param {token, sessionInfo}
	 * @return
	 */
	@RequestMapping(value = "/SA001A008", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object setSessionInfo(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
			@RequestBody Map<String, Object> param) throws Exception {

		// Start 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		// 헤더 정보 파싱 함수를 사용하여 헤더 정보의 필요 값들을 객체로 가져옵니다.
		// 공용 로그 라이브러리를 사용할때에도 해당 헤더 정보가 필요하기 때문에 모든 로직상에 파라미터로 전달되어야합니다.
		RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
		
		Object result = null;
		String token = null;
		if (param.get("token") != null) {
			token = (String) param.get("token");
		}

		ObjectMapper objectMapper = new ObjectMapper();

		SessionInfo sessionInfo = objectMapper.convertValue(param.get("sessionInfo"), SessionInfo.class);

		SessionManager sessionManager = new SessionManager();
		result = sessionManager.setSessionInfo(token, sessionInfo);
		
		// End 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		return result;
	}

	/**
	 * devLogin
	 * 로그인 아이디와 그룹시퀀스를 전달받아 세션을 저장하는 API입니다.
	 * 
	 * @param servletRequest http 서블릿 요청 정보
	 * @param servletResponse http 서블릿 리턴 정보
	 * @param param {loginId, groupSeq}
	 * @return {hashKey, token}
	 * @throws Exception 
	 */
	@RequestMapping(value = "/SA001A009", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object devLogin(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
			@RequestBody Map<String, Object> param) throws Exception {

		// Start 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		
		// 헤더 정보 파싱 함수를 사용하여 헤더 정보의 필요 값들을 객체로 가져옵니다.
		// 공용 로그 라이브러리를 사용할때에도 해당 헤더 정보가 필요하기 때문에 모든 로직상에 파라미터로 전달되어야합니다.
		RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
		
		// 비즈니스 로직 실행
		Object result = service.devLogin(requestInfo, param);

		// End 로그는 AOP 방식 적용으로 자동으로 출력됩니다.(KlagoLogAspect)
		return result;
	}
}
