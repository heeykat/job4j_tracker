package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idFindItem = input.askInt("Enter id of item: ");
        Item itemFind = tracker.findById(idFindItem);
        if (itemFind != null) {
            System.out.println("Item find successfully " + itemFind);
        } else {
            System.out.println("Item with id " + idFindItem + " not found");
        }
        return true;
    }
}
