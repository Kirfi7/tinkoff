package edu.hw1;

public class FirstTask {
    public static int minutesToSeconds(String time) {
        String[] parts = time.split(":");
        if (parts.length != 2) {
            return -1;
        }

        try {
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            if (seconds >= 60) {
                return -1;
            }
            return minutes * 60 + seconds;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
