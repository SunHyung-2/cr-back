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

    /** 감염리스트 조회 */
    APIResult infList(RequestInfo requestInfo, RequestModel requestModel);

    /** 환자감염정보 조회 */
    APIResult patientInf(RequestInfo requestInfo, RequestModel requestModel);

    /** 환자감염정보 추가 */
    APIResult infInsert(@RequestBody Object param);

    /** 환자감염정보 수정 */
    APIResult infUpdate(@RequestBody Object param);

    /** 환자알러지정보 조회 */
    APIResult patientAlg(RequestInfo requestInfo, RequestModel requestModel);

    /** 환자알러지정보 추가 */
    APIResult algInsert(@RequestBody Object param);

    /** 환자알러지정보 수정 */
    APIResult algUpdate(@RequestBody Object param);

    /** 환자 접수상태 변경 */
    APIResult updateRcpnStat(@RequestBody Object param);
}