package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;
	@GetMapping("/teamInfo")
	public String getteaminfo()
	{
		return "Coach: "+ coachName +" , Team Name: "+ teamName;
	}
	@GetMapping("/workout")
	public String getDailyWorkout()
	{
		return "Work har and enjoy the success11"; 
	}
	@GetMapping("/fortune")
	public String getDailyFortune()
	{
		return "Every Day is a new starts"; 
	}
	
	@GetMapping("/")
	public String sayHello()
	{
		return "Hellow World Time on server is:"+LocalDateTime.now();
	}
	public FunRestController() {
		// TODO Auto-generated constructor stub
	}

}
