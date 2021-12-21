package com.amaranth10.cr.cra.common.service.impl;

import com.amaranth10.cr.cra.common.service.ICRACommonService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Service;

/**
 * 진료 공통 Service
 */
@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CRACommonServiceImpl implements ICRACommonService {

}
