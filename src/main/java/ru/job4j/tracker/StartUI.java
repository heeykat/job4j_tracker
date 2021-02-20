package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            String number = scanner.nextLine();
            int select = Integer.valueOf(number);
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
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
                System.out.print("Enter the id of the item to be changed: ");
                String idEdit = scanner.nextLine();
                int idEditItem = Integer.valueOf(idEdit);
                System.out.print("Enter a name of the new Item: ");
                String nameEdit = scanner.nextLine();
                Item itemEdit = new Item(nameEdit);
                boolean edit = tracker.replace(idEditItem, itemEdit);
                if (edit) {
                    System.out.println("Item with id " + idEditItem + " changed successfully");
                } else {
                    System.out.println("Item with id " + idEditItem + " not found");
                }

            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter id of item: ");
                String idDel = scanner.nextLine();
                int idDelItem = Integer.valueOf(idDel);
                boolean delete = tracker.delete(idDelItem);
                if (delete) {
                    System.out.println("Item with id " + idDelItem + " deleted successfully");
                } else {
                    System.out.println("Item with id " + idDelItem + " not found");
                }

            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter id of item: ");
                String idFind = scanner.nextLine();
                int idFindItem = Integer.valueOf(idFind);
                Item itemFind = tracker.findById(idFindItem);
                if (itemFind != null) {
                    System.out.println("Item find successfully\n" + itemFind);
                } else {
                    System.out.println("Item with id " + idFindItem + " not found");
                }

            } else if (select == 5) {
                System.out.println("=== Find item by name ====");
                System.out.print("Enter name of item: ");
                String nameFind = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
