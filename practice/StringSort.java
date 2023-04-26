package com.practice;

import java.util.Arrays;
import java.util.Scanner;

public class StringSort {

	public static void main(String[] args) {

		new StringSort().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {
			
			System.out.print("Enter Length : ");
			int length = scan.nextInt();
			String[] num = new String[length];
			for(int input = 0,i = 0;i<length;++i) {
				
				input = scan.nextInt();
				num[i] = Integer.toString(input);
			}
			Arrays.sort(num);
			String s = "";
			for(int i = num.length-1;i>=0;--i) {
				
				if(num[i].endsWith("0")) 
					s += num[i];
				else 	
					System.out.print(num[i]);
					
				if( s != "" && ((i == 0) || !(num[i+1].startsWith(s.substring(0,1))))) {
					
					System.out.print(s);
					s = "";
				}
			}
		}
		catch(Exception e) {
			
			System.out.println("Wrong Input!!!");
		}
		finally {
			
			scan.close();
		}
	}
}
