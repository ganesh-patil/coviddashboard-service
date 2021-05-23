package com.covid.dashboard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Value("${covid.api.url}")
    String covidApiUrl;

    @GetMapping
    public String getLatestCases() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(covidApiUrl , String.class).getBody();
    }


    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(Exception.class)
    public String handleExceptions(Exception ex) {
        return ex.getMessage();
    }
}
