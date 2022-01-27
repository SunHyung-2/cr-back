package com.amaranth10.cr.cra.cra2000.service.impl;

import com.amaranth10.cr.cra.cra2000.model.*;
import com.amaranth10.cr.cra.cra2000.mapper.CRA2000Mapper;
import com.amaranth10.cr.cra.cra2000.service.ICRA2000Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 진료 메인 Service
 */
@Service
public class CRA2000ServiceImpl implements ICRA2000Service {
    @Autowired
    CRA2000Mapper cra2000Mapper;

    /** 상용구 목록 조회 */
    @Override
    public List<Tree> blpeList(Object param) { return cra2000Mapper.blpeList(param); }

    /** 상용구 목록 검색 */
    @Override
    public List<Tree> searchBlpe(Object param) { return cra2000Mapper.searchBlpe(param); }

    /** 상용구 삭제 */
    @Transactional
    @Override
    public void deleteBlpe(Object param) { cra2000Mapper.deleteBlpe(param); }

    /** 상용구 분류 DropDownList 조회 */
    @Override
    public List<Object> comBlpeList(Object param) { return cra2000Mapper.comBlpeList(param); }

    /** 상용구 상세 조회 */
    @Override
    public Tree blpeDetail(Object param) { return cra2000Mapper.blpeDetail(param); }

    /** 상용구 추가 */
    @Transactional
    @Override
    public void insertBlpe(Object param) { cra2000Mapper.insertBlpe(param); }

    /** 상용구 수정 */
    @Transactional
    @Override
    public void updateBlpe(Object param) { cra2000Mapper.updateBlpe(param); }
}
