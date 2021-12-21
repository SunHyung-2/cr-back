package com.amaranth10.cr.cra.cra1000.mapper;

import com.amaranth10.cr.cra.cra1000.model.CRA1000Model;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 진료 메인 Mapper
 */
@Mapper
public interface CRA1000Mapper {
    /** 조회 TEST */
    List<CRA1000Model> testData ();
}
