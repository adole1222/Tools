package com.framework.tool.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@AutoConfigureAfter(DataSourceTestConfig.class)
@Configuration("testMybatis")
public class MybatisConfig {

    @Bean
    @Qualifier
    public SqlSessionFactory sqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        try {
            return bean.getObject();
        } catch (Exception e) {
            throw new RuntimeException("");
        }
    }
}