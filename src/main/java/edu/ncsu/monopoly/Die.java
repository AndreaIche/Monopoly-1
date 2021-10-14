package edu.ncsu.monopoly;

public class Die {
	public static double random() {
		return Math.random();
	}

	public int getRoll() {
		return (int)(Die.random() * 6) + 1;
	}
}
