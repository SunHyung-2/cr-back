package com.amaranth10.cr.cra.common.controller;

import com.amaranth10.cr.cra.common.model.Diagnosis;
import com.amaranth10.cr.cra.common.model.Patient;
import com.amaranth10.cr.cra.common.model.Prescription;
import com.amaranth10.cr.cra.common.model.Reception;
import com.amaranth10.cr.cra.common.service.ICRACommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /** 환자기록 목록 조회 */
    @PostMapping("/rcpnList")
    public Object rcpnList(@RequestBody Object param) { return this.iCRACommonService.rcpnList(param); };

    /** 환자기록 진단 목록 조회 */
    @PostMapping("/pastDgns")
    public Object pastDgns (@RequestBody Object param) { return this.iCRACommonService.pastDgns(param); };

    /** 환자기록 처방 목록 조회 */
    @PostMapping("/pastPrsc")
   public Object pastPrsc (@RequestBody Object param) { return this.iCRACommonService.pastPrsc(param); };

}
