package com.ghost.human_readable_time;

import java.time.Duration;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        Duration time = Duration.ofSeconds(seconds);
        return String.format("%02d:%02d:%02d",
                             time.toHours(),
                             time.toMinutesPart(),
                             time.toSecondsPart());
    }
}