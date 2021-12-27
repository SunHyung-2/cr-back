package com.amaranth10.cr.cra.common.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 진료 공통 Mapper
 */
@Mapper
public interface CRACommonMapper {
    /** 환자 접수상태 변경 */
    void updateRcpnStat(Object param);
}