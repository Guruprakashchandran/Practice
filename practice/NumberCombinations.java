package com.practice;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class NumberCombinations {

	public static void main(String[] args) {
		
		new NumberCombinations().getInputs();
	}

	private void getInputs() {

		Scanner scan = new Scanner(System.in);
		try {
			
			System.out.print("Enter Length : ");
			int length = scan.nextInt();
			int[] array = new int[length];
			for(int i = 0;i<length;++i) {
				
				array[i] = scan.nextInt();
			}
			System.out.print("Enter Target : ");
			int target = scan.nextInt();
			List<List<Integer>> lists = new LinkedList<>();
			List<Integer> list = new LinkedList<>();
			Arrays.sort(array);
			numberCombinations(array,length-1,target,0,lists,list);
			System.out.println(lists.toString());
		}
		catch(Exception e) {
		
			e.printStackTrace();
			System.out.println("Wrong Input!!!");
		}
		finally {
			
			scan.close();
		}
	}
//	[10,1,2,7,6,1,5]
	private void numberCombinations(int[] array, int i, int target, int value, List<List<Integer>> lists,List<Integer> list) {

		if(value == target) {
			
			List<Integer> data= new LinkedList<>();
			boolean isExist = false;
			for(int j = 0;j<lists.size();++j) {
				
				isExist = true;
				for(int k = 0;k<lists.get(j).size();++k) {
					
					if( list.size() > k && list.get(k) != lists.get(j).get(k)) {
						
						isExist = false;
					}
				}
				if(isExist == true) break; 
			}
			if(isExist == false) {
				
				for(int j = 0;j<list.size();++j) {
					
					data.add(list.get(j));
				}
				lists.add(data);
			}
			return;
		}
		for(int j = i;j>=0;j--) {
			
 			if(target >= array[j]+value) {
				
				list.add(array[j]);
				value += array[j];
				numberCombinations(array,j-1,target,value,lists,list);
				value -= array[j];
				list.remove(list.size()-1);
			}
		}
		return;
	}
}
