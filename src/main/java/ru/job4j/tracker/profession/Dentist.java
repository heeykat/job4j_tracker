package ru.job4j.tracker.profession;

public class Dentist extends Doctor{
    private String pliers;
    private String drillingMachine;

    public Dentist(String name, String surname, String education, String birthday,
                   boolean academicDegree, String pliers, String drillingMachine) {
        super(name, surname, education, birthday, academicDegree);
        this.pliers = pliers;
        this.drillingMachine = drillingMachine;
    }
}
