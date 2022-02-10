package com.amaranth10.cr.cra.cra3000.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetPrsc {
    private String set_prsc_uprn_sqno; // 약속처방 상위 일련번호
    private String set_prsc_sqno; // 약속처방 일련번호
    private String set_prsc_nm; // 약속처방 명칭
    private String depth; // 약속처방 경로
}
