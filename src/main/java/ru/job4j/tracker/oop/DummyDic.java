package ru.job4j.tracker.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic dummyDic = new DummyDic();
        String word = dummyDic.engToRus("apple");
        System.out.println(word);
    }
}
