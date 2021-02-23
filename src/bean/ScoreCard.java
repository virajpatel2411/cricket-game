package bean;

public class ScoreCard {

	private String name;

	private int runs;

	private int balls;

	public ScoreCard() {

	}

	public ScoreCard(String name, int runs, int balls) {
		this.name = name;
		this.runs = runs;
		this.balls = balls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	@Override
	public String toString() {
		return this.name + " : " + this.runs + " ( " + this.balls + " )";
	}

}
