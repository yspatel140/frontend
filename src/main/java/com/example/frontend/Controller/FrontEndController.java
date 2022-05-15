package com.example.frontend.Controller;

import com.example.frontend.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontEndController {
    @Autowired
    private RetryService retryService;

    @RequestMapping(value = "frontend-retry", method = RequestMethod.GET)
    public String frontendRetry() {
        System.out.println("Front end controller start");
        String message = retryService.service();
        System.out.println("Front end controller end");
        return message;
    }
}
