package com.azlan.test.bpmdemo.task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.security.SecureRandom;
import java.util.Random;

@Slf4j
public class CheckWeatherDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        log.info("Executing the service task " + this.getClass().getName());

        Random rand = SecureRandom.getInstanceStrong();

        delegateExecution.setVariable("name", "Azlan");
        delegateExecution.setVariable("weatherOK", rand.nextBoolean());
    }
}
