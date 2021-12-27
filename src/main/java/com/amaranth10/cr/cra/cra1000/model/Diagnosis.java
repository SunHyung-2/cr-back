package com.amaranth10.cr.cra.cra1000.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Diagnosis {
    private String dgns_cd; // 진단 코드
    private String dgns_nm; // 진단명
    private String dgns_enm; // 진단 영문명
    private String spcf_rgno; // 특정기호
    private String dgns_sqno; // 진단 일련번호
    private String dvsn; // 형태
    private String ro_yn; // R/O 여부
    private String site_dvcd; // 부위

//    private String[] dgnsList;
}
