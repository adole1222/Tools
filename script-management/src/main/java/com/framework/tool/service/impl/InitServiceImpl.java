package com.framework.tool.service.impl;

import com.framework.tool.service.InitService;
import com.framework.tool.service.UtilDataSource;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Map;

@Service
public class InitServiceImpl implements InitService {
    @Autowired
    private Map<String, DataSource> dataSourceMap;

    Logger logger = LoggerFactory.getLogger(InitServiceImpl.class);

    public void exec() {
        try {
            initDataSource();
            String path = this.getClass().getResource("/").getPath();
            File file = new File(path + File.separator + "dbScript");
            String[] modules = file.list();
            for (String module : modules) {
                DataSource dataSource = null;
                dataSource = UtilDataSource.getDataSourceMap(module, this.dataSourceMap);
                File scripts = new File(path + File.separator + "dbScript" + File.separator + module);
                File[] files = scripts.listFiles();
                UtilDataSource.executeScript(dataSource, files);
            }
        } catch (Exception e) {
            logger.error("初始化错误", e);
        }
    }

    public void initDataSource() {
        try {
            String path = this.getClass().getResource("/").getPath();
            File file = new File(path + File.separator + "initTable" + File.separator + "t_schema_table.sql");
            for (Map.Entry<String, DataSource> stringDataSourceEntry : dataSourceMap.entrySet()) {
                DataSource dataSourceInit = stringDataSourceEntry.getValue();
                Connection connection = dataSourceInit.getConnection();
                ScriptRunner runner = new ScriptRunner(connection);
                runner.runScript(new FileReader(file));
            }
        } catch (Exception e) {
            logger.error("初始化错误", e);
        }
    }
}
