package com.amaranth10.cr.cra.cra3000.service.impl;

import com.amaranth10.cr.cra.cra3000.mapper.CRA3000Mapper;
import com.amaranth10.cr.cra.cra3000.model.*;
import com.amaranth10.cr.cra.cra1000.model.*;
import com.amaranth10.cr.cra.cra3000.service.ICRA3000Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CRA3000ServiceImpl implements ICRA3000Service {
    @Autowired
    CRA3000Mapper cra3000Mapper;

    /** 약속처방 목록 조회 */
    @Override
    public List<SetPrsc> setList(Object param) { return cra3000Mapper.setList(param); }

    /** 약속처방 검색 목록 조회 */
    @Override
    public List<SetPrsc> searchSetList(Object param) { return cra3000Mapper.searchSetList(param); }

    /** 약속처방 진단 상세 조회 */
    @Override
    public List<Diagnosis> setDgnsList(Object param) { return cra3000Mapper.setDgnsList(param); }

    /** 약속처방 처방 상세 조회 */
    @Override
    public List<Prescription> setPrscList(Object param) { return cra3000Mapper.setPrscList(param); }

}
