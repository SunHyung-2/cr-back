package com.amaranth10.cr.cra.cra3000.service.impl;

import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.cr.cra.cra3000.mapper.CRA3000Mapper;
import com.amaranth10.cr.cra.cra3000.service.ICRA3000Service;
import com.amaranth10.cr.model.RequestModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import klago.log.service.KlagoLog;
import klago.log.utils.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CRA3000ServiceImpl implements ICRA3000Service {
    @Autowired
    CRA3000Mapper cra3000Mapper;

    @Autowired
    private CRA3000ServiceImpl CRA3000ServiceImpl;

    /** 약속처방 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult setPrscList(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();

        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(cra3000Mapper.setPrscList(param));
            return result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }
}
