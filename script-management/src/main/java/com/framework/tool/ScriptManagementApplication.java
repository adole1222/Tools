package com.framework.tool;

import com.framework.tool.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScriptManagementApplication implements CommandLineRunner {

    @Autowired
    private InitService initService;

    public static void main(String[] args) {
        SpringApplication.run(ScriptManagementApplication.class,args);
        System.exit(-1);
    }

    public void run(String... args) throws Exception {
        initService.ecec();
    }
}
