package com.mentor.questions2;

import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class StringSequences {

	public static void main(String[] args) {

		new StringSequences().getInput();
	}

	private void getInput() {

		Scanner scanner = new Scanner(System.in);
		try {

			System.out.print("Enter String - ");
			String input = scanner.next();
			findSequences(input);
		} catch (Exception e) {

			System.out.println("Wrong Input!!!");
		} finally {

			scanner.close();
		}
	}

	private void findSequences(String input) {

		try {

			int isExistCount = 0;
			Map<Character, Integer> sequences = new LinkedHashMap<>();
			for (int i = 0; i < input.length(); ++i) {

				if(sequences.containsKey(input.charAt(i))) {
					
					isExistCount++;
					sequences.remove(input.charAt(i));
					sequences.put(input.charAt(i), 1);
				}
				else {
					
					sequences.put(input.charAt(i), 0);
				}
			}
			if(isExistCount > 1) {
				
				System.out.print("Repeated Subsequence Exists (");
				for(Entry<Character, Integer> entry : sequences.entrySet()) {
					
					System.out.print(entry.getValue() > 0 ? (entry.getKey()+" ") : "");
				}
				System.out.print(" repeated ) ");
			}
			else {
				
				System.out.print(" Repeated Subsequence Doesn't Exist");
			}
		} catch (Exception e) {

			System.out.println("Index Reached!!!");
		}
	}
}
