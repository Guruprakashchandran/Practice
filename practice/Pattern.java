package com.practice;

import java.util.*;

public class Pattern {

	public static void main(String[] args) {

		new Pattern().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {

			System.out.print("Enter Input : ");
			int n = scan.nextInt();
			patternPrinting(n);
		} catch (Exception e) {

			System.out.println("Wrong Input!!!");
		} finally {

			scan.close();
		}
	}

	public void patternPrinting(int n) {

		boolean isReach = false, reachRow = false;
		for (int i = 0; i != -1;) {

			for (int j = 0; j != -1;) {

				System.out.print((j == 0) ? "*" : j);
				isReach = (isReach == false) ? ((j == i) ? true : false) : true;
				j = (isReach == true) ? --j : ++j;
			}
			System.out.println();
			isReach = false;
			reachRow = (reachRow == false) ? ((i == n) ? true : false) : true;
			i = (reachRow == true) ? --i : ++i;
		}
	}
}
