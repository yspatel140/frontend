package com.example.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class RetryService {
    @Autowired
    private RestTemplate restTemplate;
    @Retryable(value = {ResourceAccessException.class},
            maxAttempts = 4, backoff = @Backoff(1000))
    public String service() {
        System.out.println("Inside service method");
        String url = "http://localhost:8081/backend";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    @Recover
    public String recover(ResourceAccessException e) {
        System.out.println("Inside recover method");
        return "Error occurred while fetching data from backend service";
    }
}
