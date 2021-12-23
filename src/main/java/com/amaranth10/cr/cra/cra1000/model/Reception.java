package com.amaranth10.cr.cra.cra1000.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 진료 메인 Model
 */
@Getter
@Setter
public class Reception {
    private String hspt_cd; // 병원코드
    private String pid; // 등록번호
    private String mdcr_date; // 진료일
    private String mdcr_hm; // 진료시간
    private String call_patient; // 호출
    private String insn_tycd; // 보험구분
    private String fvnr_dvcd; // 초재진구분
    private String mdcr_dr_id; // 진료의
    private String mddp_cd; // 진료과
    private String rcpn_sqno; // 접수 일련번호
    private String type_asst_cd; // 유형보조코드
    private String rcpn_memo; // 접수메모
    private String cmhs_path_cd; // 내원경로코드
}
