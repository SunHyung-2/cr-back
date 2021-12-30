package com.amaranth10.cr.cra.cra1000.controller;

import com.amaranth10.backendcommon.util.helper.ExtractUtil;
import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.backendcommon.util.model.SessionInfo;
import com.amaranth10.cr.cra.cra1000.model.Diagnosis;
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
    /** 환자현황 진료의 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/doctList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult doctList(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {

        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.doctList(requestInfo, requestModel);
        return result;
    };
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

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.patientList(requestInfo, requestModel);
        return result;
    };
    /** ========================================================================================================================================================== */


    /** CLRS0102 환자정보 ========================================================================================================================================== */
    /** 환자정보 접수정보 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/patientDetails", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult patientDetails(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("patientDetails" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.patientDetails(requestInfo, requestModel);
        return result;
    };

    /** 관심환자 여부 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/updatePtCncn", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult updatePtCncn(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("updatePtCncn" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.updatePtCncn(requestInfo, requestModel);
        return result;
    };

    /** 접수메모 저장 및 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/patientRcpnMemo", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult patientRcpnMemo(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("patientRcpnMemo" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.patientRcpnMemo(requestInfo, requestModel);
        return result;
    };

    /** 진료메모 & 환자메모 저장 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/saveClrPtMemo", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult saveClrPtMemo(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("saveClrPtMemo" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.saveClrPtMemo(requestInfo, requestModel);
        return result;
    };

    /** 진료메모 & 환자메모 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/updateClrPtMemo", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult updateClrPtMemo(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("updateClrPtMemo" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.updateClrPtMemo(requestInfo, requestModel);
        return result;
    };

    /** 환자정보 접수정보 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/updatePtRcpn", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult updatePtRcpn(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("updatePtRcpn" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.updatePtRcpn(requestInfo, requestModel);
        return result;
    };

    /** 보험구분 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */

    /** 초재진 구분 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */

    /** 부서 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */

    /** 외래경로 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */

    /** 내원목적 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */


    /** ========================================================================================================================================================== */


    /** CLRS0103 신체사정정보 ======================================================================================================================================= */
    /** 신체사정정보 조회 -------------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/vitalData", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult vitalData(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {

        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.vitalData(requestInfo, requestModel);
        return result;
    };
    /** ========================================================================================================================================================== */


    /** CLRS0104 검사결과 ========================================================================================================================================== */
    /** 검사결과 조회 ----------------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/examResult", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult examResult(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {

        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.examResult(requestInfo, requestModel);
        return result;
    };
    /** ========================================================================================================================================================== */


    /** CLRS0105 경과기록 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0106 처방조회 ========================================================================================================================================== */
    /** 과거기록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/pastList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult pastList(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("pastList" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.pastList(requestInfo, requestModel);
        return result;
    };

    /** SLIP 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/slipList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult slipList(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("slipList" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.slipList(requestInfo, requestModel);
        return result;
    };

    /** Slip 수가 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/slipPrscList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult slipPrscList(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("slipPrscList" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.slipPrscList(requestInfo, requestModel);
        return result;
    };
    /** ========================================================================================================================================================== */


    /** CLRS0107 진단 ========================================================================================================================================== */
    /** 진단 검색 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/dgnsMList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult dgnsMList(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("dgnsMList" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.dgnsMList(requestInfo, requestModel);
        return result;
    };

    /** 진단 내역 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/dgnsList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult dgnsList(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("dgnsList" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.dgnsList(requestInfo, requestModel);
        return result;
    };

    /** 진단 저장 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/savePtDgns", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult savePtDgns(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("savePtDgns" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.savePtDgns(requestInfo, requestModel);
        return result;
    };

    /** 진단 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/updatePtDgns", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult updatePtDgns(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("updatePtDgns" + param);

        APIResult result = new APIResult();
        cra1000ServiceImpl.updatePtDgns(requestInfo, requestModel);
        cra1000ServiceImpl.saveNewPtDgns(requestInfo, requestModel);
        cra1000ServiceImpl.deletePtDgns(requestInfo, requestModel);
        return result;
    };
    /** ========================================================================================================================================================== */


    /** CLRS0108 처방 ========================================================================================================================================== */
    /** 처방 검색 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/prscMList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult prscMList(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("prscMList" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.prscMList(requestInfo, requestModel);
        return result;
    };

    /** 처방 내역 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/prscList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult prscList(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("prscList" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.prscList(requestInfo, requestModel);
        return result;
    };

    /** 처방 저장 -------------------------------------------------------------------------------------------------------------------------------------  */
    @RequestMapping(value = "/savePtPrsc", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult savePtPrsc(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        System.out.println("savePtPrsc" + param);

        APIResult result = new APIResult();
        result = cra1000ServiceImpl.savePtPrsc(requestInfo, requestModel);
        return result;
    };

    /** ========================================================================================================================================================== */
}
