package com.framework.tool.controller;

import com.framework.tool.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private InitService initService;
    @PostMapping("/test")
    public void test(){
        initService.ecec();
    }
}
