package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idEditItem = input.askInt("Enter the id of the item to be changed: ");
        String nameEdit = input.askStr("Enter a name of the new Item: ");
        Item itemEdit = new Item(nameEdit);
        boolean edit = tracker.replace(idEditItem, itemEdit);
        if (edit) {
            System.out.println("Item with id " + idEditItem + " changed successfully");
        } else {
            System.out.println("Item with id " + idEditItem + " not found");
        }
        return true;
    }
}
