package ru.job4j.tracker.profession;

public class Builder extends Engineer{
    private String colorHelmet;
    private boolean roulette;

    public Builder(String name, String surname, String education, String birthday, String qualification, String colorHelmet) {
        super(name, surname, education, birthday, qualification);
        this.colorHelmet = colorHelmet;
    }

    public boolean buildHouse (){
        return true;
    }
}
