package com.amaranth10.cr.cra.cra3000.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Diagnosis {
    private String set_prsc_sqno; // 약속처방 일련번호
    private String dgns_cd; // 진단 코드
    private String dgns_nm; // 진단명
//    private String spcf_rgno; // 특정기호
    private String dgns_sqno; // 진단 일련번호
//    private String dvsn; // 형태
//    private String ro_yn; // R/O 여부
    private String site_dvcd; // 부위

//    private String main_ilns_use_yn; // 주상병사용구분
//    private String sex_cd; // 성별구분
//    private String uplm_age; // 상한연령
//    private String lwlm_age; // 하한연령
}
