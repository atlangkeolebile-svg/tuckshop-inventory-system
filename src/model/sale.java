package model;

import java.time.LocalDate;
import java.time.format.DateFormatter;

public class sale {

    private String itemName;
    private int quantitySold;
    private double totalPrice;
    private LocalDate saleDate;

    public sale(String itemName, int quantitySold, double totalPrice) {
        this.itemName = itemName;
        this.quantitySold = quantitySold;
        this.totalPrice = totalPrice;
        this.saleDate = LocalDate.now();

    }

    public String getItemName() {
        return itemName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    @override
    public String toString() {
        DateFormatter formatter = DateFormatter.ofPattern("yyyy-MM-dd");
        return String.format("Item: %s, Quantity: %2d, Total Price: %8.2f, Date: %s",
                itemName,
                quantitySold,
                totalPrice,
                formatter.format(saleDate));
}
}