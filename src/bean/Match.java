package bean;

public class Match {

	private Team teamA, teamB;

	private int toss;

	private String tossChoice;

	private Team firstBattingTeam, firstBowlingTeam;

	public Team getFirstBowlingTeam() {
		return firstBowlingTeam;
	}

	public void setFirstBowlingTeam(Team firstBowlingTeam) {
		this.firstBowlingTeam = firstBowlingTeam;
	}

	public Team getFirstBattingTeam() {
		return firstBattingTeam;
	}

	public void setFirstBattingTeam(Team firstBattingTeam) {
		this.firstBattingTeam = firstBattingTeam;
	}

	public String getTossChoice() {
		return tossChoice;
	}

	public void setTossChoice(String tossChoice) {
		this.tossChoice = tossChoice;
	}

	public Team getTeamA() {
		return teamA;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public Team getTeamB() {
		return teamB;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

	public int getToss() {
		return toss;
	}

	public void setToss(int toss) {
		this.toss = toss;
	}

}
