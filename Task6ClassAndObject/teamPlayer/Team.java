package Task6ClassAndObject.teamPlayer;

public class Team {
	private String teamId;
    private String teamName;
    private String coachName;
    private String division;
    
	public Team(String teamId, String teamName, String coachName, String division) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.coachName = coachName;
		this.division = division;
	}
	public String getTeamId() {
		return teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public String getCoachName() {
		return coachName;
	}
	public String getDivosion() {
		return division;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	public void setDivosion(String divosion) {
		this.division = divosion;
	}
	
	@Override
	public String toString() {
		return "TeamId : " + teamId + ",\n TeamName : " + teamName + ",\n CoachName : " + coachName + ",\n Divosion : "
				+ division + "\n";
	}
    
}
