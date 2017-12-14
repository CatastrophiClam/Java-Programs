package March1HmwkCh8;

public class Stock {
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	
	public Stock(String symbol, String name){
		this.symbol = symbol;
		this.name = name;
	}
	
	public double getChangePercent(){
		return (currentPrice - previousClosingPrice)/previousClosingPrice*100;
	}
}
