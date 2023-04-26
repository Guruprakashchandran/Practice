package com.practice2;

import java.util.*;

public class ArraySortInFrequency {

	public static void main(String[] args) {

		new ArraySortInFrequency().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {

			System.out.print("Enter Length : ");
			int length = scan.nextInt();
			int[] array = new int[length];
			System.out.println("Enter Elements :");
			for(int i = 0;i < length;++i) {
				
				array[i] = scan.nextInt();
			}
//			int length = 11;
//			int[] array = { 2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12 };
//			sorting(length, array);
		} catch (Exception e) {

			System.out.println("Wrong Input!!!");
		} finally {

			scan.close();
		}
	}

	private void sorting(int length, int[] array) {

		try {

			List<Integer> elements = new LinkedList<>();
			List<Integer> count = new LinkedList<>();
			for (int i = 0; i < length; ++i) {

				if (!elements.contains(array[i])) {

					elements.add(array[i]);
					count.add(countingNumber(i, length, array));
				}
			}
			sortingCountSize(count, elements);
			printArrayElements(count, elements, length);
		} catch (Exception e) {

			System.out.println("Array Index Reached!!!");
		}
	}

	private void sortingCountSize(List<Integer> count, List<Integer> elements) {

		for (int i = 0; i < count.size(); ++i) {

			for (int j = i + 1; j < count.size(); ++j) {

				if (count.get(i) <= count.get(j)) {

					swapElements(count, elements, i, j);
				}
			}
		}
	}

	private void swapElements(List<Integer> count, List<Integer> elements, int i, int j) {

		if (count.get(i) < count.get(j)) {

			count.set(i, count.get(i) + count.get(j));
			count.set(j, count.get(i) - count.get(j));
			count.set(i, count.get(i) - count.get(j));

			elements.set(i, elements.get(i) + elements.get(j));
			elements.set(j, elements.get(i) - elements.get(j));
			elements.set(i, elements.get(i) - elements.get(j));
		} else if (count.get(i) == count.get(j) && elements.get(i) > elements.get(j)) {

			elements.set(i, elements.get(i) + elements.get(j));
			elements.set(j, elements.get(i) - elements.get(j));
			elements.set(i, elements.get(i) - elements.get(j));

		}
	}

	private void printArrayElements(List<Integer> count, List<Integer> elements, int length) {

		try {

			int[] newArray = new int[length];
			int i = 0;
			for (int j = 0; j < elements.size(); ++j) {

				for (int k = 0; k < count.get(j); ++k, i++) {

					newArray[i] = elements.get(j);
				}
			}
			System.out.println("OutPut : "+Arrays.toString(newArray));
		} catch (Exception e) {

			System.out.println("Index Reached!!!");
		}
	}

	private int countingNumber(int i, int length, int[] array) {

		try {
			int count = 1;
			for (int j = i + 1; j < length; ++j) {

				count = (array[i] == array[j]) ? ++count : count;
			}
			return count;
		} catch (Exception e) {

			System.out.println("Array Length Reached!!!");
		}
		return 0;
	}
}