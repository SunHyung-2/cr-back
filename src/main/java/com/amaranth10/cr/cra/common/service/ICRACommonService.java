package com.amaranth10.cr.cra.common.service;

import com.amaranth10.cr.cra.common.model.Diagnosis;
import com.amaranth10.cr.cra.common.model.Patient;
import com.amaranth10.cr.cra.common.model.Prescription;
import com.amaranth10.cr.cra.common.model.Reception;

import java.util.List;

/**
 * 진료 공통 Service interface
 */
public interface ICRACommonService {
    /** 환자정보 조회 */
    Patient patientInfo(Object param);

    /** 감염리스트 조회 */
    List<Object> infList(Object param);

    /** 환자감염정보 조회 */
    List<Object> patientInf(Object param);

    /** 환자감염정보 추가 */
    void infInsert(Object param);

    /** 환자감염정보 수정 */
    void infUpdate(Object param);

    /** 환자감염정보 삭제 */
    void infDelete(Object param);

    /** 환자알러지정보 조회 */
    String patientAlg(Object param);

    /** 환자알러지정보 추가 */
    void algInsert(Object param);

    /** 환자알러지정보 수정 */
    void algUpdate(Object param);

    /** 환자 접수상태 변경 */
    void updateRcpnStat(Object param);

    /** 환자 검색목록 조회 */
    List<Patient> searchPtList(Object param);

    /** 환자기록 목록 조회 */
    List<Reception> rcpnList(Object param);

    /** 환자기록 진단 목록 조회 */
    List<Diagnosis> pastDgns (Object param);

    /** 환자기록 처방 목록 조회 */
    List<Prescription> pastPrsc (Object param);

}