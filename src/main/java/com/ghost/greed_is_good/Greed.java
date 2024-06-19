package com.ghost.greed_is_good;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Greed {
    public static int greedy(int[] dice) {
        int result = 0;
        Set<Rule> rules = Set.of(new Rule(1, 3, 1000),
                                 new Rule(6, 3, 600),
                                 new Rule(5, 3, 500),
                                 new Rule(4, 3, 400),
                                 new Rule(3, 3, 300),
                                 new Rule(2, 3, 200),
                                 new Rule(1, 1, 100),
                                 new Rule(5, 1, 50));

        Map<Integer, Integer> numbers = new HashMap<>();
        Arrays.stream(dice).forEach(number -> numbers.compute(number, (k, v) -> v == null ? 1 : v + 1));

        for (var entry : numbers.entrySet()) {
            List<Rule> appropriateRules = rules.stream()
                    .filter(r -> entry.getKey().equals(r.value))
                    .filter(r -> entry.getValue().compareTo(r.amount) >= 0)
                    .sorted()
                    .collect(Collectors.toList());

            while (entry.getValue() > 0 && !appropriateRules.isEmpty()) {
                int lastIndex = appropriateRules.size() - 1;
                int cost = appropriateRules.get(lastIndex).amount;
                if (entry.getValue() >= cost) {
                    entry.setValue(entry.getValue() - cost);
                    result += appropriateRules.get(lastIndex).points;
                } else {
                    appropriateRules.remove(lastIndex);
                }
            }
        }

        return result;
    }

    public static class Rule implements Comparable<Rule> {
        public final int value;
        public final int amount;
        public final int points;

        public Rule(int value, int amount, int points) {
            this.value = value;
            this.amount = amount;
            this.points = points;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Rule rule = (Rule) o;

            if (value != rule.value) return false;
            return amount == rule.amount;
        }

        @Override
        public int hashCode() {
            int result = value;
            result = 31 * result + amount;
            return result;
        }

        @Override
        public int compareTo(Rule other) {
            return Integer.compare(this.points, other.points);
        }
    }
}