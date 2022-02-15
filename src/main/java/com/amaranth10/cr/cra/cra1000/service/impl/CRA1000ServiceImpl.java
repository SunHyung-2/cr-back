package com.amaranth10.cr.cra.cra1000.service.impl;

import com.amaranth10.cr.cra.cra1000.mapper.CRA1000Mapper;
import com.amaranth10.cr.cra.cra1000.service.ICRA1000Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 진료 메인 Service
 */
@Service
public class CRA1000ServiceImpl implements ICRA1000Service {
    @Autowired
    CRA1000Mapper cra1000Mapper;

}
