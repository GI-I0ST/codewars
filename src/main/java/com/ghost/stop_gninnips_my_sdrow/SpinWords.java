package com.ghost.stop_gninnips_my_sdrow;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {

    public String spinWords(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(word -> word.length() < 5 ? word : new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}