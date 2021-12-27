package com.amaranth10.cr.cra.common.service.impl;

import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.cr.cra.common.mapper.CRACommonMapper;
import com.amaranth10.cr.cra.common.service.ICRACommonService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 진료 공통 Service
 */
@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CRACommonServiceImpl implements ICRACommonService {
    @Autowired
    CRACommonMapper craCommonMapper;

    @Autowired
    private CRACommonServiceImpl craCommonServiceImpl;

    /** 환자 접수상태 변경 */
    @Override
    public APIResult updateRcpnStat(@RequestBody Object param){
        craCommonMapper.updateRcpnStat(param);
        return null;
    }
}
