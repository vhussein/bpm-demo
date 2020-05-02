package com.azlan.test.bpmdemo.task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Slf4j
public class LoggerDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("\n\n .... Logger delegate invoke by " +
                "process definition: " + delegateExecution.getProcessDefinitionId()
                + ", activityID: " + delegateExecution.getCurrentActivityId()
                + ", activityName: " + delegateExecution.getCurrentActivityName()
                + ", processInstanceID: " + delegateExecution.getProcessInstanceId()
                + ", businessKey: " + delegateExecution.getBusinessKey()
                + ", executionID: " + delegateExecution.getId()
                + ", message: " + delegateExecution.getVariables().toString());
    }
}
