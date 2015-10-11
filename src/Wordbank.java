import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Wordbank{
	private String[] words = new String[100000];
	private final int NUM_FILES = 3;
	private File[] files = new File[NUM_FILES];
	Scanner scan = null;
	private int numWords = 0; 
	private int wordId;
	private long timeToReadWords = 0;
	
	
	
	// default no args constructor
	public Wordbank(){
		
	}
	//  constructor takes filenames an initializes them to File[]
	public Wordbank(String file0, String file1, String file2){
		files[0] = new File(file0);
		files[1] =  new File(file1);
		files[2] = new File(file2);
		
		// initialize the wordbank
		this.readWords();
	}
	
	
	public void readWords(){
		StopWatch sw = new StopWatch();
	
	try{
 		sw.start();
		for(int i = 0; i < files.length; i++){
			
		scan = new Scanner(files[i]);
		
			while(scan.hasNext()){
				// fill words array with words from file
				words[numWords] = scan.next();
				numWords++; 
			}	
			
		}
		sw.stop();
		timeToReadWords =  sw.getElapsedTime(); 
		
	}catch( FileNotFoundException e)
		{
		
		System.err.println("Unable to locate file");
		
		}
		finally
		{
			if(scan != null)
				scan.close();
		}
	
	}//getWord
	
	//Randomly select a word  the words array
	public String selectWord(){
		// this var will hold the random word
		String word = "";
		Random generator = new Random();	
		int bound = numWords;
		// generate a random number 0 - words.length
		int selected = generator.nextInt(bound);
		wordId = selected;
		
		word = words[selected];	
		return word; 	
	}// selectWord
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("The total words in the bank are: " + numWords + "\n");
		sb.append("The length of the words array is: " + words.length + "\n");
		sb.append("Time in milliseconds to read all the words from files: " + timeToReadWords + "ms\n");
		sb.append("The word selected is at index: " + wordId);
		return sb.toString();
	}
}// Wordbank
