package com.amaranth10.cr.cra.cra1000.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Slip {
    private String slip_cd; // slip코드
    private String slip_nm; // slip명
    private String slip_uprn_clsf_cd; // 상위Slip분류코드
}
