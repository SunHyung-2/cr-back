package com.amaranth10.cr.cra.cra1000.service;

import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.cr.model.RequestModel;
import klago.log.utils.RequestInfo;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 진료 메인 Service interface
 */
public interface ICRA1000Service {
    APIResult selectTest(RequestInfo requestInfo, RequestModel requestModel);
}