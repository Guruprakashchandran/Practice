package com.practice;

import java.util.*;

public class Permutation {

	public static void main(String[] args) {
		
		new Permutation().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {
			
			System.out.print("Enter length : ");
			int length = scan.nextInt();
			int[] array = new int[length];
			System.out.println("Enter Elements");
			for(int i = 0;i < length;++i) {
				
				array[i] = scan.nextInt();
			}
			permutation(array,length,0,0);
		}
		catch(Exception e) {
			
			System.out.println("Wrong Input!!!");
		}
		finally {
			
			scan.close();
		}
	}

	private void permutation(int[] array, int length, int value, int index) {

		if(value == length) {
			
			System.out.println(Arrays.toString(array));
			return;
		}
		for(int i = index;i<length;++i) {
			
//			System.out.println(Arrays.toString(array));
			swap(array,i,value);
			permutation(array,length,value+1,index+1);
			swap(array,i,value);
		}
	}

	private void swap(int[] array, int i, int value) {
		
		int temp = array[i];
		array[i] = array[value];
		array[value] = temp;
	}
}
