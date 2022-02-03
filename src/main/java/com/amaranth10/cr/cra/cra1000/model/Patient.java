package com.amaranth10.cr.cra.cra1000.model;

import lombok.Getter;
import lombok.Setter;

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
    private String rcpn_stat_nm; // 접수상태명
    private String mdcr_hm; // 진료시간
    private String sex; // 성별
    private String age; // 나이
    private String call_patient; // 호출
    private String insn_tycd; // 보험구분
    private String insn_tycd_nm;
    private String fvnr_dvcd; // 초재진구분
    private String fvnr_dvcd_nm;
    private String mdcr_dr_id; // 진료의
    private String mddp_cd; // 진료과
    private String rcpn_sqno; // 접수 일련번호
    private String hstr_sqno; // 이력일련번호

    private String pt_frrn; // 주민등록앞번호
    private String pt_srrn; // 주민등록뒷번호
    private String dobr; // 생년월일
    private String cntc_tel; // 연락전화번호
    private String clph_no; // 휴대폰번호
    private String pstl_no; // 우편번호
    private String basc_addr; // 기본주소
    private String detl_addr; // 상세주소
    private String vip_pt_yn; // vip 환자 여부
    private String cncn_pt_yn; // 관심 환자 여부
    private String priv_pt_yn; // 사생활 보호 환자 여부
    private String cmhs_path_dvcd; // 내원경로코드
    private String cmhs_path_cd_nm;

    private String type_asst_cd; // 유형보조코드
    private String type_asst_cd_nm;
    private String rcpn_memo; // 접수메모
    private String cmhs_prps_cd; // 내원목적코드

    private String clr_dvsn; // 메모진료 구분자
    private String clr_cnts; // 진료메모 내용
    private String pat_dvsn; // 환자메모 구분자
    private String pat_cnts; // 환재메모 내용
}
