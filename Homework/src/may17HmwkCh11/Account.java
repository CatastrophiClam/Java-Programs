package may17HmwkCh11;
import java.util.Date;
public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	private String name;
	
	public Account(){
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		dateCreated = new Date();
	}
	
	public Account(int id, double balance){
		this.id = id;
		this.balance = balance;
		annualInterestRate = 0;
		dateCreated = new Date();
	}
	
	public Account(String name, int id, double balance){
		this.name = name;
		this.id = id;
		this.balance = balance;
		annualInterestRate = 0;
		dateCreated = new Date();
	}
	
	public Date getDateCreated(){
		return dateCreated;
	}
	
	public double getMonthlyInterestRate(){
		return annualInterestRate/12;
	}
	
	public double getMonthlyInterest(){
		return annualInterestRate*balance/1200;
	}
	
	public void deposit(double amount){
		balance += amount;
	}
}
