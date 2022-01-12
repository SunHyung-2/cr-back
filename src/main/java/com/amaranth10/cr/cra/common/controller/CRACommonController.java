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

    /** 환자정보 조회 */
    @PostMapping("/patientInfo")
    public Object patientInfo (@RequestBody Object param) { return this.iCRACommonService.patientInfo(param); }

    /** 감염리스트 조회 */
    @PostMapping("/infList")
    public Object infList (@RequestBody Object param) { return this.iCRACommonService.infList(param); }

    /** 환자감염정보 조회 */
    @PostMapping("/patientInf")
    public Object patientInf (@RequestBody Object param) { return this.iCRACommonService.patientInf(param); };

    /** 환자감염정보 추가 */
    @PostMapping("/infInsert")
    public void infInsert (@RequestBody Object param) { this.iCRACommonService.infInsert(param); }

    /** 환자감염정보 수정 */
    @PostMapping("/infUpdate")
    public void infUpdate (@RequestBody Object param) {
        this.iCRACommonService.infUpdate(param);
    }

    /** 환자감염정보 수정 */
    @PostMapping("/infDelete")
    public void infDelete (@RequestBody Object param) {
        this.iCRACommonService.infDelete(param);
    }

    /** 환자알러지정보 조회 */
    @PostMapping("/patientAlg")
    public Object patientAlg (@RequestBody Object param) {
        return this.iCRACommonService.patientAlg(param);
    };

    /** 환자알러지정보 추가 */
    @PostMapping("/algInsert")
    public void algInsert (@RequestBody Object param) {
        this.iCRACommonService.algInsert(param);
    }

    /** 환자알러지정보 수정 */
    @PostMapping("/algUpdate")
    public void algUpdate (@RequestBody Object param) {
        this.iCRACommonService.algUpdate(param);
    }

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
