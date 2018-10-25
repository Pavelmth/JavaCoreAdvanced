package ru.pavelm.javacoreadvanced;

public class Team {
    Human human;
    Cat cat;
    Dog dog;
    Duck duck;

    Competitor[] competitors = new Competitor[4];

    public Team(String humanName, String catName, String dogName, String duckName) {
        human = new Human(humanName);
        cat = new Cat(catName);
        dog = new Dog(dogName);
        duck = new Duck(duckName);
        competitors[0] = human;
        competitors[1] = cat;
        competitors[2] = dog;
        competitors[3] = duck;
    }

    public void showResults() {
        human.info();
        cat.info();
        dog.info();
    }
}
