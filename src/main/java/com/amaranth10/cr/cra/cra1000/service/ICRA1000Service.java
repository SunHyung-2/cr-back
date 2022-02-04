package com.amaranth10.cr.cra.cra1000.service;

import com.amaranth10.cr.cra.cra1000.model.*;

import java.util.List;

/**
 * 진료 메인 Service interface
 */
public interface ICRA1000Service {

    /** CRA1010 환자현황 =========================================================================================================================================== */
    /** 환자현황 진료의 목록 조회 */
    List<Object> doctList(Object param);

    /** 접수상태코드 목록 조회 */
    List<Object> rcpnStatList (Object param);

    /** 환자현황 대기 환자수 조회 */
    Object patientCount(Object param);

    /** 환자현황 대기 리스트 */
    List<Patient> patientList(Object param);
    /** ========================================================================================================================================================== */


    /** CRA1020 환자정보 =========================================================================================================================================== */
    /** 환자정보 접수정보 조회 */
    Object patientDetails(Object param);

    /** 환자 만성질환 조회 */
    List<Object> ptCfsc (Object param);
    List<Object> ptChrn (Object param);

    /** 관심환자 여부 수정 */
    void updatePtCncn(Object param);

    /** 접수메모 저장 및 수정 */
    void patientRcpnMemo(Object param);

    /** 진료메모 & 환자메모 저장 */
    void saveClrPtMemo(Object param);

    /** 진료메모 & 환자메모 수정 */
    void updateClrPtMemo(Object param);

    /** 환자정보 수정 */
    void updatePtRcpn(Object param);

    /** 접수정보 수정 */
    void saveRcpn(Object param);

    /** 만성질환 수정 */
    void updateCfsc (Object param);
    void saveCfsc (Object param);

    /** 보험구분 목록 조회 */
    List<Object> insnList(Object param);

    /** 초재진구분 목록 조회 */
    List<Object> fvnrList(Object param);

    /** 부서 목록 조회 */
    List<Object> depList(Object param);

    /** 외래경로 목록 조회 */
    List<Object> pathList(Object param);

    /** 내원목적 목록 조회 */
    List<Object> prpsList(Object param);

    /** 산정특례구분코드 목록 조회 */
    List<Object> cfscDvcdList (Object param);
    /** ========================================================================================================================================================== */


    /** CRA1030 신체사정정보 / 검사결과 =============================================================================================================================== */
    /** 신체사정정보 조회 */
    List<Vital> vitalData(Object param);

    /** 신체사정그래프 데이터 조회 */
    List<Vital> vitalGraphData(Object param);

    /** 신체사정 참고치 데이터 */
    List<Object> vitalReferData (Object param);

    /** 검사결과 조회 */
    List<Exam> examResult(Object param);
    /** ========================================================================================================================================================== */


    /** CRA1040 경과기록 =========================================================================================================================================== */
    /** 경과기록 리스트 조회 */
    List<Object> progressList(Object param);

    /** 경과기록 기본형 데이터 조회 */
    String progressData(Object param);

    /** 경과기록 SOAP 데이터 조회 */
    Object progressSOAPData(Object param);

    /** 경과기록 일련번호 체크 */
    Integer prgrSqnoCheck(Object param);

    /** 경과기록 추가 */
    void progressInsert(Object param);

    /** 경과기록 수정 */
    void progressUpdate(Object param);

    /** 경과기록 삭제 */
    void progressDelete(Object param);
    /** ========================================================================================================================================================== */


    /** CRA1050 처방조회 =========================================================================================================================================== */
    /** 과거기록 조회 */
    List<Reception> pastList(Object param);

    /** 경과기록 조회 */
    Progress prgrList (Object param);

    /** 완료 검사결과 조회 */
    List<Exam> completeExam (Object param);

    /** SLIP 목록 조회 */
    List<Slip> slipList(Object param);

    /** Slip 수가 목록 조회 */
    List<Prescription> slipPrscList(Object param);
    /** ========================================================================================================================================================== */


    /** CRA1060 진단/처방 ========================================================================================================================================== */
    /** 진단 검색 목록 조회 */
    List<Diagnosis> dgnsMList(Object param);

    /** 진단 내역 조회 */
    List<Diagnosis> dgnsList(Object param);

    /** 진단 저장 */
    void savePtDgns(Object param);

    /** 진단 수정 */
    void updatePtDgns(Object param);

    /** 진단 형태 목록 조회 */
    List<Object> dvsnList(Object param);

    /** 진단 부위 목록 조회 */
    List<Object> siteList(Object param);

    /** 처방 검색 목록 조회 */
    List<Prescription> prscMList(Object param);

    /** 처방 내역 조회 */
    List<Prescription> prscList(Object param);

    /** 처방 저장 */
    void savePtPrsc(Object param);

    /** 처방 수정 */
    void updatePtPrsc(Object param);

    /** 의약분업예외 목록 조회 */
    List<Object> excpList(Object param);

    /** 용법 목록 조회 */
    List<Object> iotmList(Object param);

    /** 처방 약속 저장 */
    void savePrscSet (Object param);

    /** DC사유 목록 조회 */
    List<Object> dcList (Object param);

    /** 급여 목록 조회 */
    List<Object> prscPayList (Object param);

    /** 원외 목록 조회 */
    List<Object> hostList (Object param);

    /** 산정 목록 조회 */
    List<Object> cmptList (Object param);

    /** ========================================================================================================================================================== */
}