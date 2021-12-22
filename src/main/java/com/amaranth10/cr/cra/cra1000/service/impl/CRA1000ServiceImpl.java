package com.amaranth10.cr.cra.cra1000.service.impl;

import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.cr.cra.cra1000.mapper.CRA1000Mapper;
import com.amaranth10.cr.cra.cra1000.service.ICRA1000Service;
import com.amaranth10.cr.model.RequestModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import klago.log.service.KlagoLog;
import klago.log.utils.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 진료 메인 Service
 */
@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CRA1000ServiceImpl implements ICRA1000Service {
    @Autowired
    CRA1000Mapper cra1000Mapper;

    @Autowired
    private CRA1000ServiceImpl CRA1000ServiceImpl;

    @Override
    public APIResult selectTest(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        try {
            result.setResultCode(HttpServletResponse.SC_OK); // 결과 코드(int)
            result.setResultMsg("성공"); // 결과 메시지(String)
            result.setResultData(cra1000Mapper.testData()); // 결과 값(Object)
            return result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }


    /** CLRS0101 환자현황 ========================================================================================================================================== */
    /** 환자현황 대기 환자수 조회 ------------------------------------------------------------------------------------------------------------------------------------   */
    @Override
    public APIResult patientCount(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();

        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(cra1000Mapper.patientCount(param));
            return result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** 환자현황 대기 리스트 ----------------------------------------------------------------------------------------------------------------------------------------   */
    @Override
    public APIResult patientList(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(cra1000Mapper.patientList(param));
            return result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }
    /** ========================================================================================================================================================== */
}
