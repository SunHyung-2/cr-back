package com.amaranth10.cr.cra.cra3000.mapper;

import com.amaranth10.cr.cra.cra3000.model.SetPrsc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CRA3000Mapper {
    /** 약속처방 목록 -------------------------------------------------------------------------------------------------------------------------------------  */
    List<SetPrsc> setPrscList (Object param);
}
