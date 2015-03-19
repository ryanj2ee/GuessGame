package main.java;

import java.util.Scanner;

public class Main {

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int input;
        String in;
        System.out.println("Guess a number between 1 and 100 and type \"ready\" when you are ready to begin or \"quit\" to exit");
        while(!( in = scanner.nextLine()).equalsIgnoreCase("ready")) {
            if (in.equalsIgnoreCase("quit")) System.exit(0);
            System.out.println("Sorry Wrong input try again");
        }
        System.out.println("The Number You Guessed is " + GuessNumber.guessNumber(1, 100));
    }

    public static void main(String... args) {
        Main obj = new Main();
        obj.execute();
    }
}