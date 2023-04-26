package com.practice;

import java.util.Scanner;

public class FindNKnightsPositions {

	static int count = 0;
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Size : ");
		int size = scan.nextInt();
		int[][] board = new int[size][size];
		new FindNKnightsPositions().positions(board,0,0,size);
		System.out.println(new FindNKnightsPositions().count);
		scan.close();
	}

	private void print(int board[][]) {
		
		for(int i = 0;i<board.length;++i) {
			
			for(int j = 0;j<board[0].length;++j) {
				
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	private boolean positions(int[][] board, int row, int col, int size) {
		
		if(size == 0) {
			
			count++;
			return false;
		}
		else if(col == board.length && row+1 == board.length) {
			
			return false;
		}
		else if(col == board.length) {
			
			positions(board,row+1, 0,size);
			return false;
		}
		if(isSafe(board,col,row,board.length)) {
			
			board[row][col] = 1;
			positions(board,row,col+1,size-1);
			board[row][col] = 0;
		}
		positions(board,row,col+1,size);
		return false;
	}
private boolean isSafe(int[][] board, int col, int row, int bSize) {
		
		if(col-2 >= 0 && row-1 >= 0 && board[row-1][col-2] == 1) {
			
			return false;
		}
		if(col-2 >= 0 && row+1 < bSize && board[row+1][col-2] == 1) {
			
			return false;
		}
		if(row-2 >= 0 && col+1 < bSize && board[row-2][col+1] == 1) {
			
			return false;
		}
		if(row-2 >= 0 && col-1 >= 0 && board[row-2][col-1] == 1) {
			
			return false;
		}
		if(col+2 < bSize && row-1 >= 0 && board[row-1][col+2] == 1) {
			
			return false;
		}
		if(col+2 < bSize && row+1 < bSize && board[row+1][col+2] == 1) {
			
			return false;
		}
		if(row+2 < bSize && col+1 < bSize && board[row+2][col+1] == 1) {
			
			return false;
		}
		if(row+2 < bSize && col-1 >= 0 && board[row+2][col-1] == 1) {
			
			return false;
		}
		return true;
	}

}
