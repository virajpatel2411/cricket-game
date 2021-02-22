package bean;

public class Match {

	// 20 Over match
	
	private Team teamA, teamB;

	private int toss; // 0 - Team A ... 1 - Team B

	private String tossChoice;

	private String firstBattingTeam;

	public String getFirstBattingTeam() {
		return firstBattingTeam;
	}

	public void setFirstBattingTeam(String firstBattingTeam) {
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
