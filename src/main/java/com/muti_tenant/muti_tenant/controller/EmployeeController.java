package com.muti_tenant.muti_tenant.controller;

import com.muti_tenant.muti_tenant.entity.Employee;
import com.muti_tenant.muti_tenant.repository.EmployeeRepository;
import com.muti_tenant.muti_tenant.service.EmployeService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/employee/{orgId}")
    public ResponseEntity<List<Employee>> createEmployee(@PathVariable String orgId) {
        System.out.println("orgID"+ orgId);
        return ResponseEntity.ok(employeService.getEmployee(orgId));
    }
}