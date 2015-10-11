import java.util.Scanner;

public class Host {
	Wordbank bank1; 
	private String aWord; 
	private int wordLen = 0; 
	private int numGuesses;
	Scanner read = new Scanner(System.in);
	public Host(){
		bank1 = new Wordbank("A Words.csv", "B Words.csv", "C Words.csv");
		aWord = " ";
		numGuesses = 0; 
	}
	
	public String getWord(){
		aWord = bank1.selectWord();
		wordLen = aWord.length();
		return aWord;
	}
	
	public int getWordLength(){
		return  wordLen;
	}
	
	public int getNumGuesses(){
		return numGuesses;
	}
	
	// Pass total numGuesses to admin
	// so that admin can write them to the user profile
/*
 * The buildWord method will handle user attempts at rebuilding the randomly selected 
 * word. It will do this in the following manner:
 * -Request a guess from user.
 * -Compare user guess to all the characters in the selected word
 * If we find at character match, then the method will add the char to a word[]
 * at the index where it was found in the selected word. 
 */
	public void buildWord(char ch, String word){
		numGuesses = 1;
		int maxTurns = word.length() + 2; 
		char[] yourWord = new char[word.length()];
		char guess = ch;
		int correct = 0; 
		//int incorrect = 0; 
		boolean playOn = true;
		// allow user to take 10 turns
		while( playOn ){
			
			for(int i = 0; i < word.length();i++){
				if( guess == word.charAt(i) ){
					//The makeWord method is a helper method
					// once a match is found, it is called and it adds the char
					// to the yourWordArray
					yourWord[i] = guess; 
					correct++;
				}
			}
			
			// Display current positions of characters
			System.out.println("There are " + correct + " correct characters in the word");
//			System.out.println("Incorrect Guesses: " + incorr);
			System.out.println("Your word at this point is: ");
			for(int i = 0; i < yourWord.length; i++){
				if(yourWord[i] != 0){
					System.out.printf(yourWord[i] + " ");
				}else{
					System.out.printf(" _ ");
				}
			}
			
			if( (numGuesses == maxTurns) && (correct != yourWord.length) ){
				System.out.println("\nSorry no more guesses left.");
				playOn = false;
			}else if(correct != yourWord.length){
			System.out.println("\nYou have " + (maxTurns - numGuesses) + "  more guesses left");	
			System.out.println("Nice work, Guess again: ");
			guess = read.next().charAt(0);
			numGuesses++;				
			}else{
				System.out.println("Good Job!");
				System.out.println("You solved the word puzzle in : " + correct + " turns");
				playOn = false;
			}
			
		}// while
		read.close();
		
	}// buildWord
	
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Word from Host var aWord: " + aWord);
		sb.append("Data from bank1 obj" );
		sb.append(bank1.toString());
		
		return sb.toString();
	}
}// Host
