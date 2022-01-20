package com.amaranth10.cr.cra.cra2000.mapper;

import com.amaranth10.cr.cra.cra2000.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 진료 상용구 Mapper
 */
@Mapper
public interface CRA2000Mapper {
    /** 상용구 분류 조회 */
    List<Tree> blpeList (Object param);
}
