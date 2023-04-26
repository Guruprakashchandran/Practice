package com.questions;

import java.util.Scanner;

public class LongestString {

	int max = 0;
	static String str;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Array Length : ");
		int length = scan.nextInt();
		String[] strs = new String[length];
		boolean[] bool = new boolean[length];
		for (int i = 0; i < length; ++i) strs[i] = scan.next();
		String s = "";
		new LongestString().longString(strs, bool, s);
		System.out.println(str);
		scan.close();
	}

	private void longString(String[] strs, boolean[] bool, String s) {

		for (int i = 0; i < strs.length; ++i) {

			if ((s == "" )|| ((s.charAt(s.length() - 1) + 32 == strs[i].charAt(0)
					|| s.charAt(s.length() - 1) - 32 == strs[i].charAt(0)
					|| s.charAt(s.length() - 1) == strs[i].charAt(0)) && bool[i] == false)) {

				s += strs[i];
				bool[i] = true;
				longString(strs, bool, s);
				if (max < s.length()) {

					str = s;
					max = s.length();
				}
				bool[i] = false;
				s = s.substring(0, s.length() - strs[i].length());
			}
		}
		return;
	}
}