package com.amaranth10.cr.service.impl;

import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.cr.mapper.CrMapper;
import com.amaranth10.cr.model.RequestModel;
import com.amaranth10.cr.service.ICrService;
import com.fasterxml.jackson.annotation.JsonInclude;
import klago.log.service.KlagoLog;
import klago.log.utils.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * 진료 Service
 */
@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrServiceImpl implements ICrService {

    @Autowired
    CrMapper crMapper;

    @Autowired
    private CrServiceImpl crServiceImpl;

    @Override
    public APIResult selectTest(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        try {
            result.setResultCode(HttpServletResponse.SC_OK); // 결과 코드(int)
            result.setResultMsg("성공"); // 결과 메시지(String)
            result.setResultData(crMapper.testData()); // 결과 값(Object)
            return result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }
}
