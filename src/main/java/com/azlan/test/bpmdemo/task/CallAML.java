package com.azlan.test.bpmdemo.task;

import com.azlan.test.bpmdemo.model.MockResponse;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class CallAML implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Executing the service task " + this.getClass().getSimpleName());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MockResponse> resp = restTemplate.postForEntity("http://localhost:8080/mocker/mockekyc", null, MockResponse.class);

        MockResponse mock = resp.getBody();
        delegateExecution.setVariable("matchAML", mock != null && mock.isResponse());
    }
}
