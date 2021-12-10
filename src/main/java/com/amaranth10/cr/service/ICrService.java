package com.amaranth10.cr.service;

import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.cr.model.RequestModel;
import klago.log.utils.RequestInfo;

/**
 * 진료 Service interface
 */
public interface ICrService {
    APIResult selectTest(RequestInfo requestInfo, RequestModel requestModel);
}
