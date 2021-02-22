package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import bean.Match;
import bean.Player;
import bean.Team;

public class MatchController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Match match = new Match();
		Team teamA = inputTeamDetails(1);
		Team teamB = inputTeamDetails(2);
		match.setTeamA(teamA);
		match.setTeamB(teamB);
		System.out.println(teamA.getCaptain() + " will be tossing the coin! \n" + teamB.getCaptain() + " call heads or tails!");
		String tossCall = sc.next();
		int tossCallVal = 1;
		if(tossCall=="heads")
			tossCallVal = 0;
		int tossVal = toss();
		if(tossVal==tossCallVal)
		{
			tossResults(match, teamB, teamA);
		}
		else
		{
			tossResults(match, teamA, teamB);
		}
		
		// Create Innings instance and start the match
		
		// Innings wise match
		
		// Two nested for loops one for noOfOvers and other for noOfBalls
		
		// When over completed or wicket fallen, update in innings instance using the methods
		
		// After completion of innings, store the stats in MatchStats object
		
		// Finally print the stats
		
	}

	public static void tossResults(Match match, Team winningTeam, Team lossingTeam)
	{
		System.out.println(winningTeam.getName() + " won the toss! \n " + winningTeam.getCaptain() + " what will you choose bat/field ?");
		match.setToss(1);
		match.setTossChoice(sc.next());
		if(match.getTossChoice()=="bat")
			match.setFirstBattingTeam(winningTeam.getName());
		else
			match.setFirstBattingTeam(lossingTeam.getName());
		System.out.println(winningTeam.getName() + " won the toss and choose to " + match.getTossChoice());
	}
	
	public static int toss() {
		Random random = new Random();
		int tossVal = random.nextInt(2);
		return tossVal;
	}

	public static Team inputTeamDetails(int teamNo) {
		Team team = new Team();
		ArrayList<Player> playerList = new ArrayList<Player>();
		System.out.println("Enter the team " + teamNo + " name : ");
		team.setName(sc.next()); // Single Word Team Names else use sc.nextLine() and one time extra for buffer
		System.out.println("Enter captain details(first name, last name, age, playerType) : ");
		String fname, lname, age, playerType;
		fname = sc.next();
		lname = sc.next();
		age = sc.next();
		playerType = sc.next();
		Player player = new Player();
		player.setPlayerDetails(fname + lname, age, playerType);
		team.setCaptain(fname+lname);
		System.out.println("Enter the details of players(first name, last name, age, playerType) : "); // First 6 batsmen and last 5 bowlers. Each bowler will bowl 4 overs each randomly. All will bat in input order.
		for (int i = 0; i < 10; i++) {
			fname = sc.next();
			lname = sc.next();
			age = sc.next();
			playerType = sc.next();
			player = new Player();
			player.setPlayerDetails(fname + lname, age, playerType);
			playerList.add(player);
		}
		team.setPlayerList(playerList);
		return team;
	}

}
