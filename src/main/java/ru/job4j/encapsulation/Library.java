package ru.job4j.encapsulation;

public class Library {
    public static void main(String[] args) {
        Book rouling = new Book("Harry Potter", 545);
        Book london = new Book("Martin Eden", 460);
        Book harari = new Book("Sapiens", 615);
        Book martin = new Book("Clean code", 700);

        Book[] books = new Book[4];
        books[0] = rouling;
        books[1] = london;
        books[2] = harari;
        books[3] = martin;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " " + books[i].getNumberOfPages());
        }

        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " " + books[i].getNumberOfPages());
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")){
                System.out.println(books[i].getName() + " " + books[i].getNumberOfPages());
            }
        }
    }
}
