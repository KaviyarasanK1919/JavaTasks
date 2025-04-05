package task13;
import java.util.Scanner;


interface Playable 
{
	 void play();
	 void pause();
	 void stop();
}

class MP3Player implements Playable {
	
	public static final int MP3_PLAYER = 1;
	
	 public void play() 
	 {
	     System.out.println("MP3 Player is playing...");
	 }
	
	 public void pause() 
	 {
	     System.out.println("MP3 Player is paused.");
	 }
	
	 public void stop() {
	     System.out.println("MP3 Player has stopped.");
	 }
}

class CDPlayer implements Playable {
	
	public static final int CD_PLAYER = 2;
	
	 public void play() 
	 {
	     System.out.println("CD Player is playing...");
	 }
	
	 public void pause() 
	 {
	     System.out.println("CD Player is paused.");
	 }
	
	 public void stop() 
	 {
	     System.out.println("CD Player has stopped.");
	 }
}

class StreamingPlayer implements Playable {
	public static final int STREAMING_PLAYER = 3;
	 public void play() 
	 {
	     System.out.println("Streaming Player is playing...");
	 }
	
	 public void pause() 
	 {
	     System.out.println("Streaming Player is paused.");
	 }
	
	 public void stop() 
	 {
	     System.out.println("Streaming Player has stopped.");
	 }
}

public class MusicPlayerApp {
	public static void main(String[] args) {
	     Scanner sc = new Scanner(System.in);
	     Playable player = null;
	
	     System.out.println("Choose your player:");
	     System.out.println("1. MP3 Player");
	     System.out.println("2. CD Player");
	     System.out.println("3. Streaming Player");
	     System.out.print("Enter your choice: ");
	     int choice = sc.nextInt();
	
	     switch(choice) {
	         case MP3Player.MP3_PLAYER:
	             player = new MP3Player();
	             break;
	             
	         case CDPlayer.CD_PLAYER:
	             player = new CDPlayer();
	             break;
	             
	         case StreamingPlayer.STREAMING_PLAYER:
	             player = new StreamingPlayer();
	             break;
	             
	         default:
	             System.out.println("Please Enter valid choice!");
	             sc.close();
	             return;
	     }
	
	     while(true) {
	         System.out.println("\nWhat would you like to do?");
	         System.out.println("1. Play");
	         System.out.println("2. Pause");
	         System.out.println("3. Stop");
	         System.out.println("4. Exit");
	         System.out.print("Your action: ");
	         int action = sc.nextInt();
	
	         switch(action) {
	             case 1:
	                 player.play();
	                 break;
	             case 2:
	                 player.pause();
	                 break;
	             case 3:
	                 player.stop();
	                 break;
	             case 4:
	                 System.out.println("Exiting player...");
	                 sc.close();
	                 System.exit(0);
	             default:
	                 System.out.println("Invalid action.");
	         }
	     }
	     
	}
}
