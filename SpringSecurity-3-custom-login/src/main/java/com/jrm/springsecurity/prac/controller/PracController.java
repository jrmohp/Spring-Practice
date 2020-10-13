package com.jrm.springsecurity.prac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PracController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    
    //add leaders
    
    @GetMapping("/manager")
    public String showLeaders() {
    	return "managers";
    }
}
