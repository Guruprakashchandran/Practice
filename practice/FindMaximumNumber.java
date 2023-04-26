package com.practice;

import java.util.*;

public class FindMaximumNumber {

	public static void main(String[] args) {
		
		new FindMaximumNumber().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {
			
			System.out.print("Enter Length : ");
			int length = scan.nextInt();
			System.out.println("Enter Elements");
			int[] array = new int[length];
			for(int i = 0;i < length;++i) {
				
				array[i] = scan.nextInt();
			}
			getMaxValue(array,length);
		}
		catch(Exception e) {
			
			System.out.println("Wrong Input!!!");
		}
		finally {
			
			scan.close();
		}
	}

	private void getMaxValue(int[] array, int length) {

		String[] s = new String[length];
		for(int i = 0;i<length;++i) {
			
			s[i] = Integer.toString(array[i]);
		}
		Arrays.sort(s);
		List<List<String>> lists = new LinkedList<>();
		for(int i = 0;i<length;i+=lists.get(lists.size()-1).size()) {
			
			int j = i;
			List<String> elements = new LinkedList<>();
			for(;j+1 < length && s[j].charAt(0) == s[j+1].charAt(0);++j) {
				
				elements.add(s[j]);
			}
			elements.add(s[j]);
//			System.out.println(elements.toString());
			lists.add(elements);
		}
		System.out.println(lists.toString());
	}
}
