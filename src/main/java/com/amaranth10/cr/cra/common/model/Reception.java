package com.amaranth10.cr.cra.common.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reception {
    private String rcpn_sqno; // 접수일련번호
    private String mdcr_date; // 진료일자
    private String mdcr_dr_id; // 진료의사
    private String mddp_cd; // 진료과
    private String fvnr_dvcd; // 초재진구분코드
    private String insn_tycd; // 보험유형
}
