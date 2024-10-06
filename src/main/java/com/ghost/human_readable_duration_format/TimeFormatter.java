package com.ghost.human_readable_duration_format;

import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {
    private static final int MINUTE = 60;
    private static final int HOUR = MINUTE * 60;
    private static final int DAY = HOUR * 24;
    private static final int YEAR = DAY * 365;

    public static String formatDuration(int seconds) {
        List<String> list = new ArrayList<>();

        int years = seconds / YEAR;
        addUnit(list, years, "year");
        seconds %= YEAR;

        int days = seconds / DAY;
        addUnit(list, days, "day");
        seconds %= DAY;

        int hours = seconds / HOUR;
        addUnit(list, hours, "hour");
        seconds %= HOUR;

        int minutes = seconds / MINUTE;
        addUnit(list, minutes, "minute");
        seconds %= MINUTE;

        addUnit(list, seconds, "second");

        return formResult(list);
    }

    private static void addUnit(List<String> list, int value, String unit) {
        if (value > 0) {
            list.add("%d %s".formatted(value, value > 1 ? unit + "s" : unit));
        }
    }

    private static String formResult(List<String> list) {
        if (list.isEmpty()) {
            return "now";
        }

        if (list.size() > 1) {
            return String.join(", ", list.subList(0, list.size() - 1)) +
                    " and " +
                    list.get(list.size() - 1);
        }

        return list.get(0);
    }
}