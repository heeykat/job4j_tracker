package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        int id = item.getId();
        System.out.println(tracker.findById(id));
    }
}
