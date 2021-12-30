package com.amaranth10.cr.cra.cra1000.service;

import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.backendcommon.util.model.APIResultT;
import com.amaranth10.cr.model.RequestModel;
import klago.log.utils.RequestInfo;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 진료 메인 Service interface
 */
public interface ICRA1000Service {
    APIResult selectTest(RequestInfo requestInfo, RequestModel requestModel);

    /** CLRS0101 환자현황 ========================================================================================================================================== */
    /** 환자현황 진료의 목록 조회 ------------------------------------------------------------------------------------------------------------------------------------   */
    APIResult doctList(RequestInfo requestInfo, RequestModel requestModel);

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

    /** 진료메모 & 환자메모 저장 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult saveClrPtMemo(RequestInfo requestInfo, RequestModel requestModel);

    /** 진료메모 & 환자메모 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult updateClrPtMemo(RequestInfo requestInfo, RequestModel requestModel);

    /** 환자정보 접수정보 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult updatePtRcpn(RequestInfo requestInfo, RequestModel requestModel);


    /** ========================================================================================================================================================== */


    /** CLRS0103 신체사정정보 ======================================================================================================================================= */
    /** 신체사정정보 조회 -------------------------------------------------------------------------------------------------------------------------------------------- */
    APIResult vitalData(RequestInfo requestInfo, RequestModel requestModel);
    /** ========================================================================================================================================================== */


    /** CLRS0104 검사결과 ========================================================================================================================================== */
    /** 검사결과 조회 ----------------------------------------------------------------------------------------------------------------------------------------------- */
    APIResult examResult(RequestInfo requestInfo, RequestModel requestModel);
    /** ========================================================================================================================================================== */


    /** CLRS0105 경과기록 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0106 처방조회 ========================================================================================================================================== */
    /** 과거기록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult pastList(RequestInfo requestInfo, RequestModel requestModel);

    /** Slip 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult slipList(RequestInfo requestInfo, RequestModel requestModel);

    /** Slip 수가 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult slipPrscList(RequestInfo requestInfo, RequestModel requestModel);
    /** ========================================================================================================================================================== */


    /** CLRS0107 진단 ========================================================================================================================================== */
    /** 진단 검색 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult dgnsMList(RequestInfo requestInfo, RequestModel requestModel);

    /** 진단 내역 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult dgnsList(RequestInfo requestInfo, RequestModel requestModel);

    /** 진단 저장 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult savePtDgns(RequestInfo requestInfo, RequestModel requestModel);

    /** 진단 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult updatePtDgns(RequestInfo requestInfo, RequestModel requestModel);

    /** 추가된 진단 저장 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult saveNewPtDgns(RequestInfo requestInfo, RequestModel requestModel);

    /** 삭제된 진단 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult deletePtDgns(RequestInfo requestInfo, RequestModel requestModel);

    /** ========================================================================================================================================================== */


    /** CLRS0108 처방 ========================================================================================================================================== */
    /** 처방 검색 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult prscMList(RequestInfo requestInfo, RequestModel requestModel);

    /** 처방 내역 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult prscList(RequestInfo requestInfo, RequestModel requestModel);

    /** 처방 저장 -------------------------------------------------------------------------------------------------------------------------------------  */
    APIResult savePtPrsc(RequestInfo requestInfo, RequestModel requestModel);

    /** ========================================================================================================================================================== */

}