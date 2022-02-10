package com.amaranth10.cr.cra.cra3000.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prescription {
    private String set_prsc_sqno; // 약속처방 일련번호
    private String prsc_cd; // 처방코드
//    private String prsc_inpt_dt; // 처방입력일시
//    private String prsc_dr_id; // 처방의
    private String prsc_nm; // 처방명
    private String prsc_sqno; // 처방일련번호
    private String prsc_clsf_cd; // 처방분류코드
//    private String slip_cd; // SLIP코드
//    private String drug_injc_dvsn; // 약주사구분
//    private String pwdr_yn; // powder여부
    private String mix_no; // MIX번호
    private String mix_yn; // MIX여부
    private String iotm_cd; // 용법코드
//    private String basc_aomd_uncd; //기본투여단위코드
//    private String spcm_cd_1; // 검체코드
//    private String spcm_ctnr_cd_1; // 검체용기코드
//    private String exrm_cd; // 검사실 코드
//    private String uncd; //함량단위코드
    private String dosg_1; // 1회량
    private String notm; // 횟수
    private String nody; // 일수
    private String prsc_pay_dvcd; // 처방급여구분코드
    private String prsc_pay_dvcd_nm; // 처방급여구분코드명칭
    private String hsin_hsot_dvcd; // 원내/원외구분코드
    private String hsin_prsc_resn_cd; // 원내처방사유코드
//    private String cmpt_yn; // 산정여부
//    private String prsc_memo; // 처방메모
//    private String jx999; // jx999
//    private String dc_yn; // dc여부
//    private String dc_resn; // dc 사유
//    private String dc_resn_cd; // dc 사유 코드
//    private String apnt_yn; // 예약여부
//    private String prsc_prgr_stat_cd; // 처방진행상태코드
}
