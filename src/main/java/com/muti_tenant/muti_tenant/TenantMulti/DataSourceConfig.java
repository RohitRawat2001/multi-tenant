//package com.muti_tenant.muti_tenant.TenantMulti;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.hibernate.cfg.Environment;
//import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
//import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Autowired
//    private MultiTenantConnectionProvider multiTenantConnectionProvider;
//
//    @Autowired
//    private CurrentTenantIdentifierResolver tenantIdentifierResolver;
//
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//
//        em.setPackagesToScan("com.muti_tenant.muti_tenant.entity");
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        Map<String, Object> properties = new HashMap<>(jpaProperties.getProperties());
//        properties.put(Environment.MULTI_TENANT, org.hibernate.MultiTenancyStrategy.DATABASE);
//        properties.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
//        properties.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, tenantIdentifierResolver);
//        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
//
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        return new JpaTransactionManager(emf);
//    }
//}
