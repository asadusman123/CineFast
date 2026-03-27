package com.example.cinefast2_23l_0740;

public class Snack {

    String name;
    int price;
    int image;
    int quantity;

    public Snack(String name, int price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = 0;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getImage() { return image; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
