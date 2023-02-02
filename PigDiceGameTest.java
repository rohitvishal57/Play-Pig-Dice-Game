package com.monocept.test;

import com.monocept.model.Human;

public class PigDiceGameTest {

	public static void main(String[] args) {
		Human human = new Human();
		human.startGame();
		System.out.println("Human Finishes The Game in "+human.getTurn() +" Turns");
		System.out.println("\n\nGame Over!!!!!");

	}

}
