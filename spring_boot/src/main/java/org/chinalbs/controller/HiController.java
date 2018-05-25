package org.chinalbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HiController {

	@GetMapping(value="/hi")
	public String sayHi(String name){
		return "hi" + name;
	}
	
	@RequestMapping(value="/hello")
	@ResponseBody
	public String hello(){
		return "index";
	}
	
	@RequestMapping(value="/toIndex")
	public String toIndex(){
		return "/index";
	}
	
	@RequestMapping(value="/hiIndex")
	public ModelAndView hiIndex(){
		return new ModelAndView("index");
	}
}
