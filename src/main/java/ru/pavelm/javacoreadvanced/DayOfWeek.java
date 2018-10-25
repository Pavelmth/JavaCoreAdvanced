package ru.pavelm.javacoreadvanced;

public enum  DayOfWeek {
    MONDAY(8*5), TUESDAY(8*4), WEDNESDAY(8*3), THURSDAY(8*2), FRIDAY(8);

    private int hour;

    DayOfWeek(int hour) {
        this.hour = hour;
    }

    public int getWorkingHours() {
        return hour;
    }
}
