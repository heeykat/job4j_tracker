package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);

            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] allItems = tracker.findAll();
                for (Item allItem : allItems) {
                    System.out.println(allItem);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                int idEditItem = input.askInt("Enter the id of the item to be changed: ");
                String nameEdit = input.askStr("Enter a name of the new Item: ");
                Item itemEdit = new Item(nameEdit);
                boolean edit = tracker.replace(idEditItem, itemEdit);
                if (edit) {
                    System.out.println("Item with id " + idEditItem + " changed successfully");
                } else {
                    System.out.println("Item with id " + idEditItem + " not found");
                }

            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                int idDelItem = input.askInt("Enter id of item: ");
                boolean delete = tracker.delete(idDelItem);
                if (delete) {
                    System.out.println("Item with id " + idDelItem + " deleted successfully");
                } else {
                    System.out.println("Item with id " + idDelItem + " not found");
                }

            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                int idFindItem = input.askInt("Enter id of item: ");
                Item itemFind = tracker.findById(idFindItem);
                if (itemFind != null) {
                    System.out.println("Item find successfully " + itemFind);
                } else {
                    System.out.println("Item with id " + idFindItem + " not found");
                }

            } else if (select == 5) {
                System.out.println("=== Find item by name ====");
                String nameFind = input.askStr("Enter name of item: ");
                Item[] nameFindItems = tracker.findByName(nameFind);
                if (nameFindItems.length > 0) {
                    for (Item nameFindItem: nameFindItems) {
                        System.out.println(nameFindItem);
                    }
                } else {
                    System.out.println("Item with name " + nameFind + " not found");
                }

            } else if (select == 6) {
                System.out.println("=== Exit program ====");
                run = false;
            } else {
                System.out.println("=== Number out of bounds points of menu ====");
            }
        }
    }

    private void showMenu() {
        String lineSeparator = System.lineSeparator();
        System.out.println(
                "Menu." + lineSeparator +
                        "0. Add new Item" + lineSeparator +
                        "1. Show all items" + lineSeparator +
                        "2. Edit item" + lineSeparator +
                        "3. Delete item" + lineSeparator +
                        "4. Find item by Id" + lineSeparator +
                        "5. Find items by name" + lineSeparator +
                        "6. Exit Program" + lineSeparator
        );
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
