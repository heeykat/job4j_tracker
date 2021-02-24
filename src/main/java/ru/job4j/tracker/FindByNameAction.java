package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    @Override
    public String name() {
        return "=== Find item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameFind = input.askStr("Enter name of item: ");
        Item[] nameFindItems = tracker.findByName(nameFind);
        if (nameFindItems.length > 0) {
            for (Item nameFindItem: nameFindItems) {
                System.out.println(nameFindItem);
            }
        } else {
            System.out.println("Item with name " + nameFind + " not found");
        }
        return true;
    }
}
