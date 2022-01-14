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