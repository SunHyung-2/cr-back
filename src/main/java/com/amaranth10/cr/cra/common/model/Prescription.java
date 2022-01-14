package com.amaranth10.cr.cra.common.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prescription {
    private String prsc_cd; // 처방코드
    private String prsc_nm; // 처방명
    private String mix_no; // MIX번호
    private String iotm_cd; // 용법코드여구분코드
    private String dosg_1; // 1회량
    private String notm; // 횟수
    private String nody; // 일수
    private String prsc_pay_dvcd; // 처방급여구분코드
    private String hsin_hsot_dvcd; // 원내/원외구분코드
    private String prsc_prgr_stat_cd; // 처방진행상태코드
    private String rcpt_stat_cd; // 수납상태코드
    private String cmpt_yn; // 산정여부
    private String prsc_memo; // 처방메모
    private String jx999; // jx999
    private String dc_yn; // dc여부
    private String dc_resn_cd; // dc사유코드
    private String dc_resn; // dc사유
}
