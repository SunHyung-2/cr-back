package com.amaranth10.cr.mapper;

import com.amaranth10.cr.model.CrModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 진료 Mapper
 */
@Mapper
public interface CrMapper {
    /** 조회 TEST */
    List<CrModel> testData ();
}
