package com.ghost.multiples_of_3_or_5;

public class Solution {

    private static final int THREE = 3;
    private static final int FIVE = 5;

    public int solution(int number) {
        if (number <= 0 ) {
            return 0;
        }

        int sum = 0;
        int threeIterations = (number - 1) / THREE;
        int fiveIterations = (number - 1) / FIVE;

        for (int i = 1; i <= threeIterations; i++) {
            sum += i * THREE;
        }
        for (int i = 1; i <= fiveIterations; i++) {
            int multiply = i * FIVE;
            if (multiply % THREE != 0) {
                sum += multiply;
            }
        }

        return sum;
    }
}
