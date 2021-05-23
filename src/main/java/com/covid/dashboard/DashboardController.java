package com.covid.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @GetMapping
    public String getLatestCases() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://api.rootnet.in/covid19-in/stats/latest"; // load this from properties
       // ResponseEntity<String> response
            //    = restTemplate.getForEntity(fooResourceUrl , String.class);
        return restTemplate.getForEntity(fooResourceUrl , String.class).getBody();
    }
}
