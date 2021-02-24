package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ====");
        int idDelItem = input.askInt("Enter id of item: ");
        boolean delete = tracker.delete(idDelItem);
        if (delete) {
            out.println("Item with id " + idDelItem + " deleted successfully");
        } else {
            out.println("Item with id " + idDelItem + " not found");
        }
        return true;
    }
}
