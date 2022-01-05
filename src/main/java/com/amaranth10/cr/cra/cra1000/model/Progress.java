package com.amaranth10.cr.cra.cra1000.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Progress {
    private String prgr_sqno; // 경과기록 일련번호
    private String rcpn_sqno; // 접수일련번호
    private String prgr_rcrd; // 경과기록
    private String sbjt_cnts; // Subjective
    private String objt_cnts; // Objective
    private String asss_cnts; // Assessment
    private String plan; // Plan
}
