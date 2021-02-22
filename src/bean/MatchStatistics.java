package bean;

import java.util.ArrayList;

public class MatchStatistics {

	ArrayList<ScoreCard> firstInningsBatting, secondInningsBatting, firstInningsBowling, secondInningsBowling;

	public ArrayList<ScoreCard> getFirstInningsBatting() {
		return firstInningsBatting;
	}

	public void setFirstInningsBatting(ArrayList<ScoreCard> firstInningsBatting) {
		this.firstInningsBatting = firstInningsBatting;
	}

	public ArrayList<ScoreCard> getSecondInningsBatting() {
		return secondInningsBatting;
	}

	public void setSecondInningsBatting(ArrayList<ScoreCard> secondInningsBatting) {
		this.secondInningsBatting = secondInningsBatting;
	}

	public ArrayList<ScoreCard> getFirstInningsBowling() {
		return firstInningsBowling;
	}

	public void setFirstInningsBowling(ArrayList<ScoreCard> firstInningsBowling) {
		this.firstInningsBowling = firstInningsBowling;
	}

	public ArrayList<ScoreCard> getSecondInningsBowling() {
		return secondInningsBowling;
	}

	public void setSecondInningsBowling(ArrayList<ScoreCard> secondInningsBowling) {
		this.secondInningsBowling = secondInningsBowling;
	}

}
