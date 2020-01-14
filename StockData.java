import java.io.BufferedOutputStream;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class StockData {
	
	String sym;
	
	public StockData(String s) {
		
		sym = s;	
	}
	
	public String toString() {
		return sym;
	}
	
	public String getName() throws IOException{
		
		
		
		URL url = new URL("https://finance.yahoo.com/quote/" + sym + "?p=" + sym + "&.tsrc=fin-srch");
		
		URLConnection uc = url.openConnection();
		InputStreamReader inStream = new InputStreamReader(uc.getInputStream());
		BufferedReader b = new BufferedReader(inStream);
		
		
		String l = b.readLine();
		
		
		while(l!=null) {
			if (l.contains("pageData\":{")) {
				int target = l.indexOf("pageData\":{");
				int firstNum = target+20;
				String x = "";
				
				while(Character.isLetter(l.charAt(firstNum)) || l.charAt(firstNum)== '.' || l.charAt(firstNum)== '-' || l.charAt(firstNum)== '&' ||  l.charAt(firstNum)== ',' ||  l.charAt(firstNum)== ' ') {
					x += l.charAt(firstNum);
					firstNum ++;

				}
				
				if (x.equals("Symbol Lookup from Yahoo Finance")) {
					System.out.println("Invalid input");
					return "You did not input a valid symbol";

				}
				System.out.println("You selected " + x + " as your stock.");
			}
			l = b.readLine();
			
		}
		return l;
	}
	
						
		public String getShareValue() throws IOException{
			
						
			URL url = new URL("https://finance.yahoo.com/quote/" + sym + "?p=" + sym + "&.tsrc=fin-srch");
			
			URLConnection uc = url.openConnection();
			InputStreamReader inStream = new InputStreamReader(uc.getInputStream());
			BufferedReader b = new BufferedReader(inStream);
			
			
			String l = b.readLine();
			
			
			while(l!=null) {
				if (l.contains("\"currentPrice\"")) {
					int target = l.indexOf("currentPrice");
					int dec = l.indexOf(".", target);
					int firstNum = target+21;
					String x = "";
					
					while(l.charAt(firstNum)== '.' || l.charAt(firstNum)== '0' || l.charAt(firstNum)== '1' || l.charAt(firstNum)== '2' || l.charAt(firstNum)== '3' || l.charAt(firstNum)== '4' || l.charAt(firstNum)== '5' || l.charAt(firstNum) == '6' || l.charAt(firstNum)== '7' || l.charAt(firstNum)== '8' || l.charAt(firstNum)== '9') {
						x += l.charAt(firstNum);
						firstNum ++;

					}
					
						
					System.out.println("This stock is currently valued at " + x + " per share.");
				}
				l = b.readLine();
				
			}
			return l;
		}
			
		
	public String marketChange() throws IOException{
			
			
			URL url = new URL("https://finance.yahoo.com/quote/" + sym + "?p=" + sym + "&.tsrc=fin-srch");
			
			URLConnection uc = url.openConnection();
			InputStreamReader inStream = new InputStreamReader(uc.getInputStream());
			BufferedReader b = new BufferedReader(inStream);
			
			
			String l = b.readLine();
			
			
			while(l!=null) {
				if (l.contains("regularMarketChange")) {
					int target = l.indexOf("regularMarketChange");
					int firstNum = target+28;
					String x = "";
					
					while(l.charAt(firstNum)== '.' || l.charAt(firstNum)== '-'|| l.charAt(firstNum)== '0' || l.charAt(firstNum)== '1' || l.charAt(firstNum)== '2' || l.charAt(firstNum)== '3' || l.charAt(firstNum)== '4' || l.charAt(firstNum)== '5' || l.charAt(firstNum) == '6' || l.charAt(firstNum)== '7' || l.charAt(firstNum)== '8' || l.charAt(firstNum)== '9') {
						x += l.charAt(firstNum);
						firstNum ++;

					}
					
					if (x.equals("0.022999883")) {
						return("Invalid input");
					}
							
					System.out.println("This stock changed by " + x + " today.");
				}
				l = b.readLine();
				
			}
			return l;
		}
	
	public String percentChange() throws IOException{
		
		
		
		URL url = new URL("https://finance.yahoo.com/quote/" + sym + "?p=" + sym + "&.tsrc=fin-srch");
		
		URLConnection uc = url.openConnection();
		InputStreamReader inStream = new InputStreamReader(uc.getInputStream());
		BufferedReader b = new BufferedReader(inStream);
		
		
		String l = b.readLine();
		
		
		while(l!=null) {
			if (l.contains("regularMarketChangePercent")) {
				int target = l.indexOf("regularMarketChangePercent");
				int firstNum = target+35;
				String x = "";
				
				while(l.charAt(firstNum)== '-' || l.charAt(firstNum)== '.' || l.charAt(firstNum)== '0' || l.charAt(firstNum)== '1' || l.charAt(firstNum)== '2' || l.charAt(firstNum)== '3' || l.charAt(firstNum)== '4' || l.charAt(firstNum)== '5' || l.charAt(firstNum) == '6' || l.charAt(firstNum)== '7' || l.charAt(firstNum)== '8' || l.charAt(firstNum)== '9') {
					x += l.charAt(firstNum);
					firstNum ++;

				}
				
				if (x.equals("1.2602675")) {
					return "Invalid input";
				}
									
				System.out.println("This stock changed by " + x + "% today.");
			}
			l = b.readLine();
			
		}
		return l;
	}
		
	
	
	public static void main(String[] args) throws IOException{
		System.out.println("How many stocks would you like to input (10 or less stocks)? ");
		Scanner scan = new Scanner (System.in);
		
				
		int arraySize = scan.nextInt();

		if (arraySize == 1) {
			System.out.println("Input the symbol of the stock that you would like to view. For example, AAPL for Apple, GOOG for Google, etc: ");
		}
		
		else if (arraySize < 1 || Character.isDigit(arraySize)) {
			System.out.println("Please enter a valid input");
		}
		
		else if (arraySize > 10) {
			System.out.println("The limit of stocks to input is 10.");
		}
		else {
			System.out.println("Input the symbol of the " + arraySize + " stocks that you would like to view. For example, AAPL for Apple, GOOG for Google, etc: ");
		}
		

		StockData[] array = new StockData[arraySize] ;
	
		for (int i = 0; i < array.length; ++i) {
			String symbol = scan.next();
				
			
			StockData stocks = new StockData(symbol);
			array[i] = stocks;
			
		}
		
		for (StockData stocks : array) {
			
				stocks.getName();
				stocks.getShareValue();
				stocks.marketChange();
				stocks.percentChange();
			
			
		}
		
		
		//stocks.getName(); 
		//stocks.getShareValue();
		//stocks.marketChange();
		//stocks.percentChange();
	}
}


	
	
