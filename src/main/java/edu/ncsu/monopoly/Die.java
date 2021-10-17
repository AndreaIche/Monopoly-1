package edu.ncsu.monopoly;

import java.security.SecureRandom;


public class Die {  
	SecureRandom random= new SecureRandom();
	
	public static double random() {
		return Math.random();
	}

	public int getRoll() {
		return (int)(Die.random() * 6) + 1;
	}
}
