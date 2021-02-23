package bean;

public class PlayersOnPitch {

	private int firstBatsmanIndex, secondBatsmanIndex, bowlerIndex, firstBatsmanRuns, secondBatsmanRuns,
			firstBatsmanBalls, secondBatsmanBalls;

	public PlayersOnPitch() {

		this.firstBatsmanIndex = 0;
		this.secondBatsmanIndex = 1;
		this.secondBatsmanRuns = 0;
		this.firstBatsmanRuns = 0;
		this.bowlerIndex = 0;
		this.firstBatsmanBalls = 0;
		this.secondBatsmanBalls = 0;
	}

	public int getFirstBatsmanBalls() {
		return firstBatsmanBalls;
	}

	public void setFirstBatsmanBalls(int firstBatsmanBalls) {
		this.firstBatsmanBalls = firstBatsmanBalls;
	}

	public int getSecondBatsmanBalls() {
		return secondBatsmanBalls;
	}

	public void setSecondBatsmanBalls(int secondBatsmanBalls) {
		this.secondBatsmanBalls = secondBatsmanBalls;
	}

	public int getFirstBatsmanIndex() {
		return firstBatsmanIndex;
	}

	public void setFirstBatsmanIndex(int firstBatsmanIndex) {
		this.firstBatsmanIndex = firstBatsmanIndex;
	}

	public int getSecondBatsmanIndex() {
		return secondBatsmanIndex;
	}

	public void setSecondBatsmanIndex(int secondBatsmanIndex) {
		this.secondBatsmanIndex = secondBatsmanIndex;
	}

	public int getBowlerIndex() {
		return bowlerIndex;
	}

	public void setBowlerIndex(int bowlerIndex) {
		this.bowlerIndex = bowlerIndex;
	}

	public int getFirstBatsmanRuns() {
		return firstBatsmanRuns;
	}

	public void setFirstBatsmanRuns(int firstBatsmanRuns) {
		this.firstBatsmanRuns = firstBatsmanRuns;
	}

	public int getSecondBatsmanRuns() {
		return secondBatsmanRuns;
	}

	public void setSecondBatsmanRuns(int secondBatsmanRuns) {
		this.secondBatsmanRuns = secondBatsmanRuns;
	}
}
