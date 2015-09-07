package com.researchdwit.rara.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/")
	public String index() {
		System.out.println("test");
		return "home";	
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";	
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";	
	}
	
	@RequestMapping("/add")
	public String addItem(){
		System.out.println("Testing add item method");
		System.out.println("ram babu");
		System.out.println("pratibh");
		System.out.println("Testing goes on");
		return "Pratibh don";
	}
}
