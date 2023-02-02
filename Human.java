package com.monocept.model;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Human {
	private int turn;
	private int currentTurnScore;
	private int totalScore;

	public Human() {
		this.turn = 0;
		this.currentTurnScore = 0;
		this.totalScore = 0;
	}

	public int getTurn() {
		return turn;
	}

	public void startGame() {
		do {
			currentTurnScore = 0;
			turn++;
			System.out.println("..........................................");
			System.out.println("\nTURN " + turn);
			playGame();
			totalScore += currentTurnScore;
			if (currentTurnScore != 0)
				printTurnScore();

		} while (this.totalScore < 20);
		// printTurnScore();
	}

	public void playGame() {
		while (getHumanChoice() == 'r') {
			int x = ThreadLocalRandom.current().nextInt(1, 7);
			System.out.println("Die : " + x);
			if (!isValidScore(x)) {
				return;
			}
			currentTurnScore += x;
			if (currentTurnScore + totalScore >= 20)
				break;
		}
	}

	private boolean isValidScore(int x) {
		if (x == 1) {
			System.out.println("Turn Over. No Score :");
			currentTurnScore = 0;
			printTurnScore();
			return false;
		}
		return true;
	}

	private void printTurnScore() {
		System.out.println("Turn Score :" + currentTurnScore);
		System.out.println("Total Score :" + totalScore);

	}

	public static char getHumanChoice() {
		System.out.println("Roll or hold? (r/h) : ");
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		return ch;

	}

}
