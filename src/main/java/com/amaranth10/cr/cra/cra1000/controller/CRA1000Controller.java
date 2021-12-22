package com.amaranth10.cr.cra.cra1000.controller;

import com.amaranth10.backendcommon.util.helper.ExtractUtil;
import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.backendcommon.util.model.SessionInfo;
import com.amaranth10.cr.cra.cra1000.service.impl.CRA1000ServiceImpl;
import com.amaranth10.cr.model.RequestModel;
import com.amaranth10.cr.util.SessionManager;
import klago.log.utils.RequestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 진료 메인 Controller
 */
@Controller
public class CRA1000Controller {
    private static final Logger logger = LoggerFactory.getLogger(CRA1000Controller.class);
    @Autowired
    private CRA1000ServiceImpl cra1000ServiceImpl;
    @Autowired
    SessionManager sessionManager;

    /***
     * 조회 테스트
     */
    @RequestMapping(value = "/selectTest", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult selectTest(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {

        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.selectTest(requestInfo, requestModel);
        return result;
    }

    /** CLRS0101 환자현황 ========================================================================================================================================== */
    /** 환자현황 대기 환자수 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/patientCount", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult patientCount(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {

        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.patientCount(requestInfo, requestModel);
        return result;
    };

    /** 환자현황 대기 리스트 ----------------------------------------------------------------------------------------------------------------------------------------   */
    @RequestMapping(value = "/patientList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult patientList(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {

        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println(param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.patientList(requestInfo, requestModel);
        return result;
    };
    /** ========================================================================================================================================================== */

}
