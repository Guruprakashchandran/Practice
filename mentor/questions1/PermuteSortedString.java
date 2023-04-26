package com.mentor.questions1;

import java.util.*;

public class PermuteSortedString {

	public static void main(String[] args) {
		
		new PermuteSortedString().getInputs();
	}

	private void getInputs() {

		Scanner scanner = new Scanner(System.in);
		try {
			
			System.out.print("Enter the String : ");
			String str = scanner.next();
			char[] chr = str.toCharArray();
			Arrays.sort(chr);
			permutations(new StringBuffer(new String(chr)),0,0,str.length());
		}
		catch(Exception e) {
			
			System.out.println("\nWrong Input!!");
		}
		finally {
			
			scanner.close();
		}
	}

	private void permutations(StringBuffer stringBuffer, int ind, int l, int length) {

		if(l == length-1) {
			
			System.out.println(stringBuffer.toString());
			return;
		}
		
		for(int i = ind;i<length;++i) {
			
			swap(i,l,stringBuffer);
			permutations(stringBuffer,ind+1,l+1,length);
			swap(i,l,stringBuffer);
		}
	}

	private void swap(int ind, int l, StringBuffer stringBuffer) {

		char temp = stringBuffer.charAt(ind);
		stringBuffer.setCharAt(ind, stringBuffer.charAt(l));
		stringBuffer.setCharAt(l, temp);
	}
}
