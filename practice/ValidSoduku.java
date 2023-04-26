package com.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSoduku {

	public static void main(String[] args) {
		
		char[][] board = {{'.','.','.','.','5','.','.','1','.'},
				  {'.','4','.','3','.','.','.','.','.'},
				  {'.','.','.','.','.','3','.','.','1'},
				  {'8','.','.','.','.','.','.','2','.'},
				  {'.','.','2','.','7','.','.','.','.'},
				  {'.','1','5','.','.','.','.','.','.'},
				  {'.','.','.','.','.','2','.','.','.'},
				  {'.','2','.','9','.','.','.','.','.'},
				  {'.','.','4','.','.','.','.','.','.'}};
		boolean bool  = new ValidSoduku().goal(board);
		System.out.println(bool);
	}
	private boolean goal(char[][] board) {
		
		Set<Character> row = new HashSet<>();
		List<Set<Character>> sets = new ArrayList<>();
		for(int i = 0;i<9;++i) {
			
			sets.add(new HashSet<>());
		}
        for(int i = 0;i<board.length;++i){

            for(int j = 0;j<board[i].length;++j){

                if(row.contains(board[i][j])){
                	
//                	System.out.println(board[i][j] +" ");
                	return false;
                }                
                else if(board[i][j] != '.'){
                	
                	for(int k = i-1;k>=0;--k) {
                		
                		if(board[k][j] == board[i][j]) {
                	
                			System.out.println(board[i][j] +" "+i+" "+k+" "+j);
                			return false;
                		}
                	}
                	row.add(board[i][j]);
                   	int value = ((i/3)*3) + (j / 3);
                	System.out.println(value+ " "+i +" "+j+" ");
                	if(sets.get(value).contains(board[i][j])) {
                		
                		return false;
                	}
                	sets.get(value).add(board[i][j]);
                }
                else {
                	
//                	sets.get(value).add(board[i][j]);
                }
            }
            row.clear();
        }
        return true;
	}

}
