package com.amaranth10.cr.cra.common.mapper;

import com.amaranth10.cr.cra.common.model.Diagnosis;
import com.amaranth10.cr.cra.common.model.Patient;
import com.amaranth10.cr.cra.common.model.Prescription;
import com.amaranth10.cr.cra.common.model.Reception;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 진료 공통 Mapper
 */
@Mapper
public interface CRACommonMapper {
    /** 환자 접수상태 변경 */
    void updateRcpnStat(Object param);

    /** 환자 검색목록 조회 */
    List<Patient> searchPtList (Object param);

    /** 환자기록 목록 조회 */
    List<Reception> rcpnList (Object param);

    /** 환자기록 진단 목록 조회 */
    List<Diagnosis> pastDgns (Object param);

    /** 환자기록 처방 목록 조회 */
    List<Prescription> pastPrsc (Object param);
}