package com.amaranth10.cr.cra.cra2000.service;

import com.amaranth10.cr.cra.cra2000.model.*;
import java.util.List;

/**
 * 진료 상용구 Service interface
 */
public interface ICRA2000Service {
    /** 상용구 분류 조회 */
    List<Tree> blpeList(Object param);
}