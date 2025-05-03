//package com.muti_tenant.muti_tenant.TenantMulti;
//
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//public class MultitenantDataSource extends AbstractRoutingDataSource {
//    @Override
//    protected String determineCurrentLookupKey() {
//        return TenantContext.getCurrentTenant();
//    }
//}