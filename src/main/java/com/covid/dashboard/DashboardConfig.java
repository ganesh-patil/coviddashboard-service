package com.covid.dashboard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DashboardConfig {
    @Bean
    public RestTemplate getTestTemplate(){
        return new RestTemplate();
    }
}
