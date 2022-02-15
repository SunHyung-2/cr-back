package com.amaranth10.cr.cra.common.service.impl;

import com.amaranth10.cr.cra.common.mapper.CRACommonMapper;
import com.amaranth10.cr.cra.common.model.Patient;
import com.amaranth10.cr.cra.common.service.ICRACommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 진료 공통 Service
 */
@Service
public class CRACommonServiceImpl implements ICRACommonService {
    @Autowired
    CRACommonMapper craCommonMapper;

    /** 환자 접수상태 변경 */
    @Transactional
    @Override
    public void updateRcpnStat(Object param){ craCommonMapper.updateRcpnStat(param); }

    /** 환자 검색목록 조회 */
    @Override
    public List<Patient> searchPtList(Object param) { return craCommonMapper.searchPtList(param); };

}
