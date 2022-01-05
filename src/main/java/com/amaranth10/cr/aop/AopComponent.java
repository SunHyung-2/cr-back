package com.amaranth10.cr.aop;

import com.amaranth10.backendcommon.util.helper.ExtractUtil;
import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.backendcommon.util.model.SessionInfo;
import com.amaranth10.cr.cra.cra1000.controller.CRA1000Controller;
import com.amaranth10.cr.util.SessionManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import klago.log.service.CommonLogger;
import klago.log.service.KlagoLog;
import klago.log.utils.RequestInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
public class AopComponent {
    private static final Logger logger = LoggerFactory.getLogger(CRA1000Controller.class);

    @Autowired
    SessionManager sessionManager;

    @Around("execution(* com.amaranth10.cr.cra..controller.*.*(..))"
            + "&&!@annotation(com.amaranth10.cr.util.NoLogging)")
    public Object LogAspect(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        long startTime = System.currentTimeMillis();
        // 애플리케이션에서 Request 객체를 읽어옴
        HttpServletRequest servletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse servletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        // 헤더 정보 파싱 함수를 사용하여 헤더 정보의 필요 값들을 객체로 가져옵니다.
        // 공용 로그 라이브러리를 사용할때에도 해당 헤더 정보가 필요하기 때문에 모든 로직상에 파라미터로 전달되어야합니다.
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);

        // 사용자 정보 조회
        SessionInfo sessionInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());
        String fileName = String.format("%s.%s", pjp.getTarget().getClass().getName(), method.getName());


        int lineNumber = -1;

        // Get Db Info
        //Map<String, String> dbInfo = sessionManager.getCustInfoByGroupSeq(sessionInfo.getUcUserInfo().getGroupSeq());
        if(requestInfo != null) {
            CommonLogger.logStart(logger, fileName, lineNumber,
                    requestInfo.getTransactionId(), requestInfo.getApiCode(), "Start");
        }


        Object result = null;
        try {
            result = pjp.proceed();
            if (!(result instanceof APIResult)) {

                APIResult apiResult = new APIResult();

                apiResult.setResultData(result);
                apiResult.setResultCode(HttpServletResponse.SC_OK);
                apiResult.setResultMsg("성공");
                result = apiResult;
            }
        } catch (Exception e) {
            if (requestInfo != null) {
                CommonLogger.logException(logger, fileName, lineNumber,
                        requestInfo.getTransactionId(), requestInfo.getApiCode(), "Exception", e);
            }
            if (true) {
                APIResult apiResult = new APIResult();
                apiResult.setResultCode(50);
                apiResult.setResultMsg("에러");
                result = apiResult;
            } else {
                throw e;
            }
        } finally {
            if (requestInfo != null) {

                ObjectWriter ow = new ObjectMapper().writer();
                String json = ow.writeValueAsString(result);
                System.out.println("[ResultData] " + json);

                CommonLogger.logEnd(logger, fileName, lineNumber,
                        requestInfo.getTransactionId(), requestInfo.getApiCode(), startTime, "End");
            }
        }

        return result;

    }

}