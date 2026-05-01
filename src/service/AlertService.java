package service;

import java.util.ArrayList;
import java.util.List;
import model.Item;

public class AlertService {

    private static final int LOW_STOCK_THRESHOLD = 5;

    public void checkStock(List<Item> items) {
        List<Item> lowStock = new ArrayList<>();

        for (Item item : items) {
            if (item.getQuantity() < LOW_STOCK_THRESHOLD) {
                lowStock.add(item);
            }
        }

        if (lowStock.isEmpty()) {
            System.out.println("All items are sufficiently stocked.");
        } else {
            System.out.println("⚠ Low stock alert!");
            for (Item item : lowStock) {
                System.out.println("  - " + item.getName() + " | Qty: " + item.getQuantity());
            }
        }
    }

    public void checkSingleItem(Item item) {
        if (item.getQuantity() < LOW_STOCK_THRESHOLD) {
            System.out.println("⚠ Low stock: " + item.getName() + " only has " + item.getQuantity() + " left.");
        }
    }
}