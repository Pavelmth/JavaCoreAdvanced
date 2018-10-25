package ru.pavelm.javacoreadvanced;

public class Cross extends Obstacle {
    private int len;

    public Cross(int len) {
        this.len = len;
    }

    @Override
    public void doit(Competitor competitor) {
        competitor.run(len);
    }
}
