package com.example.RegistrationData.ProjectConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class ProjectConfig {

    @Value("${prince.datasource.url}")
    private String dataSourceUrl;

    @Value("${prince.datasource.username}")
    private String datasourceUsername;

    @Value("${prince.datasource.password}")
    private String datasourcePassword;

    @Bean
    public DataSource datasource(){
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl(dataSourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);
        dataSource.setConnectionTimeout(1000);

        return dataSource;
    }

}