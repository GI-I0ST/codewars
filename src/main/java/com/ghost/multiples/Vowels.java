package com.ghost.multiples;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Vowels {

    public static int getCount(String str) {
        Set<Integer> vovels = List.of("a", "e", "i", "o", "u").stream().flatMapToInt(ch -> ch.chars()).boxed().collect(Collectors.toSet());
        return (int) str.chars().filter(vovels::contains).count();
    }

}