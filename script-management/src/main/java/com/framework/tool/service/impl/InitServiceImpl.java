package com.framework.tool.service.impl;

import com.framework.tool.service.InitService;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sun.font.ScriptRun;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class InitServiceImpl implements InitService {

    @Qualifier("scriptDataSource")
    @Autowired
    private DataSource dataSource;

    public void ecec() {
        try {
            Connection connection = dataSource.getConnection();
            ScriptRunner runner = new ScriptRunner(connection);
            runner.runScript(new FileReader("D:\\workspace\\Tools\\script-management\\src\\main\\resources\\dbScript\\t_test01.sql"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
