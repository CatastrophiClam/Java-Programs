package March1HmwkCh8;
import java.util.Date;
public class Stopwatch {
	private long startTime;
	private long endTime;
	Date date;
	public Stopwatch(){
		date = new Date();
		startTime = date.getTime();
	}
	
	public void start(){
		date = new Date();
		startTime = date.getTime();
	}
	
	public void stop(){
		date = new Date();
		endTime = date.getTime();
	}
	
	public long getElapsedTime(){
		return endTime - startTime;
	}
}
