package com.practice;

import java.util.Scanner;

public class FactorialInRecursion {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Input : ");
		int input = scan.nextInt();
		int value = new FactorialInRecursion().recursiveCall(input);
		System.out.println("Value : " + value);
		scan.close();
	}
	private int recursiveCall(int input) {

		if (input < 2) {

			return input;
		} else {

			return input + recursiveCall(input - 1);
		}
	}
}
