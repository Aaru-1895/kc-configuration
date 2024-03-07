package com.java.kcdemo.kcconfiguration.service;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.java.kcdemo.kcconfiguration.entity.Employee;
import com.java.kcdemo.kcconfiguration.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @PostConstruct
    public void initializeEmployeeTable() {
        employeeRepo.saveAll(
                Stream.of(
                        new Employee("AA", 20000),
                        new Employee("BB", 55000),
                        new Employee("CC", 120000)
                ).collect(Collectors.toList()));
    }

    public List<Employee> findAllEmp(){
        return employeeRepo.findAll();
    }

    public Employee getEmpByID(int id){
        return employeeRepo.findById(id).orElse(null);
    }
}
