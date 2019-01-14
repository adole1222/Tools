package com.framework.tool.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration("testCfg")
public class DataSourceTestConfig {

    @ConfigurationProperties(prefix = "testdb.datasource")
    @Bean("testDataSource")
    @Qualifier("testDataSource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
}
