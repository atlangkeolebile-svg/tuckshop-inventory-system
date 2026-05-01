package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Sale {

    private List<String> items = new ArrayList<>();
    private String itemName;
    private int quantitySold;
    private double totalPrice;
    private LocalDate saleDate;
    private int saleId;

    public Sale(int saleId) {
        this.saleId = saleId;
        this.saleDate = LocalDate.now();
        this.itemName = "";
        this.totalPrice = 0;
        this.quantitySold = 0;
    }

    
    public Sale(String itemName, int quantitySold, double totalPrice) {
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

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public double getTotal() { 
        return totalPrice; 
    }
    
    public int getItemCount() { 
        return items != null ? items.size() : 1; 
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("Item: %s, Quantity: %2d, Total Price: %8.2f, Date: %s",
                itemName,
                quantitySold,
                totalPrice,
                formatter.format(saleDate));
}
}
