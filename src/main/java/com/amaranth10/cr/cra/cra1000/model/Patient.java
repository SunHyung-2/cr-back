package com.amaranth10.cr.cra.cra1000.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Array;
import java.util.Map;

/**
 * 진료 메인 Model
 */
@Getter
@Setter
public class Patient {
    private String hspt_cd; // 병원코드
    private String pid; // 등록번호
    private String pt_nm; // 환자명
    private String mdcr_date; // 진료일
    private String rcpn_stat_cd; // 접수상태
    private String mdcr_hm; // 진료시간
    private String sex; // 성별
    private String age; // 나이
    private String call_patient; // 호출
    private String insn_tycd; // 보험구분
    private String fvnr_dvcd; // 초재진구분
    private String mdcr_dr_id; // 진료의
    private String mddp_cd; // 진료과
    private String rcpn_sqno; // 접수 일련번호

    private  Map<String, Object> rcpn_stat_list; // 상태
    private String Rcount; // 대기 환자 Count
    private String Wcount; // 보류 환자 Count
    private String Vcount; // 예약 환자 Count
    private String Dcount; // 완료 환자 Count
    private String Acount; // 전체 환자 Count

}
