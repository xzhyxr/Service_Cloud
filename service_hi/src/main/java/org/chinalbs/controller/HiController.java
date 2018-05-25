package org.chinalbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HiController {
	
	@Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String callHome(){
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }
    @RequestMapping("/info")
    public String info(){
        return "i'm service-hi";
    }
}
