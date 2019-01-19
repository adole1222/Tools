package com.framework.tool;

import com.framework.tool.service.InitService;
import com.framework.tool.service.impl.InitServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScriptManagementApplication implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(InitServiceImpl.class);
    @Autowired
    private InitService initService;

    public static void main(String[] args) {
        SpringApplication.run(ScriptManagementApplication.class,args);
        System.exit(-1);
    }

    public void run(String... args) throws Exception {
        logger.info("开始初始化脚本");
        initService.ecec();
        logger.info("脚本初始化结束");
    }
}
