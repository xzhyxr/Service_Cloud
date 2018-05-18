package org.chinalbs.service;

import org.chinalbs.service.impl.HiServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",fallback=HiServiceImpl.class )
public interface HiService {
    @RequestMapping(value = "/hiRest",method = RequestMethod.GET)
    String sayHi(@RequestParam(value = "name") String name);
}
