import java.util.Random;

public class Player {
	private int playerId;
	private String firstname;
	private String lastname;
	private static int playerCount = 0; 
	
	public Player(String fname, String lname){
		playerId = setPlayerId();
		firstname = fname;
		lastname = lname;
		playerCount++;
		
	}
	
	// used in Player constructor
	private int setPlayerId(){
		Random generator = new Random();
		int id = generator.nextInt(100000000);
		return id;
			}
	
	public int getPlayerId(){
		return playerId; 
	}
	public int getPlayerCount(){
		return playerCount; 
	}
	public String makeFullName(){
		
		return  firstname + " " + lastname;
	}
	
	public String getFirstName(){
		return firstname;
	}
	
	public String getLastName(){
		return lastname;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Player Name: " + makeFullName()  +  "\n");
		sb.append("Player Id:" + playerId);
		return sb.toString();
	}
	
}// Player
