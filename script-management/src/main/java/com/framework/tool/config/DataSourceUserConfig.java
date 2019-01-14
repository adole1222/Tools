package com.framework.tool.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration("userCfg")
public class DataSourceUserConfig {

    @ConfigurationProperties(prefix = "userdb.datasource")
    @Bean("userDataSource")
    @Qualifier("userDataSource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
}
