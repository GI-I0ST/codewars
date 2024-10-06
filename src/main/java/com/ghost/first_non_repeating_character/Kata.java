package com.ghost.first_non_repeating_character;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Kata {
    public static String firstNonRepeatingLetter(String s) {
        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();

        var chars = s.toLowerCase().chars().toArray();
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i];
            // If the character already exists in the map, update its count
            if (map.containsKey(c)) {
                map.get(c).set(0, map.get(c).get(0) + 1); // Increment count
            } else {
                // If the character does not exist, add a new entry with count 1 and the index
                map.put(c, new ArrayList<>(List.of(1, i)));
            }
        }

        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().get(0) <= 1)
                .findFirst()
                .map(Map.Entry::getValue)
                .map(list -> list.get(1))
                .map(integer -> String.valueOf(s.charAt(integer)))
                .orElse("");
    }
}