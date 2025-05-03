package com.muti_tenant.muti_tenant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;


    @Bean(name = "dataSourceRouter")
    public DataSource dataSourceRouter(){
        Map<Object,Object>  targetDataSources = new HashMap<>();
        DataSource dataSource1 = DataSourceBuilder.create()
                .url(env.getProperty("spring.datasource1.url"))
                .username(env.getProperty("spring.datasource1.username"))
                .password(env.getProperty("spring.datasource1.password"))
                .build();

        DataSource dataSource2 = DataSourceBuilder.create()
                .url(env.getProperty("spring.datasource2.url"))
                .username(env.getProperty("spring.datasource2.username"))
                .password(env.getProperty("spring.datasource2.password"))
                .build();


        targetDataSources.put(ClientDatabase.DB_1,dataSource1);
        targetDataSources.put(ClientDatabase.DB_2,dataSource2);

        ClientDatasourceRouter router = new ClientDatasourceRouter();
        router.setTargetDataSources(targetDataSources);
        router.setDefaultTargetDataSource(dataSource1);
        return router;
    }
}
