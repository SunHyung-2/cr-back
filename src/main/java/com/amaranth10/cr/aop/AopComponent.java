package com.amaranth10.cr.aop;

import com.amaranth10.backendcommon.util.helper.ExtractUtil;
import klago.log.service.KlagoLog;
import klago.log.utils.RequestInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Aspect
public class AopComponent {

    @Around("execution(* com.amaranth10.cr.Controller.*.*(..))"
            + "&&!@annotation(com.amaranth10.cr.util.NoLogging)")
    public Object LogAspect(ProceedingJoinPoint pjp) throws Throwable {

        long startTime = System.currentTimeMillis();
        // 애플리케이션에서 Request 객체를 읽어옴
        HttpServletRequest servletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse servletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        //로그 정보 (transaction-id, apiCode)를 넘기기 위하여 헤더 정보 파싱
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);

        KlagoLog.logStart(requestInfo, "start");

        Object retVal = pjp.proceed(); // 메서드 호출 자체를 감쌈

        KlagoLog.logEnd(requestInfo, startTime, "end");

        return retVal;

    }

}