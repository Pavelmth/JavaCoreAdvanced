package ru.pavelm.javacoreadvanced;

public class Course {
    private int cross;
    private int wall;
    private int water;
    Obstacle[] obstacles = {new Cross(cross), new Wall(wall), new Water(water)};

    public Course(int cross, int wall, int water) {
        this.cross = cross;
        this.wall = wall;
        this.water = water;
    }

    public void doit(Competitor[] competitors) {
        for (Obstacle o : obstacles) {
            for (Competitor c : competitors) {
                o.doit(c);
                if (!c.isOnDistance()) {
                    break;
                }
            }
        }
    }
}
