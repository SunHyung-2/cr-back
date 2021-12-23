package com.amaranth10.cr.cra.cra1000.mapper;

import com.amaranth10.cr.cra.cra1000.model.CRA1000Model;
import com.amaranth10.cr.cra.cra1000.model.Patient;
import com.amaranth10.cr.cra.cra1000.model.Prescription;
import com.amaranth10.cr.cra.cra1000.model.Slip;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 진료 메인 Mapper
 */
@Mapper
public interface CRA1000Mapper {
    /** 조회 TEST */
    List<CRA1000Model> testData ();

    /** CLRS0101 환자현황 ========================================================================================================================================== */
    /** 환자현황 대기 환자수 조회 -------------------------------------------------------------------------------------------------------------------------------------- */
    Object patientCount (Object param);

    /** 환자현황 대기 리스트 ------------------------------------------------------------------------------------------------------------------------------------------ */
    List<Patient> patientList (Object param) ;
    /** ========================================================================================================================================================== */


    /** CLRS0102 환자정보 ========================================================================================================================================== */
    /** 환자정보 접수정보 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    Object patientDetails (Object param);

    /** 관심환자 여부 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    void updatePtCncn (Object param);

    /** 접수메모 저장 및 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    void patientRcpnMemo(Object param);

    /** ========================================================================================================================================================== */


    /** CLRS0103 신체사정정보 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0104 검사결과 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0105 경과기록 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0106 처방조회 ========================================================================================================================================== */
    /** SLIP 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    List<Slip> slipList (Object param);

    /** SLIP 수가 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    List<Prescription> slipPrscList (Object param);
    /** ========================================================================================================================================================== */


    /** CLRS0107 진단 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0108 처방 ========================================================================================================================================== */
    /** 처방 검색 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    List<Prescription> prscMList (Object param);
    /** ========================================================================================================================================================== */

}
