package com.jrm.sprringboot.myfirstspringapp.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class JustARestController {

	
	
	//inject custom properties
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String hello() {
		return "Helllo JRM. The time is : "+ LocalDate.now();
	}
	
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach"+coachName+"-- Team: "+teamName;
	}
	
}
