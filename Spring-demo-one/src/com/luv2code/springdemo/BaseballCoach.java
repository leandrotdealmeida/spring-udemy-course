package com.luv2code.springdemo;

public class BaseballCoach implements Coach {

	// define a private fieldfor the dependency
	private FortuneService fortuneService;

	// define a construtorfor dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		//use myfortuneService to get a fortune
		return fortuneService.getFortune();
	}

}
