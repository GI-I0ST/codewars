package com.ghost.disemvowel_trolls;

public class Troll {
    public static String disemvowel(String str) {
        return str.replaceAll("(?i)[aeiou]", "");
    }
}