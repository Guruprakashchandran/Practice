package com.mentor.questions2;

import java.util.Arrays;
import java.util.Scanner;

public class GenerateAllProducts {

	public static void main(String[] args) {

		new GenerateAllProducts().getInputs();
	}

	private void getInputs() {

		Scanner scanner = new Scanner(System.in);
		try {

			System.out.print("Enter Array Length : ");
			int length = scanner.nextInt();
			int[] array = new int[length];
			System.out.println("Enter Elements");
			for (int i = 0; i < length; ++i) {

				array[i] = scanner.nextInt();
			}
			findingAllProducts(array, length);
		} catch (Exception e) {

			System.out.println("Wrong Input!!!");
		} finally {

			scanner.close();
		}
	}

	private void findingAllProducts(int[] array, int length) {

		try {
			int totalProduct = 1;
			for (int i = 0; i < length; ++i) {

				totalProduct *= array[i];
			}
			System.out.println(totalProduct);
			int[] newArr = new int[length];
			for (int i = 0; i < length; ++i) {

				newArr[i] = totalProduct / array[i];
			}
			System.out.println("Output : " + Arrays.toString(newArr));
		} catch (Exception e) {

			System.out.println("Oops!!Array Index Reached!!!");
		}
	}
}
