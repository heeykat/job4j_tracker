package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {
    private String name;
    private int id;
    private LocalDateTime created;

    public Item() {
        this.created = LocalDateTime.now();
    }

    public Item(int id){
        this.id = id;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) {
        Item item = new Item();
    }

    public LocalDateTime getCreated() {
        return created;
    }
}