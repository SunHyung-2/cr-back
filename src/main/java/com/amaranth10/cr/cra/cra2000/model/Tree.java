package com.amaranth10.cr.cra.cra2000.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tree {
    private String parent; // 부모 코드
    private String code; // 상용구 코드
    private String name; // 상용구 명칭
}
