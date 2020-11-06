package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;

	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg construtor");
	}

	public void setFortuneService(FortuneService fortuneService) {
		
		System.out.println("CricketCoach: inside setter method - setFortuneService ");
		this.fortuneService = fortuneService;
	}

	
	@Override
	public String getDailyWorkout() {

		return "Practice fast bowlingfor 15 mnts";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();	
	}

	public void setEmailAddress(String emailAddress) {
		
		System.out.println("CricketCoach: inside setter method - setEmailAddress ");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}
	
	

}