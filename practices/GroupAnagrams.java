package com.practices;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class GroupAnagrams {

	public static void main(String[] args) {
		
		new GroupAnagrams().getInputs();
	}

	private void getInputs() {

		Scanner scanner = new Scanner(System.in);
		try {
			
			System.out.print("Enter Length : ");
			int length = scanner.nextInt();
			String[] strings = new String[length];
			System.out.println("Enter Strings ---");
			for(int i = 0;i < length;++i) {
				
				strings[i] = scanner.next();
			}
			anagramsGrouping(strings,length);
		} catch (Exception e) {

			System.out.println("Wrong Input!!!");
		}
	}

	private void anagramsGrouping(String[] strings, int length) {

		Map<String,List<String>> contents = new LinkedHashMap<>();
		for(String s : strings) {
			
			char[] ele = s.toCharArray();
			Arrays.sort(ele);
			String con = new String(ele);
			if(contents.containsKey(con)) {
				
				contents.get(con).add(s);
			}
			else {
				
				List<String> elements = new LinkedList<>();
				elements.add(s);
				contents.put(con, elements);
			}
		}
		System.out.println(new LinkedList<>(contents.values()).toString());
	}
}
