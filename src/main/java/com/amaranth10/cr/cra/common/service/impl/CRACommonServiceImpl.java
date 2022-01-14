package com.amaranth10.cr.cra.common.service.impl;

import com.amaranth10.cr.cra.common.mapper.CRACommonMapper;
import com.amaranth10.cr.cra.common.model.Diagnosis;
import com.amaranth10.cr.cra.common.model.Patient;
import com.amaranth10.cr.cra.common.model.Prescription;
import com.amaranth10.cr.cra.common.model.Reception;
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

    /** 환자기록 목록 조회 */
    @Override
    public List<Reception> rcpnList(Object param) { return craCommonMapper.rcpnList(param); };

    /** 환자기록 진단 목록 조회 */
    @Override
    public List<Diagnosis> pastDgns (Object param) { return craCommonMapper.pastDgns(param); };

    /** 환자기록 처방 목록 조회 */
    @Override
    public List<Prescription> pastPrsc (Object param) { return craCommonMapper.pastPrsc(param); };

}
