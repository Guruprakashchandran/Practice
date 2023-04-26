package com.practice;

import java.util.*;

public class FibonacciNumber {

	int total = 1;
	public static void main(String[] args) {

		new FibonacciNumber().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {

			System.out.print("Enter Number : ");
			int number = scan.nextInt();
			System.out.println("output : "+(fibonacciNumber(number-1, 0))%10);
		} catch (Exception e) {

			System.out.println("Wrong Input!!!");
		} finally {

			scan.close();
		}
	}

	private int fibonacciNumber(int number, int value) {

		if (number == 0) {

			return 0;
		}
		int temp = total;
		total = total + value;
		value = temp;
//		System.out.println(total);
		fibonacciNumber(number - 1, value);
		return total;
	}
}
