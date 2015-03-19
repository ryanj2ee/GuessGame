package main.java;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static Scanner input = new Scanner(System.in);
    private static String highOrLow = null;

    @Test
    public static int guessNumber(int lower, int higher) {
        int mid = (lower + higher) / 2;
        System.out.println("Let me guess, is the number " + mid + " ? Type \"Yes\" or tell me if your number is \"higher\" or \"lower\" than this" );
        highOrLow = input.nextLine();

        if (highOrLow.equalsIgnoreCase("lower")) {
            return guessNumber(lower, mid);
        }
        else if (highOrLow.equalsIgnoreCase("higher")) {
            return guessNumber(mid + 1, higher);
        }
        else if (highOrLow.equalsIgnoreCase("yes")) {
            return mid;
        }
        else {
            System.out.println("Invalid input.Tell me if it is higher or lower");
            return guessNumber(lower, higher);
        }
    }
}

