package com.amaranth10.cr.cra.cra1000.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prescription {
    private String prsc_cd; // 처방코드
    private String prsc_nm; // 처방명
    private String prsc_sqno; // 처방일련번호
    private String prsc_clsf_cd; // 처방분류코드
    private String slip_cd; // SLIP코드
    private String drug_injc_dvsn; // 약주사구분
    private String pwdr_yn; // powder여부
    private String mix_no; // MIX번호
    private String iotm_cd; // 용법코드
    private String inpy_dvcd; // 보험급여구분코드
    private String basc_aomd_uncd; //기본투여단위코드
    private String spcm_cd_1; // 검체코드
    private String exrm_cd; // 검사실 코드
    private String uncd; //함량단위코드
    private String dosg_1; // 1회량
    private String notm; // 횟수
    private String nody; // 일수
    private String hsin_hsot_dvcd; // 원내/원외구분코드
    private String hsin_prsc_resn_cd; // 원내처방사유코드
    private String cmpt_yn; // 산정여부
    private String prsc_memo; // 처방메모
    private String jx999; // jx999
    private String dc_yn; // dc여부
    private String dc_resn; // dc 사유
    private String dc_resn_cd; // dc 사유 코드
}
