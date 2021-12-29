package com.amaranth10.cr.cra.cra1000.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 진료 신체사정
 */
@Getter
@Setter
public class Vital {
    private String hspt_cd; // 병원코드
    private String pid; // 등록번호
    private String inpt_dt; // 입력일
    private String sbp; // 수축기 혈압
    private String dbp; // 이완기 혈압
    private String pr; // 맥박
    private String rr; // 호흡
    private String bt; // 체온
    private String fbs; // 혈당
    private String hght; // 신장
    private String wght; // 체중
    private String bmi; // BMI
}
