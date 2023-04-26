package com.practice;

import java.util.Scanner;
//import java.util.concurrent.atomic.AtomicInteger;

public class WordsGeneration {

	int count = 0;

	public static void main(String[] args) {

//		AtomicInteger in = new AtomicInteger(1);
//		System.out.println(in.incrementAndGet());
		new WordsGeneration().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {

			System.out.print("Enter Number : ");
			int number = scan.nextInt();
			wordsGenerating(number, "");
			System.out.println(count);
		} catch (Exception e) {

			System.out.println("wrong input!!!");
		} finally {

			scan.close();
		}
	}

	private void wordsGenerating(int number, String word) {

		try {

			if (word.length() == number) {
				int countB = 0, countC = 0;
				for (int i = 0; i < word.length(); ++i) {

					if (word.charAt(i) == 'b')
						countB++;
					else if (word.charAt(i) == 'c')
						countC++;
				}
				if (countB <= 1 && countC <= 2) {
					count++;
					System.out.println(word);
				}
				return;
			}
			for (int i = 0; i < number; ++i) {

				word += (char) ('a' + i);
//				System.out.println(word);
				wordsGenerating(number, word);
				word = word.substring(0, word.length() - 1);
			}
			return;
		} catch (Exception e) {

			System.out.println();
		}
	}
}
