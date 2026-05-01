package model;

public class Item {
    private String name;
    private double price;
    private int quantity;
    
    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    } 
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Price cannot be negative.");
        } else {
            this.price = price;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
        } else {
            this.quantity = quantity;
        }
    }

    public void addStock(int amount) {
        quantity += amount;
    }

    public void reduceStock(int amount) {
        quantity -= amount;
    }

    public void display() {
        System.out.println(name + " | P" + price + " | Qty: " + quantity);
    }
}
