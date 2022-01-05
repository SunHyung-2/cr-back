package com.amaranth10.cr.cra.cra1000.service.impl;

import com.amaranth10.cr.cra.cra1000.mapper.CRA1000Mapper;
import com.amaranth10.cr.cra.cra1000.model.*;
import com.amaranth10.cr.cra.cra1000.service.ICRA1000Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 진료 메인 Service
 */
@Service
public class CRA1000ServiceImpl implements ICRA1000Service {
    @Autowired
    CRA1000Mapper cra1000Mapper;

    /** CRA1010 환자현황 =========================================================================================================================================== */
    /** 환자현황 진료의 목록 조회 */
    @Override
    public List<Object> doctList(Object param) { return cra1000Mapper.doctList(param); }

    /** 환자현황 대기 환자수 조회 */
    @Override
    public Object patientCount(Object param) { return cra1000Mapper.patientCount(param); }

    /** 환자현황 대기 리스트 */
    @Override
    public List<Patient> patientList(Object param) { return cra1000Mapper.patientList(param); }
    /** ========================================================================================================================================================== */


    /** CRA1020 환자정보 =========================================================================================================================================== */
    /** 환자정보 접수정보 조회 */
    @Override
    public Object patientDetails(Object param) { return cra1000Mapper.patientDetails(param); }

    /** 관심환자 여부 수정 */
    @Transactional
    @Override
    public void updatePtCncn(Object param) { cra1000Mapper.updatePtCncn(param); }

    /** 접수메모 저장 및 수정 */
    @Transactional
    @Override
    public void patientRcpnMemo(Object param) { cra1000Mapper.patientRcpnMemo(param); }

    /** 진료메모 & 환자메모 저장 */
    @Transactional
    @Override
    public void saveClrPtMemo(Object param) { cra1000Mapper.saveClrPtMemo(param); }

    /** 진료메모 & 환자메모 수정 */
    @Transactional
    @Override
    public void updateClrPtMemo(Object param) { cra1000Mapper.updateClrPtMemo(param); }

    /** 환자정보 접수정보 수정 */
    @Transactional
    @Override
    public void updatePtRcpn(Object param) { cra1000Mapper.updatePtRcpn(param); }

    /** 보험구분 목록 조회 */
    @Override
    public List<Object> insnList(Object param) { return cra1000Mapper.insnList(param); }

    /** 초재진구분 목록 조회 */
    @Override
    public List<Object> fvnrList(Object param) { return cra1000Mapper.fvnrList(param); }

    /** 부서 목록 조회 */
    @Override
    public List<Object> depList(Object param) { return cra1000Mapper.depList(param); }

    /** 외래경로 목록 조회 */
    @Override
    public List<Object> pathList(Object param) { return cra1000Mapper.pathList(param); }

    /** 내원목적 목록 조회 */
    @Override
    public List<Object> prpsList(Object param) { return cra1000Mapper.prpsList(param); }
    /** ========================================================================================================================================================== */


    /** CRA1030 신체사정정보 / 검사결과 =============================================================================================================================== */
    /** 신체사정정보 조회 */
    @Override
    public List<Vital> vitalData(Object param) { return cra1000Mapper.vitalData(param); }

    /** 검사결과 조회 */
    @Override
    public List<Exam> examResult(Object param) { return cra1000Mapper.examResult(param); }
    /** ========================================================================================================================================================== */


    /** CRA1040 경과기록 =========================================================================================================================================== */
    /** 경과기록 리스트 조회 */
    @Override
    public List<Object> progressList(Object param) { return cra1000Mapper.progressList(param); }

    /** 경과기록 기본형 데이터 조회 */
    @Override
    public String progressData(Object param) { return cra1000Mapper.progressData(param); }

    /** 경과기록 SOAP 데이터 조회 */
    @Override
    public Object progressSOAPData(Object param) { return cra1000Mapper.progressSOAPData(param); }

    /** 경과기록 일련번호 체크 */
    @Override
    public Integer prgrSqnoCheck(Object param) { return cra1000Mapper.prgrSqnoCheck(param); }

    /** 경과기록 추가 */
    @Transactional
    @Override
    public void progressInsert(Object param) { cra1000Mapper.progressInsert(param); }

    /** 경과기록 수정 */
    @Transactional
    @Override
    public void progressUpdate(Object param) { cra1000Mapper.progressUpdate(param); }

    /** 경과기록 삭제 */
    @Transactional
    @Override
    public void progressDelete(Object param) { cra1000Mapper.progressDelete(param); }
    /** ========================================================================================================================================================== */


    /** CRA1050 처방조회 =========================================================================================================================================== */
    /** 과거기록 조회 */
    @Override
    public List<Reception> pastList(Object param) { return cra1000Mapper.pastList(param); }

    /** 경과기록 조회 */
    @Override
    public List<Progress> prgrList (Object param) { return cra1000Mapper.prgrList(param); }

    /** SLIP 목록 조회 */
    @Override
    public List<Slip> slipList(Object param) { return cra1000Mapper.slipList(param); }

    /** Slip 수가 목록 조회 */
    @Override
    public List<Prescription> slipPrscList(Object param) { return cra1000Mapper.slipPrscList(param); }
    /** ========================================================================================================================================================== */


    /** CRA1060 진단/처방 ========================================================================================================================================== */
    /** 진단 검색 목록 조회 */
    @Override
    public List<Diagnosis> dgnsMList(Object param) { return cra1000Mapper.dgnsMList(param); }

    /** 진단 내역 조회 */
    @Override
    public List<Diagnosis> dgnsList(Object param) { return cra1000Mapper.dgnsList(param); }

    /** 진단 저장 */
    @Transactional
    @Override
    public void savePtDgns(Object param) { cra1000Mapper.savePtDgns(param); }

    /** 진단 수정 */
    @Transactional
    @Override
    public void updatePtDgns(Object param) { cra1000Mapper.updatePtDgns(param); }

    /** 처방 검색 목록 조회 */
    @Override
    public List<Prescription> prscMList(Object param) { return cra1000Mapper.prscMList(param); }

    /** 처방 내역 조회 */
    @Override
    public List<Prescription> prscList(Object param) { return cra1000Mapper.prscList(param); }

    /** 처방 저장 */
    @Transactional
    @Override
    public void savePtPrsc(Object param) { cra1000Mapper.savePtPrsc(param); }

    /** 처방 수정 */
    @Transactional
    @Override
    public void updatePtPrsc(Object param) { cra1000Mapper.updatePtPrsc(param); }

    /** 의약분업예외 목록 조회 */
    @Override
    public List<Object> excpList(Object param) { return cra1000Mapper.excpList(param); }

    @Override
    public List<Object> iotmList(Object param) { return  cra1000Mapper.iotmList(param); }
    /** ========================================================================================================================================================== */

}
