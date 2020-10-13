package com.jrm.springsecurity.prac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/mylogin")
	public String myLogin() {
		
		return "my-login";
	}
	
	@GetMapping("/access-denied")
public String accessDenied() {
		
		return "access-denied";
	}

}
