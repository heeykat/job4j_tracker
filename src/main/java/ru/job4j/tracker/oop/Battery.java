
package ru.job4j.tracker.oop;

public class Battery {

    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another){
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(83);
        Battery second = new Battery(17);
        first.exchange(second);
        System.out.println("first: " + first.load + " second: " + second.load);
        second.exchange(first);
        System.out.println("first: " + first.load + " second: " + second.load);
    }
}
