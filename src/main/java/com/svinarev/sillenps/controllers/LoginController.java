package com.svinarev.sillenps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@PostMapping
	public void login() {
		System.out.println("YES");
	}
	
}
