package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by Id ====");
        int idFindItem = input.askInt("Enter id of item: ");
        Item itemFind = tracker.findById(idFindItem);
        if (itemFind != null) {
            out.println("Item find successfully " + itemFind);
        } else {
            out.println("Item with id " + idFindItem + " not found");
        }
        return true;
    }
}
