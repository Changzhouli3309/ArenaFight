package se.lexicon.Li.ArenaFight;

import java.util.*;

public class FixInt {
	
	private static Scanner scan= new Scanner(System.in);
	private static Random ran= new Random();

	/**
	 * Get a random integer with range between max and min
	 * @param max :Highest number (include)
	 * @param min :Lowest number	(include)
	 * @return A random number
	 */
	public static int randomInt (int max,int min) {
		int re = ran.nextInt(max-min)+min;
		return re;
	}
	
	/**
	 * Check the string is number with in range of Integer or not, until you get a valid number
	 * @return :a valid number
	 */
	public static int getInt() {
    	boolean valid = false;
    	int number = 0;
    	while(!valid) {
    		try {
        		number =Integer.parseInt(scan.nextLine());
        		valid = true;
        	}catch(NumberFormatException e) {
        		System.out.println("You did not enter a valid number(int)");
        	}
    	}
    	return number;    	
    }
	
/**
 * keep asking for number until you put right number from limit
 * @param max :Highest number (include)
 * @param min :Lowest number (include)
 * @return A valid number
 */
	public static int getIntFromLimit(int max, int min) {
		int re=0;
		boolean valid = false;
		while(!valid) {
			re=getInt();
			if (re>=min&&re<=max) {
				valid=true;				
			}
			if(!valid) {
				System.out.println("You did not enter a valid number(int)");
			}
    	}
		return re;
	}
	
/**
 * keep asking for number until you put right number from limit
 * @param max :Highest number
 * @param min :Lowest number
 * @param with :Boolean that decides max and min are inclusive or not
 * @return	A valid number
 */
	public static int getIntFromLimit(int max, int min,boolean with) {
		int re=0;
		boolean valid = false;
		while(!valid) {
			re=getInt();
			if (re>=min&&re<=max) {
				valid=true;
				if (!with) {
					if (re==min||re==max) {
						valid=false;
					}
				}
			}
			if(!valid) {
				System.out.println("You did not enter a valid number(int)");
			}
    	}
		return re;
	}

	/**
	 * Print integer part of doubled number
	 * @param n: double n
	 * @return String of the number
	 */
	public static String printN(double n) {
		String s = ""+(int)n;
		return s;
	}
	
	/**
	 * add 0 before the number if it is too short
	 * @param n :The number to fix
	 * @param max :How many number of digits that you want
	 * @return String of the number
	 */
	public static String addZero(int n,int max) {
    	String s="";
    	int b=n;
    	    	
    	for(;(max/10)>0;max/=10) {
    		b/=10;
    		if(b==0) {
    			s+="0";
    		}
    	}
    	return s+n;
    }
	
	/**
	 * add space after the number if it is too short
	 * @param n :The number to fix
	 * @param max :How many number of digits that you want
	 * @return String of the number
	 */
	public static String addSpace(int n,int max) {
    	String s="";
    	int b=n;
    	    	
    	for(;(max/10)>0;max/=10) {
    		b/=10;
    		if(b==0) {
    			s+=" ";
    		}
    	}
    	return n+s;
    }
}
