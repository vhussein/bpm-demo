package com.azlan.test.bpmdemo;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class BpmDemoApplication {



    public static void main(String[] args) {
        SpringApplication.run(BpmDemoApplication.class, args);
    }
}
