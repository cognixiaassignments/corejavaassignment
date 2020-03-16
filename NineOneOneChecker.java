package com.cognixia.jump.corejava.corejavaassignment;

import java.util.Scanner;

public class NineOneOneChecker {
	public static void main(String[] args) {
		System.out.println("Please enter a phone number: ");
		Scanner sc = new Scanner(System.in);
		String inputPhoneNum = sc.nextLine();
		validatePhoneNumber(inputPhoneNum);
		
		sc.close();
	}
	
	public static void validatePhoneNumber(String phoneNum) {
				if(phoneNum.length() == 10 && phoneNum.chars().allMatch(Character::isDigit) && !phoneNum.contains("911")) {
			System.out.println("This phone number is valid");
		} else if(phoneNum.length() == 14 && phoneNum.indexOf("(") == 0 && phoneNum.indexOf(")") == 4 && phoneNum.indexOf(" ") == 5 
				&& phoneNum.indexOf("-") == 9 && !phoneNum.contains("911") && !phoneNum.contains("9-11") && !phoneNum.contains("91-1")
				&& !phoneNum.contains("-911") && !phoneNum.contains("911-") && !phoneNum.contains("(091) 1") && !phoneNum.contains("(009) 11") && !phoneNum.contains("(911)")) {
			System.out.println("This phone number is valid");
		} else if(phoneNum.length() == 12 && phoneNum.indexOf("-", 3) == 3 && phoneNum.indexOf("-", 7) == 7 
				&& !phoneNum.contains("911") && !phoneNum.contains("9-11") && !phoneNum.contains("91-1") && !phoneNum.contains("-911")
				&& !phoneNum.contains("911-")) {
			System.out.println("This phone number is valid");
		} else {
			System.out.println("Sorry, this phone number is not valid!");
		}
	}
}
