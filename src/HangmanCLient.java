import java.util.Scanner;

public class HangmanCLient {

	public static void main(String[] args) {
		Host theHost = new Host();
//		Administrator admin = null;
		// Get Player input
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter firstname: ");
		String fname = scan.nextLine();
		System.out.println("Enter last name");
		String lname = scan.nextLine();
		// instantiate new player
		Player player1 = new Player(fname, lname);	
		System.out.println(player1);
		
		System.out.println("***********************************");
		// instantiate a host obj and Administrator Object
		String word = theHost.getWord();

//		admin = new Administrator();
//		admin.writeToFile(player1, word);
		
		System.out.println( "The word is: " + word );
		System.out.println("Hello " + player1.getFirstName());		
		System.out.println("The length of the word is: " + theHost.getWordLength() + " characters.");
		System.out.println("You will have a total of " + ( theHost.getWordLength() + 2) + " guesses to solve the word"); 
		System.out.println("It's time to play Hangman. Make a guess:");
		char c = scan.next().charAt(0);
		theHost.buildWord(c , word);
		System.out.println();
		
		
		//Display wordbank info
		System.out.println("Calling Host toString() which calls wordbank toString()");
		System.out.println(theHost);
		

		scan.close();
	}// main

} // Hangman Client
