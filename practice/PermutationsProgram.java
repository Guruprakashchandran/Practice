package com.practice;

import java.util.Scanner;

public class PermutationsProgram {

	public static void main(String[] args) {
		
		new PermutationsProgram().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {
			
			System.out.print("Enter String : ");
			String input = scan.next();
			StringBuilder s = new StringBuilder(input);
			permutation(s,0,0);
		}
		catch(Exception e) {
			
			System.out.println("Wrong Input!!!");
		}
		finally {
			
			scan.close();
		}
	}

	private void permutation(StringBuilder s, int index, int value) {

		if(index + 1  == s.length()) {
			
			System.out.println(s);
			return;
		}
		for(int i = index;i<s.length();++i) {
			
			swap(s,i,value);
			permutation(s,index+1,value+1);
			swap(s,i,value);
		}
	}

	private void swap(StringBuilder s, int index, int value) {

		
		char c = s.charAt(index);
		s.setCharAt(index, s.charAt(value));
		s.setCharAt(value, c);
	}
}
