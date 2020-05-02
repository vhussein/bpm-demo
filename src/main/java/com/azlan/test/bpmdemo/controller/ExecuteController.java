package com.azlan.test.bpmdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
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

    @PostMapping(path = "/execute")
    public HttpStatus executeProcess(){
        runtimeService.startProcessInstanceByKey("checkWeather");
        return HttpStatus.OK;
    }

}
