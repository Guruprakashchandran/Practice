package com.mentor.questions1;

import java.util.*;

public class SeatPositions {

	public static void main(String[] args) {
		
		new SeatPositions().getInput();
	}

	private void getInput() {

		Scanner scanner = new Scanner(System.in);
		try {

			System.out.print("Enter Seat Number : ");
			int num = scanner.nextInt();
			findSeatNumber(num);
		} catch (Exception e) {
			System.out.println("Wrong Seat Number!!!");
		}
		finally {
			scanner.close();
		}
	}

	private void findSeatNumber(int num) {
		
		System.out.print((num % 6 == 0 || (num - 1) % 6 == 0)?"WS":"");
		System.out.print(((num - 2) % 6  == 0 || (num + 1) % 6 == 0) ?"MS": "");
		System.out.print(((num - 3) % 6  == 0 || (num + 2) % 6 == 0) ?"AS": "");
	}
}
