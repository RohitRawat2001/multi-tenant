//package com.muti_tenant.muti_tenant.TenantMulti;
//
//
//
//import org.springframework.jdbc.datasource.AbstractDataSource;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//@Component
//public class TenantAwareDataSource extends AbstractRoutingDataSource {
//
//    @Override
//    protected Object determineCurrentLookupKey() {
//        String tenant = TenantContext.getCurrentTenant();
//        if (tenant == null) {
//            throw new IllegalStateException("Tenant not set.");
//        }
//        return tenant;
//    }
//}
