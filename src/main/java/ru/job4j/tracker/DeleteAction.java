package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idDelItem = input.askInt("Enter id of item: ");
        boolean delete = tracker.delete(idDelItem);
        if (delete) {
            System.out.println("Item with id " + idDelItem + " deleted successfully");
        } else {
            System.out.println("Item with id " + idDelItem + " not found");
        }
        return true;
    }
}
