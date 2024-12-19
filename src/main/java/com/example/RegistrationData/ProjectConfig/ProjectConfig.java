package com.example.RegistrationData.ProjectConfig;

import javax.sql.DataSource;

import com.example.RegistrationData.DTO.CustomerDTO;
import com.example.RegistrationData.DTO.PurchaseDTO;
import com.example.RegistrationData.ORMEntity.Customer;
import com.example.RegistrationData.ORMEntity.Purchase;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

import java.util.List;



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

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }



//    @Bean
//    pblic ModelMapper modelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//
//        return modelMapper;
//    }
}