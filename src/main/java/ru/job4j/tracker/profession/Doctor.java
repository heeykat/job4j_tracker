package ru.job4j.tracker.profession;

public class Doctor extends Profession{
    private boolean academicDegree;

    public Doctor(String name, String surname, String education, String birthday, boolean academicDegree) {
        super(name, surname, education, birthday);
        this.academicDegree = academicDegree;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis("dead");
    }
}
