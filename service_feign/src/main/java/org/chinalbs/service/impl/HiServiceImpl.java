package org.chinalbs.service.impl;

import org.chinalbs.service.HiService;
import org.springframework.stereotype.Component;

@Component
public class HiServiceImpl implements HiService {

	@Override
	public String sayHi(String name) {
		return "sorry "+name;
	}

}
