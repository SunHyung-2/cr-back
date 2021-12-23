package com.amaranth10.cr.cra.cra3000.service;

import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.cr.model.RequestModel;
import klago.log.utils.RequestInfo;

public interface ICRA3000Service {
    /** 약속처방 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult setPrscList(RequestInfo requestInfo, RequestModel requestModel);
}
