package com.amaranth10.cr.cra.common.service.impl;

import com.amaranth10.backendcommon.util.model.APIResult;
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

    /** 환자정보 조회 */
    @Override
    public Patient patientInfo(Object param) {
        return craCommonMapper.patientInfo(param);
    }

    /** 감염리스트 조회 */
    @Override
    public List<Object> infList(Object param) {
        return craCommonMapper.infList(param);
    }

    /** 환자감염정보 조회 */
    @Override
    public List<Object> patientInf(Object param) {
        return craCommonMapper.patientInf(param);
    }

    /** 환자감염정보 추가 */
    @Transactional
    @Override
    public void infInsert(Object param){
        craCommonMapper.infInsert(param);
    }

    /** 환자감염정보 수정 */
    @Override
    public void infUpdate(Object param){
        craCommonMapper.infUpdate(param);
    }

    /** 환자알러지정보 조회 */
    @Override
    public String patientAlg(Object param) {
        return craCommonMapper.patientAlg(param);
    }

    /** 환자알러지정보 추가 */
    @Override
    public void algInsert(Object param){
        craCommonMapper.algInsert(param);
    }

    /** 환자알러지정보 수정 */
    @Override
    public void algUpdate(Object param){
        craCommonMapper.algUpdate(param);
    }

    /** 환자 접수상태 변경 */
    @Override
    public void updateRcpnStat(Object param){
        craCommonMapper.updateRcpnStat(param);
    }
}
