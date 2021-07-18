package com.svinarev.sillenps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping(value = "/auth")
public class AuthPageController {

	@GetMapping
	public String getView() {
		return "auth";
	}
	
	@PostMapping
	public void abc() {
		System.out.println(1);
	}
	
}
