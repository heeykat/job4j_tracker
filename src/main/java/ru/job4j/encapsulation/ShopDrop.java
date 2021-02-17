package ru.job4j.encapsulation;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = index + 1; i < products.length; i++) {
            Product tmp = products[i - 1];
            products[i - 1] = products[i];
            products[i] = tmp;
        }
        products[products.length - 1] = null;
        return products;
    }
}
