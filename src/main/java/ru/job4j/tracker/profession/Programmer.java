package ru.job4j.tracker.profession;

public class Programmer extends Engineer{
    private String sizeCoffeeCup;
    private String codeLanguage;

    public Programmer(String name, String surname, String education, String birthday,
                      String qualification, String sizeCoffeeCup, String codeLanguage) {
        super(name, surname, education, birthday, qualification);
        this.sizeCoffeeCup = sizeCoffeeCup;
        this.codeLanguage = codeLanguage;
    }

    public boolean pretendThatWorking(String sizeCoffeeCup) {
        return true;
    }
}
