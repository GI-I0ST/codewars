package com.ghost.insane_coloured_triangles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Kata {

    public static char triangle(final String row) {
        Map<String, Character> colorMap = new HashMap<>();
        colorMap.put("RR", 'R');
        colorMap.put("GG", 'G');
        colorMap.put("BB", 'B');
        colorMap.put("RG", 'B');
        colorMap.put("GR", 'B');
        colorMap.put("GB", 'R');
        colorMap.put("BG", 'R');
        colorMap.put("RB", 'G');
        colorMap.put("BR", 'G');

        char[] curr = row.toCharArray();
        if (curr.length == 0) {
            throw new IllegalArgumentException();
        }
        while (curr.length > 1) {
            char[] temp = new char[curr.length - 1];
            for (int i = 0; i < curr.length - 1; i++) {
                String pair = "" + curr[i] + curr[i + 1];
                temp[i] = colorMap.get(pair);
            }

            curr = temp;
        }
        return curr[0];
    }

    public static char trianglev2(String row) {
        // Step 1: Generate reduction list
        List<Integer> reduce = new ArrayList<>();
        for (int i = 0; Math.pow(3, i) <= 100000; i++) {
            reduce.add((int) Math.pow(3, i) + 1);
        }
        // Reverse the list to match the original Python [::-1] slicing
        java.util.Collections.reverse(reduce);

        // Step 2: Convert row to a character array list for in-place modification
        List<Character> colors = new ArrayList<>();
        for (char c : row.toCharArray()) {
            colors.add(c);
        }

        // Step 3: Reduce the row based on values in the reduce list
        for (int length : reduce) {
            while (colors.size() >= length) {
                List<Character> newRow = new ArrayList<>();
                for (int i = 0; i < colors.size() - length + 1; i++) {
                    char left = colors.get(i);
                    char right = colors.get(i + length - 1);
                    if (left == right) {
                        newRow.add(left);
                    } else {
                        // Find the missing color
                        Set<Character> colorSet = new HashSet<>(Arrays.asList('R', 'G', 'B'));
                        colorSet.remove(left);
                        colorSet.remove(right);
                        newRow.add(colorSet.iterator().next());
                    }
                }
                colors = newRow;
            }
        }

        // Return the final color
        return colors.get(0);
    }

}