package com.cognixia.jump.corejava.corejavaassignment;

import java.util.Scanner;

public class TicTacToe {

	static char[][] board = new char[3][3];
	static char currentPlayer = 'x';

	// starts/resets the game
	public static void startGame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
	}

	// prints what the current board looks like
	public static void printCurrentBoard() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	// player chooses where to place their 'x' or their 'o'
	public static void takeTurn() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		TicTacToe.checkIfBoardFull();
		if (TicTacToe.checkIfBoardFull() == false) {
			if (currentPlayer == 'x') {
				System.out.println("Player X, please choose a row: ");
			} else {
				System.out.println("Player O, please choose a row: ");
			}
			int row = sc.nextInt() - 1;
			System.out.println("Please choose a column: ");
			int col = sc.nextInt() - 1;
			if ((row >= 0) && (row < 3)) {
				if ((col >= 0) && (col < 3)) {
					if (board[row][col] != '-') {
						System.out.println("That spot's already taken! Please choose another!");
						Thread.sleep(3000);
						TicTacToe.printCurrentBoard();
						TicTacToe.takeTurn();
					}
					else if (board[row][col] == '-') {
						board[row][col] = currentPlayer;
						TicTacToe.checkForWinner();
						if (TicTacToe.checkForWinner() == true) {
							TicTacToe.printCurrentBoard();
							System.out.println("Congratulations, " + currentPlayer + " won! Let's play again!");
							Thread.sleep(2000);
							TicTacToe.startGame();
							TicTacToe.printCurrentBoard();
							TicTacToe.takeTurn();
						} else {
							TicTacToe.printCurrentBoard();
							TicTacToe.changePlayer();
							TicTacToe.takeTurn();
						}
					} else {
						TicTacToe.takeTurn();
					}
				}
			}
		} else {
			TicTacToe.printCurrentBoard();
			System.out.println("Uh-oh! Looks like it's a draw! Let's play a new game!");
			Thread.sleep(3000);
			TicTacToe.startGame();
			TicTacToe.printCurrentBoard();
			TicTacToe.takeTurn();
		}
		sc.close();
	}

	// runs all win-checking methods to check for a winner
	public static boolean checkForWinner() {
		return (checkRows() || checkColumns() || checkDiags());
	}

	// checks rows for a winner
	public static boolean checkRows() {
		for (int i = 0; i < 3; i++) {
			if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
				return true;
			}
		}
		return false;
	}

	// checks columns for a winner
	public static boolean checkColumns() {
		for (int i = 0; i < 3; i++) {
			if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
				return true;
			}
		}
		return false;
	}

	// checks diagonals for a winner
	public static boolean checkDiags() {
		return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true)
				|| (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
	}

	// checks marked rows or columns to see if the values match or if they are empty
	public static boolean checkRowCol(char c1, char c2, char c3) {
		return ((c1 != '-') && (c1 == c2) && (c2 == c3));
	}

	// checks if board is full (draw)
	public static boolean checkIfBoardFull() {
		boolean full = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					full = false;
				}
			}
		}
		return full;
	}

	// changes turn to new player
	public static void changePlayer() {
		if (currentPlayer == 'x') {
			currentPlayer = 'o';
		} else {
			currentPlayer = 'x';
		}
	}

	public static void main(String[] args) throws InterruptedException {

		TicTacToe.startGame();
		TicTacToe.printCurrentBoard();
		TicTacToe.takeTurn();

	}
}
