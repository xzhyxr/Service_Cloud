package org.chinalbs.controller;

import org.chinalbs.entry.BaseEntry;
import org.chinalbs.entry.HiEntry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

	@Value("${foo}")
    private String foo;
	
	@Value("${port}")
    private String port;
	
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
    
    @RequestMapping("/hiRest")
    public HiEntry hiRest(@RequestParam String name) {
        return new HiEntry(name, new BaseEntry(Integer.valueOf(port)));
    }
}
