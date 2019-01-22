package com.framework.tool.service;

import com.framework.tool.common.Constant;
import org.apache.ibatis.jdbc.ScriptRunner;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UtilDataSource {

    static Map<String, String> dataSourceKeyMap = new HashMap<String, String>() {
        {
            put(Constant.TEST_DB, Constant.TEST_DB_DATASOURCE);
            put(Constant.USER_DB, Constant.USER_DB_DATASOURCE);
        }
    };

    public static DataSource getDataSourceMap(String key, Map<String, DataSource> dataSourceMap) {
        String dataSourceKey = dataSourceKeyMap.get(key);
        if (!dataSourceMap.containsKey(dataSourceKey)) {
            return dataSourceMap.get(Constant.TEST_DB_DATASOURCE);
        }
        return dataSourceMap.get(dataSourceKey);
    }

    public static Connection getConnection(String key, Map<String, DataSource> dataSourceMap) throws Exception {
        String dataSourceKey = dataSourceKeyMap.get(key);
        if (!dataSourceMap.containsKey(dataSourceKey)) {
            return dataSourceMap.get(Constant.TEST_DB_DATASOURCE).getConnection();
        }
        return dataSourceMap.get(dataSourceKey).getConnection();
    }


    public static void executeScript(DataSource dataSource, File[] file) {
        Connection connection = null;
        try {
            ScriptRunner scriptRunner = new ScriptRunner(dataSource.getConnection());
            connection = dataSource.getConnection();
            for (File script : file) {
                scriptRunner.runScript(new FileReader(script));
                String sql = String.format("INSERT INTO t_schema_table (name, status) VALUES ('%s', %s);", script.getName(), Constant.STATUS_SUCCESS);
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
