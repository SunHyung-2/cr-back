package com.amaranth10.cr.cra.cra2000.controller;

import com.amaranth10.cr.cra.cra2000.service.ICRA2000Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 진료 상용구 Controller
 */
@RestController
public class CRA2000Controller {
    @Autowired
    private ICRA2000Service iCRA2000Service;

    /** 상용구 목록 조회 */
    @PostMapping("/blpeList")
    public Object blpeList (@RequestBody Object param) {
        return this.iCRA2000Service.blpeList(param);
    };

    /** 상용구 목록 검색 */
    @PostMapping("/searchBlpe")
    public Object searchBlpe (@RequestBody Object param) { return this.iCRA2000Service.searchBlpe(param); };

    /** 상용구 삭제 */
    @PostMapping("/deleteBlpe")
    public void deleteBlpe (@RequestBody Object param) { this.iCRA2000Service.deleteBlpe(param); };

    /** 상용구 분류 DropDownList 조회 */
    @PostMapping("/comBlpeList")
    public Object comBlpeList (@RequestBody Object param) { return this.iCRA2000Service.comBlpeList(param); };

    /** 상용구 상세 조회 */
    @PostMapping("/blpeDetail")
    public Object blpeDetail (@RequestBody Object param) { return this.iCRA2000Service.blpeDetail(param); };

    /** 상용구 추가 */
    @PostMapping("/insertBlpe")
    public void insertBlpe (@RequestBody Object param) { this.iCRA2000Service.insertBlpe(param); };

    /** 상용구 수정 */
    @PostMapping("/updateBlpe")
    public void updateBlpe (@RequestBody Object param) { this.iCRA2000Service.updateBlpe(param); };
}
