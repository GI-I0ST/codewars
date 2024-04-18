package com.ghost.petebaker;
import java.util.Map;

public class PeteBaker {
    private static final int DEFAULT = 0;

    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        return recipe.entrySet()
                .stream()
                .mapToInt(entry -> available.getOrDefault(entry.getKey(), DEFAULT) / entry.getValue())
                .min()
                .orElse(0);
    }
}