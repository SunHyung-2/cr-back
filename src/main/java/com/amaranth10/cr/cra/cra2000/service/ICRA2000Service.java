package com.amaranth10.cr.cra.cra2000.service;

import java.util.List;

/**
 * 진료 상용구 Service interface
 */
public interface ICRA2000Service {
    /** 상용구 분류 조회 */
    List<Object> blpeList(Object param);
}