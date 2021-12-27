package com.amaranth10.cr.cra.common.controller;

import com.amaranth10.backendcommon.util.helper.ExtractUtil;
import com.amaranth10.backendcommon.util.model.SessionInfo;
import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.cr.cra.common.service.impl.CRACommonServiceImpl;
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

/**
 * 진료 공통 Controller
 */
@Controller
public class CRACommonController {
    private static final Logger logger = LoggerFactory.getLogger(CRACommonController.class);
    @Autowired
    private CRACommonServiceImpl craCommonServiceImpl;
    @Autowired
    SessionManager sessionManager;

    /** 환자 접수상태 변경 */
    @RequestMapping(value = "/updateRcpnStat", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public APIResult updateRcpnStat(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Object param) throws Exception {
        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);

        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();
        requestModel.setSessionInfo(userInfo);
        requestModel.setData(param);

        APIResult result = new APIResult();
        result = craCommonServiceImpl.updateRcpnStat(param);
        return result;
    }

}
