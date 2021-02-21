package ru.job4j.tracker.oop;

public class Airplane implements Vehicle {
    private String name;
    private int passenger;

    public Airplane(String name, int passenger) {
        this.name = name;
        this.passenger = passenger;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по воздуху");
    }

    @Override
    public void passengers() {
        System.out.println(this.name + " класса " + getClass().getSimpleName() +
                " вмещает " + this.passenger + " пассажиров");
    }
}
