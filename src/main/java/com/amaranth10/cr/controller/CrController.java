package com.amaranth10.cr.controller;

import com.amaranth10.backendcommon.util.helper.ExtractUtil;
import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.backendcommon.util.model.SessionInfo;
import com.amaranth10.cr.model.RequestModel;
import com.amaranth10.cr.service.impl.CrServiceImpl;
import com.amaranth10.cr.util.RequestUtil;
import com.amaranth10.cr.util.SessionManager;
import klago.log.utils.RequestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 진료 Controller
 */
@Controller
public class CrController {
    private static final Logger logger = LoggerFactory.getLogger(CrController.class);

    @Autowired
    private CrServiceImpl crServiceImpl;

    @Autowired
    SessionManager sessionManager;

    /***
     * 조회 테스트
     */
    @RequestMapping(value = "/selectTest", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public APIResult selectTest(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws Exception {

        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        SessionInfo userInfo = sessionManager.getSessionInfo(requestInfo.getAuthToken());

        RequestModel requestModel = new RequestModel();


        requestModel.setSessionInfo(userInfo);

        HashMap<String, Object> param = RequestUtil.paramToHashMap(servletRequest);

        APIResult result = new APIResult();
        result = crServiceImpl.selectTest(requestInfo, requestModel);
        return result;
    }
}
