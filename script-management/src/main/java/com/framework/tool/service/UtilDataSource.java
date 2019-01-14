package com.framework.tool.service;
import com.framework.tool.common.Constant;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class UtilDataSource {

    static Map<String, String> dataSourceKeyMap = new HashMap<String, String>() {
        {
            put(Constant.TEST_DB, Constant.TEST_DB_DATASOURCE );
            put(Constant.USER_DB, Constant.USER_DB_DATASOURCE );
        }
    };

    public static DataSource getDataSourceMap(String key, Map<String, DataSource> dataSourceMap) {
        String dataSourceKey = dataSourceKeyMap.get(key);
        if (!dataSourceMap.containsKey(dataSourceKey)){
            return dataSourceMap.get(Constant.TEST_DB_DATASOURCE);
        }
        return dataSourceMap.get(dataSourceKey);
    }
}
