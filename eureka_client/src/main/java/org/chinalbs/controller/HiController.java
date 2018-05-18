package org.chinalbs.controller;

import org.chinalbs.entry.BaseEntry;
import org.chinalbs.entry.HiEntry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
	
	@Value("${server.port}")
    String port;
	
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }
    
    @RequestMapping("/hiRest")
    public HiEntry hiRest(@RequestParam String name) {
        return new HiEntry(name, new BaseEntry(Integer.valueOf(port)));
    }
}
