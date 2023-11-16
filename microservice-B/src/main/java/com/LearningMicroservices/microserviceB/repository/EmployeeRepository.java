package com.LearningMicroservices.microserviceB.repository;

import com.LearningMicroservices.microserviceB.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class EmployeeRepository {
    List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        if (employees.add(employee)) return employee;
        else return null;
    }

    public List<Employee> getAllEmployees() {
        if (employees.isEmpty()) return Collections.EMPTY_LIST;
        else return employees;
    }
}
