
public class StopWatch {
	
	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = true;
	
	public void start(){
		this.startTime = System.currentTimeMillis();
		this.running = true;
	}
	
	public void stop(){
		this.stopTime = System.currentTimeMillis();
		this.running = false;
	}
	
	public long getElapsedTime(){
		long elapsedTime;
		if(running){
		elapsedTime = ( System.currentTimeMillis() - startTime ) ;
			
		}else{
			elapsedTime = stopTime - startTime; 
		}
		
		return elapsedTime; 
	
}// ElapsedTime MilliSeconds

public long getElapsedTimeSeconds(){
	long elapsedTime;
	if(running){
	elapsedTime =  ( (System.currentTimeMillis() - startTime )/1000) ;
		
	}else{
		elapsedTime = ( ( stopTime - startTime) / 1000 ); 
	}
	
	return elapsedTime; 
	}// ElapsedTime Seconds
}// Stopwatch