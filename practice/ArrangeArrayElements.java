package com.practice;

import java.util.Arrays;

public class ArrangeArrayElements {

	public static void main(String[] args) {

		new ArrangeArrayElements().elementsArrange();
	}

	private void elementsArrange() {

		int zero = 0, nonZero = 0, nextZero = 1;
//		int[] arr = { 1, 2, 0, 4, 0, 5, 0, 3, 8 };
		int[] arr = {0,1,0,2,3,0,-4};

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
	}
}
