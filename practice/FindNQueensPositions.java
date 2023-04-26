package com.practice;

import java.util.Scanner;

public class FindNQueensPositions {

	static int count = 0;
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Board Size : ");
		int bSize = scan.nextInt();
		int[][] board = new int[bSize][bSize];
		new FindNQueensPositions().positionChecking(board,bSize,0);
		System.out.println(count);
		scan.close();
	}

	private void printPattern(int[][] board, int bSize) {

		for(int i = 0;i<bSize;++i) {
			
			for(int j = 0;j<bSize;++j) {
				
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private boolean positionChecking(int[][] board, int bSize, int row) {
		
		if(row>=bSize) {
			count++;
			new FindNQueensPositions().printPattern(board,bSize);
			return true;
		}
		else {
			
			for(int i = 0;i < bSize;++i) {
			
				if(isSafe(board,i,row,bSize)) {
					
					board[row][i] = 1;
					if(positionChecking(board,bSize,row+1)) {
						
						board[row][i] = 0;
					}
				}
			}
			return true;
		}
	}


	private boolean isSafe(int[][] board, int col, int row, int bSize) {

		
		for(int i = col;i>=0;i--) {
			
			if(board[row][i] == 1) {
				
				return false;
			}
		}
		for(int i = row;i>=0;--i) {
			
			if(board[i][col] == 1) {
				
				return false;
			}
		}
		for(int i = row,j = col;i >= 0 && j >= 0;--i,--j) {
			
			if(board[i][j] == 1) {
				
				return false;
			}
		}
		for(int i = row,j = col;i >= 0 && j < bSize;--i,++j) {
			
			if(board[i][j] == 1) {
				
				return false;
			}
		}
		return true;
	}
//	private boolean isSafe(int[][] board, int col, int row, int bSize) {
//		
//		if(col-2 >= 0 && row-1 >= 0 && board[row-1][col-2] == 1) {
//			
//			return false;
//		}
//		if(col-2 >= 0 && row+1 < bSize && board[row+1][col-2] == 1) {
//			
//			return false;
//		}
//		if(row-2 >= 0 && col+1 < bSize && board[row-2][col+1] == 1) {
//			
//			return false;
//		}
//		if(row-2 >= 0 && col-1 >= 0 && board[row-2][col-1] == 1) {
//			
//			return false;
//		}
//		if(col+2 < bSize && row-1 >= 0 && board[row-1][col+2] == 1) {
//			
//			return false;
//		}
//		if(col+2 < bSize && row+1 < bSize && board[row+1][col+2] == 1) {
//			
//			return false;
//		}
//		if(row+2 < bSize && col+1 < bSize && board[row+2][col+1] == 1) {
//			
//			return false;
//		}
//		if(row+2 < bSize && col-1 >= 0 && board[row+2][col-1] == 1) {
//			
//			return false;
//		}
//		return true;
//	}
}
