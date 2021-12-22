package com.amaranth10.cr.cra.cra3000.service.impl;

import com.amaranth10.cr.cra.cra3000.mapper.CRA3000Mapper;
import com.amaranth10.cr.cra.cra3000.service.ICRA3000Service;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CRA3000ServiceImpl implements ICRA3000Service {
    @Autowired
    CRA3000Mapper cra3000Mapper;

    @Autowired
    private CRA3000ServiceImpl CRA3000ServiceImpl;
}
