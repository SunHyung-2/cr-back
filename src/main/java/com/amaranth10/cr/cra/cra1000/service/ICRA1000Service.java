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

    /** CLRS0101 환자현황 ========================================================================================================================================== */
    /** 환자현황 대기 환자수 조회 ------------------------------------------------------------------------------------------------------------------------------------   */
    APIResult patientCount(RequestInfo requestInfo, RequestModel requestModel);

    /** 환자현황 대기 리스트 ----------------------------------------------------------------------------------------------------------------------------------------   */
    APIResult patientList(RequestInfo requestInfo, RequestModel requestModel);
    /** ========================================================================================================================================================== */


    /** CLRS0102 환자정보 ========================================================================================================================================== */
    /** 환자정보 접수정보 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult patientDetails(RequestInfo requestInfo, RequestModel requestModel);

    /** 관심환자 여부 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult updatePtCncn(RequestInfo requestInfo, RequestModel requestModel);

    /** 접수메모 저장 및 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult patientRcpnMemo(RequestInfo requestInfo, RequestModel requestModel);
    /** ========================================================================================================================================================== */


    /** CLRS0103 신체사정정보 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0104 검사결과 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0105 경과기록 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0106 처방조회 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0107 진단 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0108 처방 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */

}