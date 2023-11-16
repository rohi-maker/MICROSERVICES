package com.LearningMicroservices.microserviceA.client;

import com.LearningMicroservices.microserviceA.model.Employee;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface MicroserviceBClient {
    @PostExchange("/b/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee);
}
