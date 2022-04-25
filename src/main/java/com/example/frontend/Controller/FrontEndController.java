package com.example.frontend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FrontEndController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "frontend", method = RequestMethod.GET)
    public String frontend() {
        String url = "http://backend-svc:8081/backend";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return "Error occurred while fetching data from backend service";
        }
    }


}
