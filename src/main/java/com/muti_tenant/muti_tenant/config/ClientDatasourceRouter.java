package com.muti_tenant.muti_tenant.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ClientDatasourceRouter extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return ClientDatabaseContextHolder.getCurrentTenant();
    }
}
