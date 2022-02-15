package com.amaranth10.cr.cra.common.service;

import com.amaranth10.cr.cra.common.model.Patient;

import java.util.List;

/**
 * 진료 공통 Service interface
 */
public interface ICRACommonService {

    /** 환자 접수상태 변경 */
    void updateRcpnStat(Object param);

    /** 환자 검색목록 조회 */
    List<Patient> searchPtList(Object param);

}