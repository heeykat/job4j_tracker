package ru.job4j.encapsulation;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = index; i < products.length; i++) {
            if (i == index) {
                products[i] = null;
            } else {
                Product tmp = products[i - 1];
                products[i - 1] = products[i];
                products[i] = tmp;
            }
        }
        return products;
    }
}
