package March1HmwkCh8;

public class Fan {
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;
	private int speed;
	private boolean on;
	private double radius;
	private String color;
	
	public Fan(){
		speed = SLOW;
		on = false;
		radius = 5;
		color = "Blue";
	}
}
