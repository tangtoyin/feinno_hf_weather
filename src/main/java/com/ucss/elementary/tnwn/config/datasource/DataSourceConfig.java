package com.ucss.elementary.tnwn.config.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
//数据源配置
public class DataSourceConfig {


    @Bean(name = "datasourceTnwn")
    @ConfigurationProperties("spring.datasource.druid.tnwn")
    public DataSource datasourceTnwn() {
        return DruidDataSourceBuilder.create().build();
    }


}