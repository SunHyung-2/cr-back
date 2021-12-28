package com.amaranth10.cr.cra.common.mapper;

import com.amaranth10.cr.cra.common.model.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 진료 공통 Mapper
 */
@Mapper
public interface CRACommonMapper {
    /** 환자정보 조회 */
    Patient patientInfo (Object param);

    /** 환자감염정보 조회 */
    List<Object> patientInf (Object param);

    /** 환자 접수상태 변경 */
    void updateRcpnStat(Object param);
}