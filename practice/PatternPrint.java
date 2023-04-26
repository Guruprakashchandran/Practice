package com.practice;

import java.util.Scanner;

public class PatternPrint {

	public static void main(String[] args) {

		new PatternPrint().pattern();
	}

	private void pattern() {

		Scanner scan = new Scanner(System.in);
		try {

			System.out.print("Enter Size : ");
			int size = scan.nextInt();
			System.out.print("Enter count : ");
			int count = scan.nextInt();
			for (int i = 1; i <= size; ++i) {

				for (int index = 0, j = 1; j <= ((count * size) - (count - 1)); ++j) {

					if ((j / (size - 1) * (index+1)) > 0)
						index = (j+index) / (size);
					if (((j + index) % size) == i || (j - ((size - 1) * index)) == size - i + 1 || i == 1
							|| i == size)
						System.out.print("*  ");
					else
						System.out.print("   ");
				}
				System.out.println();
			}
		} catch (Exception e) {

			System.out.println("Wrong Input!!!");
		} finally {

			scan.close();
		}
	}
}
