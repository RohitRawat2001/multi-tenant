package com.muti_tenant.muti_tenant.config;

public class ClientDatabaseContextHolder {

    private static ThreadLocal<ClientDatabase> currentTenant = new ThreadLocal<>();

    public static ClientDatabase getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(ClientDatabase tenant) {
        currentTenant.set(tenant);
    }

    public static void clear() {
        currentTenant.remove();
    }
}
