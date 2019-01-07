package com.framework.tool;

import com.framework.tool.service.InitService;
import com.framework.tool.service.impl.InitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScriptManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScriptManagementApplication.class,args);
    }
}
