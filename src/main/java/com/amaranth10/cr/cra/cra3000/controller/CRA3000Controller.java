package com.amaranth10.cr.cra.cra3000.controller;

import com.amaranth10.backendcommon.util.helper.ExtractUtil;
import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.backendcommon.util.model.SessionInfo;
import com.amaranth10.cr.cra.cra3000.service.ICRA3000Service;
import com.amaranth10.cr.model.RequestModel;
import klago.log.utils.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 약속처방 Controller
 */
@RestController
public class CRA3000Controller {
    @Autowired
    private ICRA3000Service iCRA3000Service;

    /** 약속처방 목록 조회 */
    @PostMapping("/setList")
    public Object setList (@RequestBody Object param) {
        return this.iCRA3000Service.setList(param);
    }

    /** 약속처방 검색 목록 */
    @PostMapping("/searchSetList")
    public Object searchSetList (@RequestBody Object param) {
        return this.iCRA3000Service.searchSetList(param);
    }

    /** 약속처방 진단 상세 조회 */
    @PostMapping("/setDgnsList")
    public Object setDgnsList (@RequestBody Object param) {
        return this.iCRA3000Service.setDgnsList(param);
    }

    /** 약속처방 처방 상세 조회 */
    @PostMapping("/setPrscList")
    public Object setPrscList (@RequestBody Object param) {
        return this.iCRA3000Service.setPrscList(param);
    }

    /** 약속처방 삭제 */
    @PostMapping("/deleteSet")
    public void deleteSet (@RequestBody Object param) {
        this.iCRA3000Service.deleteSet(param);
    }

    /** 약속처방 저장 */
    @PostMapping("/saveSet")
    public void saveSet (@RequestBody Object param) {
        System.out.println(param);
        this.iCRA3000Service.saveSet(param);
    }

    /** 약속처방 수정 */
    @PostMapping("/updateSet")
    public void updateSet (@RequestBody Object param) {
        this.iCRA3000Service.updateSet(param);
        this.iCRA3000Service.deleteSet(param);
        this.iCRA3000Service.saveSet(param);
    }
}
