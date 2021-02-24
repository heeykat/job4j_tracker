package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by name ====");
        String nameFind = input.askStr("Enter name of item: ");
        Item[] nameFindItems = tracker.findByName(nameFind);
        if (nameFindItems.length > 0) {
            for (Item nameFindItem: nameFindItems) {
                out.println(nameFindItem);
            }
        } else {
            out.println("Item with name " + nameFind + " not found");
        }
        return true;
    }
}
