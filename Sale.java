package models;

public class Sale {
    private String itemName;
    private int quantitySold;
    private double totalPrice;

    public Sale(String itemName, int quantitySold, double totalPrice) {
        this.itemName = itemName;
        this.quantitySold = quantitySold;
        this.totalPrice = totalPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}