package com.practice;

import java.util.Scanner;

public class UniquePaths {

	public static void main(String[] args) {
		
		new UniquePaths().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {
			
			System.out.print("Wnter m value : ");
			int m = scan.nextInt();
			System.out.print("Wnter n value : ");
			int n = scan.nextInt();
			int[][] array = new int[m][n];
			System.out.println(paths(array,0,0,m,n,0));
		}
		catch(Exception e) {
			
			System.out.println("Wrong Input!!!");
		}
		finally {
			
			scan.close();
		}
	}

	private int paths(int[][] array, int i, int j, int m, int n, int count) {

		if(i == m  || j == n) {
			
			count++;
			return count;
		}
		paths(array,i,j++,m,n,count);
		paths(array,i++,0,m,n,count);
		return count;
	}
}
