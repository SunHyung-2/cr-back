package com.amaranth10.cr.cra.common.controller;

import com.amaranth10.cr.cra.common.service.ICRACommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 진료 공통 Controller
 */
@RestController
public class CRACommonController {
    @Autowired
    private ICRACommonService iCRACommonService;

    /** 환자 접수상태 변경 */
    @PostMapping("/updateRcpnStat")
    public void updateRcpnStat (@RequestBody Object param) {
        this.iCRACommonService.updateRcpnStat(param);
    }

    /** 환자 검색목록 조회 */
    @PostMapping("/searchPtList")
    public Object searchPtList(@RequestBody Object param) { return this.iCRACommonService.searchPtList(param); };

}
