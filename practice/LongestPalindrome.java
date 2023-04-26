package com.practice;

import java.util.Scanner;

public class LongestPalindrome {

	void longestPalSubstr(String str)
	{
		int n = str.length();
		if (n < 2) {
			System.out.print("Longest palindrome substring is: ");
			System.out.println(n);
			return;
		}
		int maxLength = 1,start=0;
		int low, high;
		for (int i = 0; i < n; i++) {
			low = i - 1;
			high = i + 1;
			while ( high < n && str.charAt(high) == str.charAt(i)) 								
				high++;
	
			while ( low >= 0 && str.charAt(low) == str.charAt(i)) 				
				low--;
	
			while (low >= 0 && high < n && str.charAt(low) == str.charAt(high) ){
				low--;
				high++;
			}

		int length = high - low - 1;
		if (maxLength < length){
			maxLength = length;
			start=low+1;
		}
	}
	System.out.print("Longest palindrome substring is: ");
	System.out.println(str.substring(start, start + maxLength ));
}

	public static void main(String[] args)
	{

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter String : ");
		String str = scan.next();
		new LongestPalindrome().longestPalSubstr(str);
		scan.close();

	}
}
