//package com.muti_tenant.muti_tenant.TenantMulti;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import jakarta.servlet.*;
//import java.io.IOException;
//
//
//@Component
//@Order(1)
//public class TenantFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        String tenantId = req.getHeader("X-TenantID");
//        System.out.println("Setting tenant to: " + tenantId);
//        TenantContext.setCurrentTenant(tenantId);
//        try {
//            chain.doFilter(request, response);
//        } finally {
//            TenantContext.setCurrentTenant(null);
//        }
//    }
//}
