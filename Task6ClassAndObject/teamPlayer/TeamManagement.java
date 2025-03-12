package Task6ClassAndObject.teamPlayer;

public class TeamManagement {
	public static int teamID = 1;
	public static int playerID = 100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Team team1 = new Team(teamID++ +"", "Royal Challengers Benglore", "Virat","division-1");
		Team team2 = new Team(teamID++ +"", "Mumbai Indians", "Rohit Sharama","division-2");
		
		Player player1 = new Player(playerID++ + "", "Kavi", "Top Order", team1);
		Player player2 = new Player(playerID++ + "", "Kanna", "Mid Order", team2);
		
		System.out.println(player1);
		
		System.out.println(player2);
	}

}
