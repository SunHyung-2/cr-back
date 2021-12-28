package com.amaranth10.cr.cra.common.service;

import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.cr.model.RequestModel;
import klago.log.utils.RequestInfo;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 진료 공통 Service interface
 */
public interface ICRACommonService {
    /** 환자정보 조회 */
    APIResult patientInfo(RequestInfo requestInfo, RequestModel requestModel);

    /** 환자감염정보 조회 */
    APIResult patientInf(RequestInfo requestInfo, RequestModel requestModel);

    /** 환자 접수상태 변경 */
    APIResult updateRcpnStat(@RequestBody Object param);
}