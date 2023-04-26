package com.questions;

import java.util.Scanner;

public class PatternPrinting {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int number = scan.nextInt();
		for(int i = 1;i<=number;++i) {
			
			System.out.print(i+"\t");
			for(int value = i,j = 2;j<=i;++j) {
				
				value += number - j + 1;
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		scan.close();
	}
}
