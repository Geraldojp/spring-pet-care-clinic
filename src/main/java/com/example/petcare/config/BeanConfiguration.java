package com.example.petcare.config;

import com.example.petcare.controller.*;
import com.example.petcare.repository.OwnerRepo;
import com.example.petcare.repository.PetClinicRepo;
import com.example.petcare.repository.PetRepo;
import com.example.petcare.repository.SalesRepo;
import com.example.petcare.service.OwnerService;
import com.example.petcare.service.PetClinicService;
import com.example.petcare.service.PetService;
import com.example.petcare.service.SalesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class BeanConfiguration {
    @Value("${driver}")
    private String dbDriver;
    @Value("${url}")
    private String url;
    @Value("${dbuser}")
    private String dbUser;
    @Value("${dbpassword}")
    private String dbPassword;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(dbUser);
        driverManagerDataSource.setPassword(dbPassword);
        driverManagerDataSource.setDriverClassName(dbDriver);
        return driverManagerDataSource;
    }

    @Bean
    public OwnerRepo getOwnerRepo() {
        return new OwnerRepo(dataSource());
    }

    @Bean
    public OwnerService getOwnerService() {
        return new OwnerService(getOwnerRepo());
    }

    @Bean
    public OwnerController getOwnerController() {
        return new OwnerController(getOwnerService());
    }

    @Bean
    public PetRepo getPetRepo() {
        return new PetRepo(dataSource());
    }

    @Bean
    public PetService getPetService() {
        return new PetService(getPetRepo());
    }

    @Bean
    public PetController getPetController() {
        return new PetController(getPetService());
    }

    @Bean
    public PetClinicRepo getPetClinicRepo() {
        return new PetClinicRepo(dataSource());
    }

    @Bean
    public PetClinicService getPetClinicService() {
        return new PetClinicService(getPetClinicRepo());
    }

    @Bean
    public PetClinicController getPetClinicController() {
        return new PetClinicController(getPetClinicService());
    }

    @Bean
    public SalesRepo getSalesRepo() {
        return new SalesRepo(dataSource());
    }

    @Bean
    public SalesService getSalesService() {
        return new SalesService(getSalesRepo());
    }

    @Bean
    public SalesController getSalesController() {
        return new SalesController(getSalesService());
    }

    @Bean
    public MenuController getMenuController() {
        return new MenuController(getOwnerController(), getPetController(), getPetClinicController(), getSalesController());
    }
}
