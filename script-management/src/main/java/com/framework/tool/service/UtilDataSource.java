package com.framework.tool.service;

import com.framework.tool.common.Constant;
import org.apache.ibatis.jdbc.ScriptRunner;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
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


    public static void executeScript(ScriptRunner scriptRunner, DataSource dataSource, File script) {
        try {
            scriptRunner.runScript(new FileReader(script));
            String sql = String.format("UPDATE `testdb`.`t_schema_table` SET `id`=NULL, `name`=NULL, `status`=NULL, `add_time`=NULL, `add_user`=NULL, `update_time`=NULL, `update_user`=NULL WHERE (`id`=0);",script.getName());
            dataSource.getConnection().prepareStatement(sql);
        }catch (Exception e){

        }

    }
}
