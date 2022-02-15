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

}
