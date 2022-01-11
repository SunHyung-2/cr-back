package com.amaranth10.cr.cra.common.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Diagnosis {
    private String dgns_cd; // 진단 코드
    private String dgns_nm; // 진단명
    private String dvsn; // 형태
}
