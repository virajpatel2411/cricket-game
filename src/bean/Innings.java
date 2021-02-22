package bean;

import java.util.ArrayList;

public class Innings {

	private Team battingTeam, fieldingTeam;

	private ArrayList<ScoreCard> bowling, batting;

	private ScoreCard scoreCard;

	public Innings(Team battingTeam, Team fieldingTeam) {
		this.battingTeam = battingTeam;
		this.fieldingTeam = fieldingTeam;
		batting = new ArrayList<ScoreCard>(11);
		bowling = new ArrayList<ScoreCard>(5);
		scoreCard = new ScoreCard();
	}

	public void setRunsScored(int index, int runs, int balls) {
		scoreCard = batting.get(index);
		scoreCard.setName(battingTeam.getPlayerList().get(index).getName());
		scoreCard.setRuns(runs);
		scoreCard.setBalls(balls);
		batting.set(index, scoreCard);
	}

	public void addRunsGiven(int index, int runs, int balls) {

		scoreCard = bowling.get(index);
		scoreCard.setName(fieldingTeam.getPlayerList().get(index).getName());
		int runsTillNow = bowling.get(index).getRuns();
		runsTillNow += runs;
		scoreCard.setRuns(runsTillNow);
		int ballsTillNow = bowling.get(index).getBalls();
		ballsTillNow += balls;
		scoreCard.setBalls(ballsTillNow);
		bowling.set(index, scoreCard);

	}

	public Team getBattingTeam() {
		return battingTeam;
	}

	public void setBattingTeam(Team battingTeam) {
		this.battingTeam = battingTeam;
	}

	public Team getFieldingTeam() {
		return fieldingTeam;
	}

	public void setFieldingTeam(Team fieldingTeam) {
		this.fieldingTeam = fieldingTeam;
	}

	public ArrayList<ScoreCard> getBowling() {
		return bowling;
	}

	public void setBowling(ArrayList<ScoreCard> bowling) {
		this.bowling = bowling;
	}

	public ArrayList<ScoreCard> getBatting() {
		return batting;
	}

	public void setBatting(ArrayList<ScoreCard> batting) {
		this.batting = batting;
	}

}
