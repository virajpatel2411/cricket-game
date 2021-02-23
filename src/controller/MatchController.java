package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import bean.Innings;
import bean.Match;
import bean.MatchStatistics;
import bean.Player;
import bean.PlayersOnPitch;
import bean.Team;

public class MatchController {

	static Scanner sc = new Scanner(System.in);

	static Random random = new Random();

	public static void main(String[] args) {

		Match match = new Match();
		Team teamA = inputTeamDetails(1);
		Team teamB = inputTeamDetails(2);
		match.setTeamA(teamA);
		match.setTeamB(teamB);
		System.out.println(
				teamA.getCaptain() + " will be tossing the coin! \n" + teamB.getCaptain() + " call heads or tails!");
		String tossCall = sc.next();
		int tossCallVal = 1;
		if (tossCall.equals("heads"))
			tossCallVal = 0;
		int tossVal = toss();
		match.setToss(tossVal);
		Innings firstInnings, secondInnings;
		System.out.println(tossCallVal + " " + tossVal);
		if (tossVal == tossCallVal) {
			tossResults(match, teamB, teamA);
		} else {
			tossResults(match, teamA, teamB);
		}

		firstInnings = new Innings(match.getFirstBattingTeam(), match.getFirstBowlingTeam());
		secondInnings = new Innings(match.getFirstBowlingTeam(), match.getFirstBattingTeam());

		int noOfBallsInOver = 6, noOfOvers = 20;

		PlayersOnPitch playersOnPitch = new PlayersOnPitch();

		System.out.println("First Innings");
		System.out.println("-------------");

		int bowlerIndex = -1, runsInInt = 0, totalRuns = 0, noOfWickets = 0, flag = 0, runsInOver = 0, swapInt = 0;
		String runsScored;
		int[] list = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int j = 0, bowlsBowled = 0;
		for (int i = 0; i < noOfOvers; i++) {
			bowlerIndex = random.nextInt(5);
			while (firstInnings.getOversBowledByBowler().get(bowlerIndex) >= 4)
				bowlerIndex = random.nextInt(5);

			bowlsBowled = 0;

			playersOnPitch.setBowlerIndex(bowlerIndex);
			System.out.println(
					"Bowler Name : " + firstInnings.getFieldingTeam().getPlayerList().get(bowlerIndex + 6).getName());
			for (j = 0; j < noOfBallsInOver; j++) {
				bowlsBowled++;
				runsScored = runsScoredInABall();
				System.out.print(runsScored + " ");
				if (swapInt % 2 == 0) {
					playersOnPitch.setFirstBatsmanBalls(1 + playersOnPitch.getFirstBatsmanBalls());
				} else {
					playersOnPitch.setSecondBatsmanBalls(1 + playersOnPitch.getSecondBatsmanBalls());
				}
				if (runsScored.equals("W")) {
					noOfWickets++;
					if (noOfWickets == 10) {
						if (swapInt % 2 == 0) {
							firstInnings.setRunsScored(playersOnPitch.getFirstBatsmanIndex(),
									playersOnPitch.getFirstBatsmanRuns() + runsInInt,
									playersOnPitch.getFirstBatsmanBalls());
							firstInnings.setRunsScored(playersOnPitch.getSecondBatsmanIndex(),
									playersOnPitch.getSecondBatsmanRuns(), playersOnPitch.getSecondBatsmanBalls());
						} else {
							firstInnings.setRunsScored(playersOnPitch.getSecondBatsmanIndex(),
									playersOnPitch.getSecondBatsmanRuns() + runsInInt,
									playersOnPitch.getSecondBatsmanBalls());
							firstInnings.setRunsScored(playersOnPitch.getFirstBatsmanIndex(),
									playersOnPitch.getFirstBatsmanRuns(), playersOnPitch.getFirstBatsmanBalls());
						}
						flag++;
						break;
					}
					if (swapInt % 2 == 0) {
						firstInnings.setRunsScored(playersOnPitch.getFirstBatsmanIndex(),
								playersOnPitch.getFirstBatsmanRuns() + runsInInt,
								playersOnPitch.getFirstBatsmanBalls());
						playersOnPitch.setFirstBatsmanBalls(0);
						playersOnPitch.setFirstBatsmanRuns(0);
						playersOnPitch.setFirstBatsmanIndex(list[noOfWickets - 1]);
					} else {
						firstInnings.setRunsScored(playersOnPitch.getSecondBatsmanIndex(),
								playersOnPitch.getSecondBatsmanRuns() + runsInInt,
								playersOnPitch.getSecondBatsmanBalls());
						playersOnPitch.setSecondBatsmanBalls(0);
						playersOnPitch.setSecondBatsmanRuns(0);
						playersOnPitch.setSecondBatsmanIndex(list[noOfWickets - 1]);
					}
					runsInInt = 0;
				} else {
					runsInInt += Integer.valueOf(runsScored);
					runsInOver += Integer.valueOf(runsScored);
					if (Integer.valueOf(runsScored) % 2 != 0) {
						swapInt++;
						if (swapInt % 2 != 0) {
							playersOnPitch.setFirstBatsmanRuns(playersOnPitch.getFirstBatsmanRuns() + runsInInt);
						} else {
							playersOnPitch.setSecondBatsmanRuns(playersOnPitch.getSecondBatsmanRuns() + runsInInt);
						}
						runsInInt = 0;
					}
				}
			}
			System.out.println();
			firstInnings.addRunsGiven(bowlerIndex, runsInOver, bowlsBowled);
			firstInnings.getOversBowledByBowler().set(bowlerIndex,
					firstInnings.getOversBowledByBowler().get(bowlerIndex) + 1);
			totalRuns += runsInOver;
			if (flag == 1)
				break;
			runsInOver = 0;
			if (swapInt % 2 == 0) {
				playersOnPitch.setFirstBatsmanRuns(playersOnPitch.getFirstBatsmanRuns() + runsInInt);
			} else {
				playersOnPitch.setSecondBatsmanRuns(playersOnPitch.getSecondBatsmanRuns() + runsInInt);
			}
			runsInInt = 0;

			swapInt++;
		}

		if (flag == 0) {
			firstInnings.setRunsScored(playersOnPitch.getSecondBatsmanIndex(), playersOnPitch.getSecondBatsmanRuns(),
					playersOnPitch.getSecondBatsmanBalls());
			firstInnings.setRunsScored(playersOnPitch.getFirstBatsmanIndex(), playersOnPitch.getFirstBatsmanRuns(),
					playersOnPitch.getFirstBatsmanBalls());
		}

		MatchStatistics matchStatistics = new MatchStatistics();
		matchStatistics.setFirstInningsBatting(firstInnings.getBatting());
		matchStatistics.setFirstInningsBowling(firstInnings.getBowling());

		System.out.println(firstInnings.getBatting());

		System.out.println();
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------");
		System.out.println();

		System.out.println(firstInnings.getBowling());

		System.out.println("Score of first innings : " + totalRuns + "/" + noOfWickets);
		int firstRuns = totalRuns;

		System.out.println();
		System.out.println();
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();

		System.out.println("Second Innings");
		System.out.println("-------------");

		// ------------------------------------------------------------- //
		// ------------------------------------------------------------- //
		// ------------------------------------------------------------- //

		playersOnPitch = new PlayersOnPitch();
		bowlerIndex = -1;
		runsInInt = 0;
		totalRuns = 0;
		noOfWickets = 0;
		flag = 0;
		runsInOver = 0;
		swapInt = 0;
		runsScored = "";
		j = 0;
		bowlsBowled = 0;
		for (int i = 0; i < noOfOvers; i++) {
			bowlerIndex = random.nextInt(5);
			while (secondInnings.getOversBowledByBowler().get(bowlerIndex) >= 4) {
				bowlerIndex = random.nextInt(5);
			}

			bowlsBowled = 0;

			playersOnPitch.setBowlerIndex(bowlerIndex);
			System.out.println(
					"Bowler Name : " + secondInnings.getFieldingTeam().getPlayerList().get(bowlerIndex + 6).getName());
			for (j = 0; j < noOfBallsInOver; j++) {
				bowlsBowled++;
				runsScored = runsScoredInABall();
				System.out.print(runsScored + " ");
				if (swapInt % 2 == 0) {
					playersOnPitch.setFirstBatsmanBalls(1 + playersOnPitch.getFirstBatsmanBalls());
				} else {
					playersOnPitch.setSecondBatsmanBalls(1 + playersOnPitch.getSecondBatsmanBalls());
				}
				if (runsScored.equals("W")) {
					noOfWickets++;
					if (noOfWickets == 10) {
						if (swapInt % 2 == 0) {
							secondInnings.setRunsScored(playersOnPitch.getFirstBatsmanIndex(),
									playersOnPitch.getFirstBatsmanRuns() + runsInInt,
									playersOnPitch.getFirstBatsmanBalls());
							secondInnings.setRunsScored(playersOnPitch.getSecondBatsmanIndex(),
									playersOnPitch.getSecondBatsmanRuns(), playersOnPitch.getSecondBatsmanBalls());
						} else {
							secondInnings.setRunsScored(playersOnPitch.getSecondBatsmanIndex(),
									playersOnPitch.getSecondBatsmanRuns() + runsInInt,
									playersOnPitch.getSecondBatsmanBalls());
							secondInnings.setRunsScored(playersOnPitch.getFirstBatsmanIndex(),
									playersOnPitch.getFirstBatsmanRuns(), playersOnPitch.getFirstBatsmanBalls());
						}
						flag++;
						break;
					}
					if (swapInt % 2 == 0) {
						secondInnings.setRunsScored(playersOnPitch.getFirstBatsmanIndex(),
								playersOnPitch.getFirstBatsmanRuns() + runsInInt,
								playersOnPitch.getFirstBatsmanBalls());
						playersOnPitch.setFirstBatsmanBalls(0);
						playersOnPitch.setFirstBatsmanRuns(0);
						playersOnPitch.setFirstBatsmanIndex(list[noOfWickets - 1]);
					} else {
						secondInnings.setRunsScored(playersOnPitch.getSecondBatsmanIndex(),
								playersOnPitch.getSecondBatsmanRuns() + runsInInt,
								playersOnPitch.getSecondBatsmanBalls());
						playersOnPitch.setSecondBatsmanBalls(0);
						playersOnPitch.setSecondBatsmanRuns(0);
						playersOnPitch.setSecondBatsmanIndex(list[noOfWickets - 1]);
					}
					runsInInt = 0;
				} else {
					runsInInt += Integer.valueOf(runsScored);
					runsInOver += Integer.valueOf(runsScored);
					if (Integer.valueOf(runsScored) % 2 != 0) {
						swapInt++;
						if (swapInt % 2 != 0) {
							playersOnPitch.setFirstBatsmanRuns(playersOnPitch.getFirstBatsmanRuns() + runsInInt);
						} else {
							playersOnPitch.setSecondBatsmanRuns(playersOnPitch.getSecondBatsmanRuns() + runsInInt);
						}
						runsInInt = 0;
					}
				}
			}
			System.out.println();
			secondInnings.addRunsGiven(bowlerIndex, runsInOver, bowlsBowled);
			secondInnings.getOversBowledByBowler().set(bowlerIndex,
					firstInnings.getOversBowledByBowler().get(bowlerIndex) + 1);
			totalRuns += runsInOver;
			if (flag == 1)
				break;
			runsInOver = 0;
			if (swapInt % 2 == 0) {
				playersOnPitch.setFirstBatsmanRuns(playersOnPitch.getFirstBatsmanRuns() + runsInInt);
			} else {
				playersOnPitch.setSecondBatsmanRuns(playersOnPitch.getSecondBatsmanRuns() + runsInInt);
			}
			runsInInt = 0;
			swapInt++;
		}

		if (flag == 0) {
			secondInnings.setRunsScored(playersOnPitch.getSecondBatsmanIndex(), playersOnPitch.getSecondBatsmanRuns(),
					playersOnPitch.getSecondBatsmanBalls());
			secondInnings.setRunsScored(playersOnPitch.getFirstBatsmanIndex(), playersOnPitch.getFirstBatsmanRuns(),
					playersOnPitch.getFirstBatsmanBalls());
		}

		System.out.println(secondInnings.getBatting());

		System.out.println();
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------");
		System.out.println();

		System.out.println(secondInnings.getBowling());

		System.out.println("Score of second innings : " + totalRuns + "/" + noOfWickets);

		System.out.println();
		System.out.println();
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();

		if (totalRuns < firstRuns) {
			System.out.println(match.getFirstBattingTeam().getName() + " won! ");
		} else if (totalRuns > firstRuns) {
			System.out.println(match.getFirstBowlingTeam().getName() + " won! ");
		} else {
			System.out.println("Draw!");
		}

	}

	public static void swapBatsman(PlayersOnPitch playersOnPitch) {
		int temp = playersOnPitch.getFirstBatsmanIndex();
		playersOnPitch.setFirstBatsmanIndex(playersOnPitch.getSecondBatsmanIndex());
		playersOnPitch.setSecondBatsmanIndex(temp);
	}

	public static String runsScoredInABall() {
		int randomVal = random.nextInt(8);
		if (randomVal <= 6)
			return String.valueOf(randomVal);
		else
			return "W";
	}

	public static void tossResults(Match match, Team winningTeam, Team lossingTeam) {
		System.out.println(winningTeam.getName() + " won the toss! \n" + winningTeam.getCaptain()
				+ " what will you choose bat/field ?");
		match.setTossChoice(sc.next());
		if (match.getTossChoice().equals("bat")) {
			match.setFirstBattingTeam(winningTeam);
			match.setFirstBowlingTeam(lossingTeam);
		} else {
			match.setFirstBattingTeam(lossingTeam);
			match.setFirstBowlingTeam(winningTeam);
		}
		System.out.println(winningTeam.getName() + " won the toss and choose to " + match.getTossChoice());
	}

	public static int toss() {
		int tossVal = random.nextInt(2);
		return tossVal;
	}

	public static Team inputTeamDetails(int teamNo) {
		Team team = new Team();
		ArrayList<Player> playerList = new ArrayList<Player>();
		System.out.println("Enter the team " + teamNo + " name : ");
		team.setName(sc.next());
		System.out.println("Enter captain details(first name, last name, age, playerType) : ");
		String fname, lname, age, playerType;
		fname = sc.next();
		lname = sc.next();
		age = sc.next();
		playerType = sc.next();
		Player player = new Player();
		player.setPlayerDetails(fname + " " + lname, age, playerType);
		playerList.add(player);
		team.setCaptain(fname + " " + lname);
		System.out.println("Enter the details of players(first name, last name, age, playerType) : ");
		for (int i = 0; i < 10; i++) {
			fname = sc.next();
			lname = sc.next();
			age = sc.next();
			playerType = sc.next();
			player = new Player();
			player.setPlayerDetails(fname + " " + lname, age, playerType);
			playerList.add(player);
		}
		team.setPlayerList(playerList);
		return team;
	}

}
