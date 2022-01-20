package com.amaranth10.cr.cra.cra2000.controller;

import com.amaranth10.backendcommon.util.helper.ExtractUtil;
import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.backendcommon.util.model.SessionInfo;
import com.amaranth10.cr.cra.cra2000.service.ICRA2000Service;
import com.amaranth10.cr.model.RequestModel;
import klago.log.utils.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 진료 상용구 Controller
 */
@RestController
public class CRA2000Controller {
    @Autowired
    private ICRA2000Service iCRA2000Service;

    /** 상용구 분류 조회 */
    @PostMapping("/blpeList")
    public Object blpeList (@RequestBody Object param) {
        return this.iCRA2000Service.blpeList(param);
    };
}
