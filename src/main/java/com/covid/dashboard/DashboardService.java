package com.covid.dashboard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DashboardService {

    @Value("${covid.api.url}")
    private String covidApiUrl;

    private final RestTemplate restTemplate;

    public DashboardService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;

    }
    public String getLatestCovidCount(){
        return restTemplate.getForEntity(covidApiUrl , String.class).getBody();
    }
}

