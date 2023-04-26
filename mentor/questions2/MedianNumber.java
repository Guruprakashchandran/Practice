package com.mentor.questions2;

import java.util.Scanner;

public class MedianNumber {

	private int pos1 = 0, pos2 = 0;
	private int val1 = 0, val2 = 0;
	private boolean isOdd = true;
	private int aver;

	public static void main(String[] args) {

		new MedianNumber().getInputs();
	}

	private void getInputs() {

		Scanner scanner = new Scanner(System.in);
		try {

			System.out.print("Enter Array 1 Length : ");
			int len1 = scanner.nextInt();
			int[] arr1 = new int[len1];
			for (int i = 0; i < len1; ++i) {

				arr1[i] = scanner.nextInt();
			}
			System.out.print("Enter Array 2 Length : ");
			int len2 = scanner.nextInt();
			int[] arr2 = new int[len2];
			for (int i = 0; i < len2; i++) {

				arr2[i] = scanner.nextInt();
			}
			findMedianNumber(len1, len2, arr1, arr2);
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Wrong Input!!!");
		} finally {

			scanner.close();
		}
	}

	private void findMedianNumber(int len1, int len2, int[] arr1, int[] arr2) {

//		length = len1 < len2 ? len1 : len2;
		if ((len1 + len2) % 2 == 0) {

			isOdd = false;
		}
		aver = (len1 + len2) / 2;

		while (pos1 < len1 || pos2 < len2) {

			if (pos2 < len2 && pos1 < len1) {

				if (arr1[pos1] > arr2[pos2]) {

					getValues(arr2, pos2);
					pos2++;
					aver--;
				} else {

					getValues(arr1, pos1);
					pos1++;
					aver--;
				}
			} else if (pos1 < len1) {

				getValues(arr1, pos1);
				pos1++;
				aver--;
			} else {

				getValues(arr2, pos2);
				pos2++;
				aver--;
			}
			if (val1 != 0 && val2 != 0) {

				break;
			}
		}
		System.out.println(((double) (val1 + val2) / 2));
	}

	private void getValues(int[] arr, int pos) {

		if (isOdd == true && aver == 0) {

			val1 = val2 = arr[pos];

		} else if (isOdd == false && aver == 1) {

			if (val1 != 0) {

				val2 = arr[pos];
			}
			val1 = val1 == 0 ? arr[pos] : val1;
			aver++;
		}
	}
}
