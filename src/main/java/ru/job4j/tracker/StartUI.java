package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        int id = item.getId();
        System.out.println(tracker.findById(id));

        Item item1 = new Item();
        item1.setId(5);
        item1.setName("Имя");
        System.out.println(item1);
    }
}
