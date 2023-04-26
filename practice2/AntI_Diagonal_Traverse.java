package com.practice2;

import java.util.*;

public class AntI_Diagonal_Traverse {

	public static void main(String[] args) {

		new AntI_Diagonal_Traverse().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {

			System.out.print("Enter length : ");
			int length = scan.nextInt();
			int[][] array = new int[length][length];
			for(int i = 0;i<length;++i) {
				
				for(int j = 0;j<length;++j) {
					
					array[i][j] = scan.nextInt();
				}
			}
			traverse(array,length);
		} catch (Exception e) {

			System.out.println("Wrong Input!!!");
		}
		finally {
			
			scan.close();
		}
	}

	private void traverse(int[][] array, int length) {

		try {
		
			List<List<Integer>> list = new LinkedList<>();
			for(int i = 0;i < (length*2-1);++i) {
				
				List<Integer> elements = new LinkedList<>();
				int k = (i>length-1) ? i - length + 1 : 0;
				int j = (i>=length) ? length-1 : i;
				for(;j>-1 && k < length ;++k,--j) {
					
					elements.add(array[k][j]);
				}
				list.add(elements);
			}
			System.out.println(list.toString());
		}
		catch(Exception e) {
		
			System.out.println("Index Reached!!!");
		}
	}
}
