package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit item ====");
        int idEditItem = input.askInt("Enter the id of the item to be changed: ");
        String nameEdit = input.askStr("Enter a name of the new Item: ");
        Item itemEdit = new Item(nameEdit);
        boolean edit = tracker.replace(idEditItem, itemEdit);
        if (edit) {
            out.println("Item with id " + idEditItem + " changed successfully");
        } else {
            out.println("Item with id " + idEditItem + " not found");
        }
        return true;
    }
}
