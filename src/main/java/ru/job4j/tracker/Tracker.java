package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private static Tracker instance = null;
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private Tracker() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName().equals(key)) {
                rsl[index++] = item;
            }
        }
        return Arrays.copyOf(rsl, index);
    }


    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rst = index != -1;
        if (rst) {
            item.setId(id);
            items[index] = item;
        }
        return rst;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rst = index != -1;
        if (rst) {
            items[index] = null;
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
        return rst;
    }

    public void deleteAll() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
        ids = 1;
    }
}