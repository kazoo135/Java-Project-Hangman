import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
// This class collects information from the player and writes it to a data file. 
// This class will also be able to read and present the information from the data file. 
public class Administrator {

	// default no args constructor
	public Administrator(){
	}
	

		
		
	public void writeToFile(Player p, String theWord ){
		// prepare to write to txt file
		File file = new File("hangmanData.txt");
		FileWriter filewriter = null;
		BufferedWriter bufferedwriter = null; 
		String dateTime = getDateTime();

		
		try{
			// create new filewriter and bufferedwriter objs
			filewriter = new FileWriter(file, true);
			bufferedwriter = new BufferedWriter(filewriter);
			
			// write data to file
			bufferedwriter.write(dateTime);
			bufferedwriter.newLine();	
			
			bufferedwriter.write("User ID: " + p.getPlayerId());
			bufferedwriter.newLine();
			
			bufferedwriter.write("User Name: " + p.getFirstName() + " " +
			p.getLastName());
			bufferedwriter.newLine();
			
			bufferedwriter.write("The Selected Word: " + theWord);
			bufferedwriter.newLine();
			
		}catch(IOException e){
			// if any IO Exceptions occurr
			System.err.println("Error writing file: " );
			e.printStackTrace();
		}finally {
			// release system resources from stream
			if(bufferedwriter != null && filewriter != null){
				try{
					bufferedwriter.close();
					filewriter.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				
			}
		}		
	} // writeToFile
	
	// modify - add parameters - request - if user request != null, 
	// user has requested their data - then reader needs to retrieve it
	// and present it. 
	public void readFromFIle(int userId )throws IOException{
		String request = Integer.toString(userId); 
		String filename= "hangmanData.txt";
		Scanner read = null; 
			
		// prepare to read from text file
		File file = new File(filename);
		read = new Scanner(file);
		
		// hear is where read needs to find user data by id
		while (read.hasNext()) {
			String line = "";
			if(request.equals(read.nextLine())){
			 line = read.nextLine();
			System.out.println(line);			
			}

			read.close();
		}
		
	} // readFromFile
	
	public String getDateTime(){
		StringBuilder sb = new StringBuilder();
		LocalDateTime now = LocalDateTime.now();
		
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int year = now.getYear();
		int hours = now.getHour();
		int mins = now.getMinute();
		int secs = now.getSecond();
		sb.append("Date: " + month + "/" + day + "/" + year + "\n");
		sb.append("Time: " + hours + ":" + mins + ":" + secs);
		return sb.toString();
		
	}// getDateTime

}// Adminstrator
