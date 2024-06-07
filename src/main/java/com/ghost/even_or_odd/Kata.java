package com.ghost.even_or_odd;

public class Kata {
    public static String evenOrOdd(int number) {
        return Math.abs(number) % 2 == 1 ? "Odd" : "Even";
    }
}
