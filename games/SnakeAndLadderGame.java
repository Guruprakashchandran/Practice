package com.games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SnakeAndLadderGame {

	public static void main(String[] args) {

		System.out.println("-------------------SNAKE AND LADDER GAME------------------\n");
		new SnakeAndLadderGame().setDatas();
	}

	private void setDatas() {

		boolean isIterate = true;
		while (isIterate) {
			Scanner scan = new Scanner(System.in);
			
			try {
				System.out.print("Enter No Of Players : ");
				int noOfPlayers = scan.nextInt();
				if (noOfPlayers > 1) {

					isIterate = false;
					String[][] board = null;
					List<String> playerNames = new LinkedList<>();
					List<Integer> playerPlaces = new ArrayList<>(noOfPlayers);
					scan.nextLine();
					for (int i = 0; i < noOfPlayers; ++i) {

						System.out.print("\nPlayer " + (i + 1) + " Name : ");
						playerNames.add(scan.nextLine());
						playerPlaces.add(0);
					}

					board = new String[10][10];
					setSnakesAndLadders(board, playerNames, playerPlaces);
				} else {
					System.out.println("Play Minimum 2 Players!!!");
				}

			} catch (Exception e) {

				System.out.println("Wrong Input!!!");
			} finally {

				scan.close();
			}
		}
	}

	private void dice(int number) {

		int[][] dice = new int[3][3];
		switch (number) {

		case 1:
			dice[1][1] = 1;
			break;
		case 2:
			dice[1][0] = dice[1][2] = 1;
			break;
		case 3:
			dice[1][0] = dice[1][1] = dice[1][2] = 1;
			break;
		case 4:
			dice[0][0] = dice[0][2] = dice[2][0] = dice[2][2] = 1;
			break;
		case 5:
			dice[0][0] = dice[0][2] = dice[2][0] = dice[2][2] = dice[1][1] = 1;
			break;
		default:
			dice[0][0] = dice[0][2] = dice[2][0] = dice[2][2] = dice[0][1] = dice[2][1] = 1;

		}

		System.out.println("\n------------");
		for (int i = 0; i < 3; ++i) {

			for (int j = 0; j < 3; ++j) {

				System.out.print(dice[i][j] == 1 ? " * |" : "   |");
			}
			System.out.println("\n------------");
		}
	}

	private void setSnakesAndLadders(String[][] board, List<String> playerNames, List<Integer> playerPlaces) {

		Map<Integer, Integer> snake = new HashMap<>();
		snake.put(99, 41);
		snake.put(95, 77);
		snake.put(89, 53);
		snake.put(66, 45);
		snake.put(54, 31);
		snake.put(43, 18);
		snake.put(40, 3);
		snake.put(24, 5);

		Map<Integer, Integer> ladder = new HashMap<>();
		ladder.put(4, 25);
		ladder.put(13, 46);
		ladder.put(33, 49);
		ladder.put(42, 63);
		ladder.put(50, 69);
		ladder.put(62, 81);
		ladder.put(74, 92);

		printBoard(board, playerNames, playerPlaces, snake, ladder);
		playingGame(board, playerNames, playerPlaces, ladder, snake);
	}

	private void playingGame(String[][] board, List<String> playerNames, List<Integer> playerPlaces,
			Map<Integer, Integer> ladder, Map<Integer, Integer> snake) {

		Scanner scan = new Scanner(System.in);
		int max = 7, min = 1, i = 0;
		while (true) {

			System.out.println("\nPlayer Name : " + playerNames.get(i));
			System.out.print("Please!!! Click Enter - ");
			scan.nextLine();
			int number = ((int) (Math.random() * (max - min)) + min);
			System.out.println("------Your Number----- ");
			dice(number);

			i = (isMoveToNextPlayer(board, playerNames, playerPlaces, ladder, snake, number, i))
					? ((i + 1 == playerNames.size()) ? 0 : ++i)
					: i;
			if (playerNames.size() == 1) {

				System.out.println(playerNames.get(0) + " Lost this Game!!!");
				break;
			}
		}
		scan.close();
	}

	private boolean isMoveToNextPlayer(String[][] board, List<String> playerNames, List<Integer> playerPlaces,
			Map<Integer, Integer> ladder, Map<Integer, Integer> snake, int number, int i) {

		if (playerPlaces.get(i) >= 0 && playerPlaces.get(i) + number <= 100) {

			if (playerPlaces.get(i) + number == 100) {

				System.out.println("\n-------------" + playerNames.get(i) + " Win------------");
				playerPlaces.remove(i);
				playerNames.remove(i);
				return false;
			} else if (playerPlaces.get(i) == 0 && number == 1) {

				System.out.println("You Joined the Game!!!");
				playerPlaces.set(i, 1);
			} else if (playerPlaces.get(i) > 0 && snake.containsKey(playerPlaces.get(i) + number)) {

				System.out.println("\nSnakes Attacks " + playerNames.get(i));
				System.out.print("Your Position Move " + (playerPlaces.get(i) + number));
				playerPlaces.set(i, snake.get(playerPlaces.get(i) + number));
				System.out.println(" to " + playerPlaces.get(i));

			} else if (playerPlaces.get(i) > 0 && ladder.containsKey(playerPlaces.get(i) + number)) {

				System.out.println("\nYou reach ladder " + playerNames.get(i));
				System.out.print("Your Position Move " + (playerPlaces.get(i) + number));
				playerPlaces.set(i, ladder.get(playerPlaces.get(i) + number));
				System.out.println(" to " + playerPlaces.get(i));
			} else if (playerPlaces.get(i) != 0) {

				playerPlaces.set(i, playerPlaces.get(i) + number);
			}
		}
		printBoard(board, playerNames, playerPlaces, snake, ladder);
		return ((number == 5 || number == 1 || number == 6) && playerPlaces.get(i) < 94) ? false : true;
	}

	private void printBoard(String[][] board, List<String> playerNames, List<Integer> playerPlaces,
			Map<Integer, Integer> snake, Map<Integer, Integer> ladder) {

		System.out.println();
		for (int i = 100; i > 0; i -= 10) {

			if (i % 20 == 0) {
				for (int j = i; j > (i - 10); --j) {

					String s = "p";
					for (int k = 0; k < playerPlaces.size(); ++k)
						s += playerPlaces.get(k) == j ? " " + (k + 1) : "";

					s = s.length() != 1 ? s : Integer.toString(j);
					s = s.startsWith("p") ? s
							: (snake.containsKey(j) ? s + "-sx" : (ladder.containsKey(j) ? s + "-lx" : s));
					if (!s.startsWith("p")) {

						for (Map.Entry<Integer, Integer> entry : snake.entrySet()) {

							s = entry.getValue() == j ? s + "-se" : s;
						}
						for (Map.Entry<Integer, Integer> entry : ladder.entrySet()) {

							s = entry.getValue() == j ? s + "-le" : s;
						}
					}
					System.out.print(s.length() > 3 ? " " + s + "\t|" : "   " + s + "\t|");
				}
			} else {
				for (int j = i - 9; j <= i; ++j) {

					String s = "p";
					for (int k = 0; k < playerPlaces.size(); ++k)
						s += playerPlaces.get(k) == j ? " " + (k + 1) : "";

					s = s.length() != 1 ? s : Integer.toString(j);
					s = s.startsWith("p") ? s
							: (snake.containsKey(j) ? s + "-sx" : (ladder.containsKey(j) ? s + "-lx" : s));
					if (!s.startsWith("p")) {

						for (Map.Entry<Integer, Integer> entry : snake.entrySet()) {

							s = entry.getValue() == j ? s + "-se" : s;
						}
						for (Map.Entry<Integer, Integer> entry : ladder.entrySet()) {

							s = entry.getValue() == j ? s + "-le" : s;
						}
					}
					System.out.print(s.length() > 3 ? " " + s + "\t|" : "   " + s + "\t|");
				}
			}
			System.out.println();
			for (int j = 0; j < 10; ++j)
				System.out.print("   " + "---\t");

			System.out.println();
		}
		for(int j = 0;j<playerNames.size();++j) {
			
			System.out.println("\t\t\t\t\t\t\t\t\tp "+(j+1)+" - "+playerNames.get(j));
		}
		System.out.println("\t\t\t\t\t\t\t\t\tsx - Snake Head");
		System.out.println("\t\t\t\t\t\t\t\t\tlx - Ladder start");
		System.out.println("\t\t\t\t\t\t\t\t\tse - Snake End");
		System.out.println("\t\t\t\t\t\t\t\t\tle - Ladder End");
	}
}
