package com.amaranth10.cr.cra.cra3000.mapper;

import com.amaranth10.cr.cra.cra1000.model.Diagnosis;
import com.amaranth10.cr.cra.cra1000.model.Prescription;
import com.amaranth10.cr.cra.cra3000.model.SetPrsc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CRA3000Mapper {
    /** 약속처방 목록 -------------------------------------------------------------------------------------------------------------------------------------  */
    List<SetPrsc> setList (Object param);

    /** 약속처방 검색 목록 -------------------------------------------------------------------------------------------------------------------------------------  */
    List<SetPrsc> searchSetList (Object param);

    /** 약속처방 진단 상세 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    List<Diagnosis> setDgnsList (Object param);

    /** 약속처방 처방 상세 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    List<Prescription> setPrscList (Object param);
}
