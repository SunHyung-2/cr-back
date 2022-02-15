package com.amaranth10.cr.cra.cra2000.service.impl;

import com.amaranth10.cr.cra.cra2000.mapper.CRA2000Mapper;
import com.amaranth10.cr.cra.cra2000.service.ICRA2000Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 진료 메인 Service
 */
@Service
public class CRA2000ServiceImpl implements ICRA2000Service {
    @Autowired
    CRA2000Mapper cra2000Mapper;

}
