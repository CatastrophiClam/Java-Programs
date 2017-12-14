package aug09HmwkCh20;

public class StopWatch {
	private long startTime;
	private long endTime;
	public StopWatch(){
		
	}
	
	public void start(){
		startTime = System.currentTimeMillis();
	}
	
	public void stop(){
		endTime = System.currentTimeMillis();
	}
	
	public long timeElapsed(){
		return endTime - startTime;
	}
}
