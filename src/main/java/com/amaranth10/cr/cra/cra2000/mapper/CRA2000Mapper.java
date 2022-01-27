package com.amaranth10.cr.cra.cra2000.mapper;

import com.amaranth10.cr.cra.cra2000.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 진료 상용구 Mapper
 */
@Mapper
public interface CRA2000Mapper {
    /** 상용구 목록 조회 */
    List<Tree> blpeList (Object param);

    /** 상용구 목록 검색 */
    List<Tree> searchBlpe (Object param);

    /** 상용구 삭제 */
    void deleteBlpe (Object param);

    /** 상용구 분류 DropDownList 조회 */
    List<Object> comBlpeList (Object param);

    /** 상용구 상세 조회 */
    Tree blpeDetail (Object param);

    /** 상용구 추가 */
    void insertBlpe (Object param);

    /** 상용구 수정 */
    void updateBlpe (Object param);
}
