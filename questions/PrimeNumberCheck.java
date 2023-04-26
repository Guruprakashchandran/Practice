package com.questions;

import java.util.Scanner;

public class PrimeNumberCheck {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Input : ");
		int input = scan.nextInt();
		int value = input + 1;
		String s1 = "", s2 = "";
		boolean isExist = true;
		while (isExist) {
			for (int j = 2; j < value / 2; ++j) {
				if (value % j == 0) {
					isExist = false;
					break;
				}
			}
			isExist = isExist != false ? false : true;
			value++;
		}
		value--;
		input = input % 2 == 1 ? input + 1 : input + 2;
		for (int i = input; i < value; i += 2)
			s1 += i + ",";
		for (int i = value - 2; i > input; i -= 2)
			s2 += i + ",";
//		StringBuffer s3 = new StringBuffer(s1), s4 = new StringBuffer(s2);
		if (s1.length() > 0)
			System.out.println("Even Number : " + s1.substring(0, s1.length() - 1));
		if (s2.length() > 0)
			System.out.println("Odd Number : " + s2.substring(0, s2.length() - 1));
		scan.close();
	}
}
