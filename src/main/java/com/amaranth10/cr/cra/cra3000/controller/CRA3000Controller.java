package com.amaranth10.cr.cra.cra3000.controller;

import com.amaranth10.cr.util.SessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CRA3000Controller {
    private static final Logger logger = LoggerFactory.getLogger(CRA3000Controller.class);
    @Autowired
    SessionManager sessionManager;
}
