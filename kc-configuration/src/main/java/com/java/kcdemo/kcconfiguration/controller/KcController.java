package com.java.kcdemo.kcconfiguration.controller;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import com.java.kcdemo.kcconfiguration.entity.Employee;
import com.java.kcdemo.kcconfiguration.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employees")
public class KcController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/{employeeId}")
    @RolesAllowed("user")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
        return ResponseEntity.ok(service.getEmpByID(employeeId));
    }

    @GetMapping
    @RolesAllowed("admin")
    public ResponseEntity<List<Employee>> findALlEmployees() {
        return ResponseEntity.ok(service.findAllEmp());
    }


}

