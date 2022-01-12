package com.amaranth10.cr.cra.common.model;
import lombok.Getter;
import lombok.Setter;

/**
 * 공통 환자정보
 */
@Getter
@Setter
public class Patient {
    private String hspt_cd; // 병원코드
    private String pid; // 등록번호
    private String pt_nm; // 등록번호
    private String sex_cd; // 성별
    private String age; // 나이
    private String inf_cnt; // 감염 갯수
    private String alg_info; // 알러지 정보

    private String dobr; // 생년월일
}
