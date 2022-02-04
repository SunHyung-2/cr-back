package com.amaranth10.cr.cra.cra1000.controller;

import com.amaranth10.cr.cra.cra1000.service.ICRA1000Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 진료 메인 Controller
 */
@RestController
public class CRA1000Controller {
    @Autowired
    private ICRA1000Service iCRA1000Service;

    /** CRA1010 환자현황 =========================================================================================================================================== */
    /** 환자현황 진료의 목록 조회 */
    @PostMapping("/doctList")
    public Object doctList (@RequestBody Object param) {
        return this.iCRA1000Service.doctList(param);
    };

    /** 접수상태코드 목록 조회 */
    @PostMapping("/rcpnStatList")
    public Object rcpnStatList (@RequestBody Object param) {
        return this.iCRA1000Service.rcpnStatList(param);
    };

    /** 환자현황 대기 환자수 조회 */
    @PostMapping("/patientCount")
    public Object patientCount (@RequestBody Object param) {
        return this.iCRA1000Service.patientCount(param);
    };

    /** 환자현황 대기 리스트 */
    @PostMapping("/patientList")
    public Object patientList (@RequestBody Object param) {
        return this.iCRA1000Service.patientList(param);
    };
    /** ========================================================================================================================================================== */


    /** CRA1020 환자정보 =========================================================================================================================================== */
    /** 환자정보 접수정보 조회 */
    @PostMapping("/patientDetails")
    public Object patientDetails (@RequestBody Object param) {
        return this.iCRA1000Service.patientDetails(param);
    };

    /** 환자 만성질환 조회 */
    @PostMapping("/ptCfsc")
    public Object ptCfsc (@RequestBody Object param) { return this.iCRA1000Service.ptCfsc(param); }
    @PostMapping("/ptChrn")
    public Object ptChrn (@RequestBody Object param) { return this.iCRA1000Service.ptChrn(param); }

    /** 관심환자 여부 수정 */
    @PostMapping("/updatePtCncn")
    public void updatePtCncn (@RequestBody Object param) {
        this.iCRA1000Service.updatePtCncn(param);
    }

    /** 접수메모 저장 및 수정 */
    @PostMapping("/patientRcpnMemo")
    public void patientRcpnMemo (@RequestBody Object param) {
        this.iCRA1000Service.patientRcpnMemo(param);
    }

    /** 진료메모 & 환자메모 저장 */
    @PostMapping("/saveClrPtMemo")
    public void saveClrPtMemo (@RequestBody Object param) {
        this.iCRA1000Service.saveClrPtMemo(param);
    }

    /** 진료메모 & 환자메모 수정 */
    @PostMapping("/updateClrPtMemo")
    public void updateClrPtMemo (@RequestBody Object param) { this.iCRA1000Service.updateClrPtMemo(param); }

    /** 환자정보 수정 */
    @PostMapping("/updatePtRcpn")
    public void updatePtRcpn (@RequestBody Object param) { this.iCRA1000Service.updatePtRcpn(param); }

    /** 접수정보 수정 */
    @PostMapping("/saveRcpn")
    public void saveRcpn (@RequestBody Object param) { this.iCRA1000Service.saveRcpn(param); }

    /** 만성질환 수정 */
    @PostMapping("/updateCfsc")
    public void updateCfsc (@RequestBody Object param) { this.iCRA1000Service.updateCfsc(param); }
    @PostMapping("/saveCfsc")
    public void saveCfsc (@RequestBody Object param) { this.iCRA1000Service.saveCfsc(param); }

    /** 보험구분 목록 조회 */
    @PostMapping("/insnList")
    public Object insnList (@RequestBody Object param) {
        return this.iCRA1000Service.insnList(param);
    }

    /** 초재진구분 목록 조회 */
    @PostMapping("/fvnrList")
    public Object fvnrList (@RequestBody Object param) {
        return this.iCRA1000Service.fvnrList(param);
    }

    /** 부서 목록 조회 */
    @PostMapping("/depList")
    public Object depList (@RequestBody Object param) { return this.iCRA1000Service.depList(param); }

    /** 외래경로 목록 조회 */
    @PostMapping("/pathList")
    public Object pathList (@RequestBody Object param) {
        return this.iCRA1000Service.pathList(param);
    }

    /** 내원목적 목록 조회 */
    @PostMapping("/prpsList")
    public Object prpsList (@RequestBody Object param) {
        return this.iCRA1000Service.prpsList(param);
    }

    /** 산정특례구분코드 목록 조회 */
    @PostMapping("/cfscDvcdList")
    public Object cfscDvcdList (@RequestBody Object param) { return this.iCRA1000Service.cfscDvcdList(param); }
    /** ========================================================================================================================================================== */


    /** CRA1030 신체사정정보 / 검사결과 =============================================================================================================================== */
    /** 신체사정정보 조회 */
    @PostMapping("/vitalData")
    public Object vitalData (@RequestBody Object param) {
        return this.iCRA1000Service.vitalData(param);
    }

    /** 신체사정그래프 데이터 조회 */
    @PostMapping("/vitalGraphData")
    public Object vitalGraphData (@RequestBody Object param) {
        return this.iCRA1000Service.vitalGraphData(param);
    }

    /** 신체사정 참고치 데이터 */
    @PostMapping("/vitalReferData")
    public Object vitalReferData (@RequestBody Object param) {
        return this.iCRA1000Service.vitalReferData(param);
    }

    /** 검사결과 조회 */
    @PostMapping("/examResult")
    public Object examResult (@RequestBody Object param) { return this.iCRA1000Service.examResult(param); }
    /** ========================================================================================================================================================== */


    /** CRA1040 경과기록 =========================================================================================================================================== */
    /** 경과기록 리스트 조회 */
    @PostMapping("/progressList")
    public Object progressList (@RequestBody Object param) {
        return this.iCRA1000Service.progressList(param);
    }

    /** 경과기록 기본형 데이터 조회 */
    @PostMapping("/progressData")
    public Object progressData (@RequestBody Object param) {
        return this.iCRA1000Service.progressData(param);
    }

    /** 경과기록 SOAP 데이터 조회 */
    @PostMapping("/progressSOAPData")
    public Object progressSOAPData (@RequestBody Object param) {
        return this.iCRA1000Service.progressSOAPData(param);
    }

    /** 경과기록 일련번호 체크 */
    @PostMapping("/prgrSqnoCheck")
    public Object prgrSqnoCheck (@RequestBody Object param) {
        return this.iCRA1000Service.prgrSqnoCheck(param);
    }

    /** 경과기록 추가 */
    @PostMapping("/progressInsert")
    public void progressInsert (@RequestBody Object param) {
        this.iCRA1000Service.progressInsert(param);
    }

    /** 경과기록 수정 */
    @PostMapping("/progressUpdate")
    public void progressUpdate (@RequestBody Object param) {
        this.iCRA1000Service.progressUpdate(param);
    }

    /** 경과기록 삭제 */
    @PostMapping("/progressDelete")
    public void progressDelete (@RequestBody Object param) {
        this.iCRA1000Service.progressDelete(param);
    }
    /** ========================================================================================================================================================== */


    /** CRA1050 처방조회 =========================================================================================================================================== */
    /** 과거기록 조회 */
    @PostMapping("/pastList")
    public Object pastList (@RequestBody Object param) {
        return this.iCRA1000Service.pastList(param);
    }

    /** 경과기록 조회 */
    @PostMapping("prgrList")
    public Object prgrList (@RequestBody Object param) { return this.iCRA1000Service.prgrList(param); }

    /** 완료 검사결과 조회 */
    @PostMapping("completeExam")
    public Object completeExam (@RequestBody Object param) { return this.iCRA1000Service.completeExam(param); }

    /** SLIP 목록 조회 */
    @PostMapping("/slipList")
    public Object slipList (@RequestBody Object param) {
        return this.iCRA1000Service.slipList(param);
    }

    /** Slip 수가 목록 조회 */
    @PostMapping("/slipPrscList")
    public Object slipPrscList (@RequestBody Object param) {
        return this.iCRA1000Service.slipPrscList(param);
    }
    /** ========================================================================================================================================================== */


    /** CRA1060 진단/처방 ========================================================================================================================================== */
    /** 진단 검색 목록 조회 */
    @PostMapping("/dgnsMList")
    public Object dgnsMList (@RequestBody Object param) {
        return this.iCRA1000Service.dgnsMList(param);
    }

    /** 진단 내역 조회 */
    @PostMapping("/dgnsList")
    public Object dgnsList (@RequestBody Object param) {
        return this.iCRA1000Service.dgnsList(param);
    }

    /** 진단 저장 */
    @PostMapping("/savePtDgns")
    public void savePtDgns (@RequestBody Object param) {
        this.iCRA1000Service.savePtDgns(param);
    }

    /** 진단 수정 */
    @PostMapping("/updatePtDgns")
    public void updatePtDgns (@RequestBody Object param) {
        this.iCRA1000Service.updatePtDgns(param);
        this.iCRA1000Service.savePtDgns(param);
    }

    /** 진단 형태 목록 조회 */
    @PostMapping("/dvsnList")
    public Object dvsnList (@RequestBody Object param) { return this.iCRA1000Service.dvsnList(param); }

    /** 진단 부위 목록 조회 */
    @PostMapping("/siteList")
    public Object siteList (@RequestBody Object param) { return this.iCRA1000Service.siteList(param); }

    /** 처방 검색 목록 조회 */
    @PostMapping("/prscMList")
    public Object prscMList (@RequestBody Object param) {
        return this.iCRA1000Service.prscMList(param);
    }

    /** 처방 내역 조회 */
    @PostMapping("/prscList")
    public Object prscList (@RequestBody Object param) {
        return this.iCRA1000Service.prscList(param);
    }

    /** 처방 저장 */
    @PostMapping("/savePtPrsc")
    public void savePtPrsc (@RequestBody Object param) {
        this.iCRA1000Service.savePtPrsc(param);
    }

    /** 처방 수정 */
    @PostMapping("/updatePtPrsc")
    public void updatePtPrsc (@RequestBody Object param) {
        this.iCRA1000Service.updatePtPrsc(param);
        this.iCRA1000Service.savePtPrsc(param);
    }

    /** 의약분업예외 목록 조회 */
    @PostMapping("/excpList")
    public Object excpList (@RequestBody Object param) {
        return this.iCRA1000Service.excpList(param);
    }

    /** 용법 목록 조회 */
    @PostMapping("/iotmList")
    public Object iotmList (@RequestBody Object param) {
        return this.iCRA1000Service.iotmList(param);
    }

    /** 처방 약속 저장 */
    @PostMapping("/savePrscSet")
    public void savePrscSet (@RequestBody Object param) { this.iCRA1000Service.savePrscSet(param); }

    /** 용법 목록 조회 */
    @PostMapping("/dcList")
    public Object dcList (@RequestBody Object param) {
        return this.iCRA1000Service.dcList(param);
    }

    /** 급여 목록 조회 */
    @PostMapping("/prscPayList")
    public Object prscPayList (@RequestBody Object param) {
        return this.iCRA1000Service.prscPayList(param);
    }

    /** 원외 목록 조회 */
    @PostMapping("/hostList")
    public Object hostList (@RequestBody Object param) {
        return this.iCRA1000Service.hostList(param);
    }

    /** 산정 목록 조회 */
    @PostMapping("/cmptList")
    public Object cmptList (@RequestBody Object param) {
        return this.iCRA1000Service.cmptList(param);
    }

    /** ========================================================================================================================================================== */
}
