package ru.job4j.tracker;

public class ShowAction implements UserAction{
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        for (Item allItem : allItems) {
            System.out.println(allItem);
        }
        return true;
    }
}
