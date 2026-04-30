package model;

public class sale {
    private String itemName;
    private int quantitySold;
    private double totalPrice;

    public sale(String itemName, int quantitySold, double totalPrice) {
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
