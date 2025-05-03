package com.muti_tenant.muti_tenant.service;

import com.muti_tenant.muti_tenant.config.ClientDatabase;
import com.muti_tenant.muti_tenant.config.ClientDatabaseContextHolder;
import com.muti_tenant.muti_tenant.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.List;

@Service
public class EmployeService {

    @Autowired
    DataSource dataSource;

    public List<Employee>  getEmployee(String orgId){
        if(orgId.equalsIgnoreCase("1")){
            ClientDatabaseContextHolder.setCurrentTenant(ClientDatabase.DB_1);
        }

        if(orgId.equalsIgnoreCase("2")){
            ClientDatabaseContextHolder.setCurrentTenant(ClientDatabase.DB_2);
        }

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT id, name, org_id FROM employee";

        List<Employee> employees = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getString("id"));
            employee.setName(rs.getString("name"));
            employee.setOrgId(rs.getString("org_id"));
            return employee;
        });

        return employees;
    }
}
