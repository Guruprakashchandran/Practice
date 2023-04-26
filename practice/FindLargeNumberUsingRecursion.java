package com.practice;

import java.util.Scanner;

public class FindLargeNumberUsingRecursion {

	public static void main(String[] args) {
		
		new FindLargeNumberUsingRecursion().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {
			
			System.out.print("Enter Length : ");
			int length = scan.nextInt();
			int[] value = new int[length];
			for(int i= 0;i<length;++i) {
				
				value[i] = scan.nextInt();
			}
//			findLargeNumber(value);
		}
		catch(Exception e) {
			
			
		}
		finally {
			
			scan.close();
		}
	}
}
