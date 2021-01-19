package com.qa.ims.utils;

import java.util.Scanner;

public class Utils {
	
	private Utils () {
		
	}

	public static String getInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public static double getDouble() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}

}
