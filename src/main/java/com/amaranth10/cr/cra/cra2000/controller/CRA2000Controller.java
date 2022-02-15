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

}
