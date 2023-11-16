package com.LearningMicroservices.microserviceA.controller;

import com.LearningMicroservices.microserviceA.client.MicroserviceBClient;
import com.LearningMicroservices.microserviceA.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/a")
@Slf4j
public class MicroserviceAController {

    @Autowired
    private MicroserviceBClient bClient;

    @PostMapping("/saveToB")
    public Employee addEmployeeA(@RequestBody Employee employee) {
        log.info("REQUEST RECEIVED BY SERVICE A FOR ADD EMPLOYEE");
        return bClient.addEmployee(employee);
    }
}
