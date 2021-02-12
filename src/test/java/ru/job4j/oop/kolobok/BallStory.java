package ru.job4j.oop.kolobok;

public class BallStory {

    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare zayac = new Hare();
        Wolf volk = new Wolf();
        Fox lisa = new Fox();
        kolobok.roll(zayac);
        zayac.tryEat(kolobok);
        kolobok.roll(volk);
        volk.tryEat(kolobok);
        kolobok.roll(lisa);
        lisa.tryEat(kolobok);
        lisa.eat(kolobok);
    }

}
