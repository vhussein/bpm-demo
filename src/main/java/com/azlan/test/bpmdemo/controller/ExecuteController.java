package com.azlan.test.bpmdemo.controller;

import com.azlan.test.bpmdemo.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/camunda")
@Slf4j
public class ExecuteController {

    private final RuntimeService runtimeService;

    public ExecuteController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping(path = "/weathercheck")
    public HttpStatus weatherCheck(){
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("checkWeather");
        log.debug("Process started using : " + instance.getProcessDefinitionId());
        return HttpStatus.OK;
    }

    @PostMapping(path = "/ekyc")
    public HttpStatus ekycExecute(@RequestBody Customer customer){

        Map<String, Object> map = new HashMap<>();
        map.put("customerName", customer.getCustomerName());
        log.debug("map >> {}", map.toString());

        ProcessInstance instance = runtimeService.startProcessInstanceByKey("ekycProcess", map);
        log.debug("Process started using : " + instance.getProcessDefinitionId());
        return HttpStatus.OK;
    }

}
