package com.azlan.test.bpmdemo.controller;

import com.azlan.test.bpmdemo.model.MockResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@RestController
@RequestMapping("/mocker")
@Slf4j
public class Mocker {

    @PostMapping(path = "/mockekyc")
    public ResponseEntity<MockResponse> mockEkyc() throws NoSuchAlgorithmException {

        Random rand = SecureRandom.getInstanceStrong();
        MockResponse response = new MockResponse();
        response.setResponse(rand.nextBoolean());
        log.debug("Returning response: {}", response.isResponse());
        return ResponseEntity.ok().body(response);
    }
}
