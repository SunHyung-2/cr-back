package com.amaranth10.cr.cra.cra3000.controller;

import com.amaranth10.cr.cra.cra3000.service.ICRA3000Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 약속처방 Controller
 */
@RestController
public class CRA3000Controller {
    @Autowired
    private ICRA3000Service iCRA3000Service;

}
