package ru.pavelm.javacoreadvanced;

public class Water extends Obstacle {
    private int len;

    public Water(int len) {
        this.len = len;
    }

    @Override
    public void doit(Competitor competitor) {
        competitor.swim(len);
    }
}
