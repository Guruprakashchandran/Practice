package com.practices;

import java.util.*;

public class JumpGameII {

	private static int minJump = Integer.MAX_VALUE;
	public static void main(String[] args) {

		new JumpGameII().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {

			System.out.print("Enter Array Length : ");
			int length = scan.nextInt();
			System.out.println("Enter Array Elements----");
			int[] array = new int[length];
			for (int i = 0; i < length; ++i) {

				array[i] = scan.nextInt();
			}
			jumps(array, 0, 0, length);
			System.out.println(minJump);
		} catch (Exception e) {
			System.out.println("Wrong Input!!!");
		}
	}

	private void jumps(int[] array, int index, int count, int length) {

		try {

			if (array.length == (index + 1)) {

				if (count < minJump) {

					minJump = count;
				}
				return;
			} else if (array.length <= index) {

				return;
			}
			for (int i = array[index]; i > 0; --i) {

				count++;
				index += i;
				jumps(array, index, count, length);
				index -= i;
				count--;
			}
			return;
		} catch (Exception e) {

			System.out.println("Index Reached!!!");
		}
	}
}
