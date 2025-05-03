//package com.muti_tenant.muti_tenant.TenantMulti;
//
//import jakarta.annotation.PostConstruct;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import javax.sql.DataSource;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Map;
//import java.util.Properties;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Configuration
//@Log4j2
//public class MultitenantConfiguration {
//
//    private final Map<Object, Object> tenantDataSources = new ConcurrentHashMap<>();
//
//    @Bean
//    @Primary
//    public DataSource dataSource() {
//
//        // Load tenant configuration files from folder "allTenants"
//        File[] files = Paths.get("allTenants").toFile().listFiles();
//        if (files == null || files.length == 0) {
//            throw new RuntimeException("No tenant files found in /allTenants");
//        }
//
//        for (File propertyFile : files) {
//            Properties tenantProperties = new Properties();
//            try {
//                tenantProperties.load(new FileInputStream(propertyFile));
//
//                String tenantId = tenantProperties.getProperty("name");
//                String url = tenantProperties.getProperty("datasource.url");
//                String username = tenantProperties.getProperty("datasource.username");
//                String password = tenantProperties.getProperty("datasource.password");
//                String driver = tenantProperties.getProperty("datasource.driver-class-name");
//
//                if (tenantId == null || url == null || username == null || password == null || driver == null) {
//                    throw new RuntimeException("Missing required properties in: " + propertyFile.getName());
//                }
//
//                DataSource dataSource = DataSourceBuilder.create()
//                        .driverClassName(driver)
//                        .url(url)
//                        .username(username)
//                        .password(password)
//                        .build();
//
//                // Test DB connection
//                try (Connection connection = dataSource.getConnection()) {
//                    System.out.println("Connected to tenant DB: " + tenantId);
//                    tenantDataSources.put(tenantId, dataSource);
//                }
//
//            } catch (IOException | SQLException e) {
//                throw new RuntimeException("Failed to load tenant config: " + propertyFile.getName(), e);
//            }
//        }
//
//        // Use your custom routing data source class
//        MultitenantDataSource multiTenantDataSource = new MultitenantDataSource();
//        multiTenantDataSource.setTargetDataSources(tenantDataSources);
//
//        // Set default tenant (ensure tenant_1 exists)
//        Object defaultDs = tenantDataSources.get("tenant_1");
//        if (defaultDs == null) {
//            throw new RuntimeException("Default tenant not found: tenant_1");
//        }
//
//        multiTenantDataSource.setDefaultTargetDataSource(defaultDs);
//        multiTenantDataSource.afterPropertiesSet();
//
//        return multiTenantDataSource;
//    }
//}
