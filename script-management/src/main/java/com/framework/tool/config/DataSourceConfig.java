package com.framework.tool.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration("scriptCfg")
public class DataSourceConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean("scriptDataSource")
    @Qualifier("scriptDataSource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
}
