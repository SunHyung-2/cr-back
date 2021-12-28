package com.amaranth10.cr.cra.common.service.impl;

import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.cr.cra.common.mapper.CRACommonMapper;
import com.amaranth10.cr.cra.common.service.ICRACommonService;
import com.amaranth10.cr.model.RequestModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import klago.log.service.KlagoLog;
import klago.log.utils.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 진료 공통 Service
 */
@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CRACommonServiceImpl implements ICRACommonService {
    @Autowired
    CRACommonMapper craCommonMapper;

    @Autowired
    private CRACommonServiceImpl craCommonServiceImpl;

    /** 환자정보 조회 */
    @Override
    public APIResult patientInfo(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();

        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(craCommonMapper.patientInfo(param));
            return result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** 환자감염정보 조회 */
    @Override
    public APIResult patientInf(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();

        try {
            System.out.println(param);
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(craCommonMapper.patientInf(param));
            System.out.println(result);
            return result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** 환자 접수상태 변경 */
    @Override
    public APIResult updateRcpnStat(@RequestBody Object param){
        craCommonMapper.updateRcpnStat(param);
        return null;
    }
}
