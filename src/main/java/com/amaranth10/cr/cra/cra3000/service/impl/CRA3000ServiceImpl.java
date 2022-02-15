package com.amaranth10.cr.cra.cra3000.service.impl;

import com.amaranth10.cr.cra.cra3000.mapper.CRA3000Mapper;
import com.amaranth10.cr.cra.cra3000.service.ICRA3000Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 약속처방 Service
 */
@Service
public class CRA3000ServiceImpl implements ICRA3000Service {
    @Autowired
    CRA3000Mapper cra3000Mapper;

}
