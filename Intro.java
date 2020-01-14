//testing the ability to take a given file and read the HTML-embedded code

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class Intro {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Input a stock symbol. For example: GOOG, AMZN, TWTR : ");
		Scanner scan = new Scanner(System.in);
		String sym = scan.nextLine();
		
		
		URL url = new URL("https://finance.yahoo.com/quote/" + sym + "?p=" + sym + "&.tsrc=fin-srch");
		
		URLConnection uc = url.openConnection();
		InputStreamReader inStream = new InputStreamReader(uc.getInputStream());
		BufferedReader b = new BufferedReader(inStream);
		
		
		String l = b.readLine();
		
		
		while(l!=null) {
			System.out.println(l); {
				l = b.readLine();
		
			}
		
		}
	}
}
	


/* 

general idea

1. be able to input a desired share price value
2. be recommended stocks to buy based upon percent change






*/