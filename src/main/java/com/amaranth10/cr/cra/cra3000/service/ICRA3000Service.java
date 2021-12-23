package com.amaranth10.cr.cra.cra3000.service;

import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.cr.model.RequestModel;
import klago.log.utils.RequestInfo;

public interface ICRA3000Service {
    /** 약속처방 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult setList(RequestInfo requestInfo, RequestModel requestModel);

    /** 약속처방 검색 목록 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult searchSetList(RequestInfo requestInfo, RequestModel requestModel);

    /** 약속처방 진단 상세 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult setDgnsList(RequestInfo requestInfo, RequestModel requestModel);

    /** 약속처방 처방 상세 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult setPrscList(RequestInfo requestInfo, RequestModel requestModel);
}
