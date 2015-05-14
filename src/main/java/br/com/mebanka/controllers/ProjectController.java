package br.com.mebanka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/projects")
public class ProjectController {
	
	@RequestMapping("/hello/{name}")
	@ResponseBody
	public String hello(@PathVariable String name){
		return "Hello, "+ name;
	}

}
