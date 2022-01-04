package com.amaranth10.cr.cra.cra3000.service;

import com.amaranth10.cr.cra.cra3000.model.*;
import com.amaranth10.cr.cra.cra1000.model.*;

import java.util.List;

public interface ICRA3000Service {
    /** 약속처방 목록 조회 */
    List<SetPrsc> setList(Object param);

    /** 약속처방 검색 목록 */
    List<SetPrsc> searchSetList(Object param);

    /** 약속처방 진단 상세 조회 */
    List<Diagnosis> setDgnsList(Object param);

    /** 약속처방 처방 상세 조회 */
    List<Prescription> setPrscList(Object param);
}
