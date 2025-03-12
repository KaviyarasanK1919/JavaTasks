package Task6ClassAndObject.teamPlayer;

public class Player {
	private String playerId;
    private String name;
    private String position;
    private Team teamID;
    
    
    public Player(String playerId, String name, String position, Team teamID) {
		this.playerId = playerId;
		this.name = name;
		this.position = position;
		this.teamID = teamID;
	}
	
	public String getPlayerId() {
		return playerId;
	}
	public String getName() {
		return name;
	}
	public String getPosition() {
		return position;
	}
	public Team getTeamID() {
		return teamID;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void team(Team teamID) {
		this.teamID = teamID;
	}
	
	@Override
	public String toString() {
		return "PlayerId : " + playerId + ",\n Name : " + name + ",\n Position : " + position + ",\n" + teamID
				+ "\n";
	}
}
