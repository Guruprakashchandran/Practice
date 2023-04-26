package com.practice;

import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		try {
	
			System.out.print("Enter Length : ");
			int length = scan.nextInt();
			System.out.println(length);
		}catch(Exception e) {
			
			System.out.println("Wrong Input!!!");
		}finally {
			
			scan.close();
		}
	}
}
