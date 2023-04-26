package com.practice2;

import java.util.Arrays;
import java.util.Scanner;

public class ArranagementForArrayelements {

	public static void main(String[] args) {

		new ArranagementForArrayelements().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {

			System.out.print("Enter Length : ");
			int length = scan.nextInt();
			int[] array = new int[length];
			System.out.println("Enter Elements :");
			for (int i = 0; i < length; ++i) {

				array[i] = scan.nextInt();
			}
			arrangingElements(length, array);
		} catch (Exception e) {

			System.out.println("Wrong Input!!!");
		} finally {

			scan.close();
		}
	}

	private void arrangingElements(int length, int[] arr) {

		try {

			int zero = 0, nonZero = 0, nextZero = 1;
			while (nonZero != arr.length) {

				if (arr[zero] != 0 && arr[nonZero] == 0)
					zero = nonZero;

				else if (arr.length > 1 && arr[nextZero] != 0 && arr[nonZero] == 0)
					nextZero = nonZero;

				else if (arr[nonZero] != 0 && arr[zero] == 0) {

					arr[zero] = arr[nonZero];
					arr[nonZero] = 0;
					if (arr[nextZero] == 0) {

						zero = nextZero;
						nextZero = zero + 1;
					} else
						zero = nonZero;
				}
				nonZero++;
			}
			System.out.println(Arrays.toString(arr));

		} catch (Exception e) {

			System.out.println("Array Index Reached!!!");
		}
	}
}
