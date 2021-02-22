package bean;

public class Player {

	private String name;

	private String age;

	private String playerType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public Player setPlayerDetails(String name, String age, String playerType)
	{
		this.name = name;
		this.age = age;
		this.playerType = playerType;
		return this;
	}
	
}
