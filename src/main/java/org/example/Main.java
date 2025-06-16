package org.example;

import Initializers.Initializer;
import Initializers.GameLoader;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("─── Scrum Escape ───");
        System.out.println("1) Start New Game");
        System.out.println("2) Load Saved Game");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        if (choice == 2) {
            GameLoader.loadGame();
        } else {
            Initializer.initializeGame();
        }

    }
}