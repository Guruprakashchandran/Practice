package com.practice;

import java.util.Scanner;

public class Encryption {

	public static void main(String[] args) {

		new Encryption().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {

			System.out.print("Enter String : ");
			String en = scan.next(),ch = "";
			int value = 0;
			System.out.print("Output - ");
			for (int i = 0; i < en.length(); ++i) {

				if (en.charAt(i) < 48 || en.charAt(i) > 57) {

					ch += en.charAt(i);
				} else {

					value = (value * 10) + Character.getNumericValue(en.charAt(i));
					if ((i+1 == en.length() )|| ((i + 1 <= en.length()) && (en.charAt(i + 1) < 48 || en.charAt(i + 1) > 57))) {

						for (int j = 0; j < value; ++j) {

							System.out.print(ch);
						}
						ch = "";
						value = 0;
					}
				}
			}
		} catch (Exception e) {

			System.out.println("Wrong Input!!!");
		} finally {

			scan.close();
		}
	}
}
