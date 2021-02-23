package bean;

import java.util.ArrayList;

public class Innings {

	private Team battingTeam, fieldingTeam;

	private ArrayList<ScoreCard> bowling, batting;

	private ScoreCard scoreCard;

	private ArrayList<Integer> oversBowledByBowler;

	public ScoreCard getScoreCard() {
		return scoreCard;
	}

	public void setScoreCard(ScoreCard scoreCard) {
		this.scoreCard = scoreCard;
	}

	public ArrayList<Integer> getOversBowledByBowler() {
		return oversBowledByBowler;
	}

	public void setOversBowledByBowler(ArrayList<Integer> oversBowledByBowler) {
		this.oversBowledByBowler = oversBowledByBowler;
	}

	public Innings(Team battingTeam, Team fieldingTeam) {
		this.battingTeam = battingTeam;
		this.fieldingTeam = fieldingTeam;
		this.batting = new ArrayList<ScoreCard>();
		for (int i = 0; i < 11; i++)
			this.batting.add(new ScoreCard(battingTeam.getPlayerList().get(i).getName(), 0, 0));
		this.bowling = new ArrayList<ScoreCard>();
		for (int i = 0; i < 5; i++)
			this.bowling.add(new ScoreCard(fieldingTeam.getPlayerList().get(i + 6).getName(), 0, 0));
		this.oversBowledByBowler = new ArrayList<Integer>(5);
		for (int i = 0; i < 5; i++)
			this.oversBowledByBowler.add(0);
		this.scoreCard = new ScoreCard();
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
		scoreCard.setName(fieldingTeam.getPlayerList().get(index + 6).getName());
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
