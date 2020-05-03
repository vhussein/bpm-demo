package com.azlan.test.bpmdemo.task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Slf4j
public class NotifyOrderFailed implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Executing the service task " + this.getClass().getSimpleName());
        log.info("\n\n \t >> Too bad Mr. {}, you failed :( :( !!! >> \n\n", delegateExecution.getVariable("customerName"));
    }
}
