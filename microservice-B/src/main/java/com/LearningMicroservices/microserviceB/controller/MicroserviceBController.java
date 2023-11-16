package com.LearningMicroservices.microserviceB.controller;

import com.LearningMicroservices.microserviceB.model.Employee;
import com.LearningMicroservices.microserviceB.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/b")
@Slf4j
public class MicroserviceBController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping("/allEmployee")
    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployees();
    }


}
