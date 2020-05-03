package com.azlan.test.bpmdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/camunda")
@Slf4j
public class ExecuteController {

    private final RuntimeService runtimeService;

    public ExecuteController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping(path = "/weathercheck")
    public HttpStatus executeProcess(){
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("checkWeather");
        log.debug("Process started using : " + instance.getProcessDefinitionId());
        return HttpStatus.OK;
    }

}
