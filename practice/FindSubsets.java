package com.practice;

import java.util.*;

public class FindSubsets {

	public static void main(String[] args) {

		new FindSubsets().getInput();
	}

	private void getInput() {
		Scanner scan = new Scanner(System.in);
		try {

			System.out.print("Enter Length : ");
			int length = scan.nextInt();
			int[] array = new int[length];
			for (int i = 0; i < length; ++i) {

				array[i] = scan.nextInt();
			}
			System.out.print("Enter Sum : ");
			int sum = scan.nextInt();
			List<Integer> list = new LinkedList<>();
			Arrays.sort(array);
			List<List<Integer>> values = new LinkedList<>();
			values = recursionCall(sum, array, list, 0, values);
			System.out.println(values.toString());
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Wrong Input!!!");
		} finally {

			scan.close();
		}
	}

	private List<List<Integer>> recursionCall(int sum, int[] array, List<Integer> list, int i,
			List<List<Integer>> values) {

		if (sum == 0) {

			List<Integer> value = new LinkedList<>();
			for (int j = 0; j < list.size(); ++j) {

				value.add(list.get(j));
			}
			values.add(value);
			return values;
		}
		for (int j = i; j < array.length; ++j) {

			if (sum - array[j] >= 0) {

				list.add(array[j]);
				sum -= array[j];
				values = recursionCall(sum, array, list, j + 1, values);
				sum += list.get(list.size() - 1);
				list.remove(list.size() - 1);
			} else
				return values;
		}
		return values;
	}
}
