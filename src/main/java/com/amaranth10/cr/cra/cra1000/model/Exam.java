package com.amaranth10.cr.cra.cra1000.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 진료 검사결과
 */
@Getter
@Setter
public class Exam {
    private String hspt_cd; // 병원코드
    private String pid; // 등록번호
    private String exmn_date; // 검사일
    private String prsc_prgr_stat_cd; // 처방진행상태코드 M(실시), N(보고)
    private String exmn_cd; // 검사코드
    private String prsc_nm; // 처방명
    private String exmn_rslt1; // 검사결과
    private String nots_low; // 참고사항
    private String nots_high; // 참고사항
    private String prsc_sqno; // 처방순번
}
