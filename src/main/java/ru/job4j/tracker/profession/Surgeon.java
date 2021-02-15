package ru.job4j.tracker.profession;

public class Surgeon extends Doctor{
    private String hatchet;
    private String saw;
    private String gag;

    public Surgeon(String name, String surname, String education, String birthday, boolean academicDegree, String hatchet) {
        super(name, surname, education, birthday, academicDegree);
        this.hatchet = hatchet;
    }
}
