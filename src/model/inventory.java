package model;

import java.util.ArrayList;
import java.util.Scanner;


public class inventory {
    private ArrayList<item> items = new ArrayList<>();
    private ArrayList<sale> sales = new ArrayList<>();

    public void addItem(Scanner input) {
        System.out.print("Enter item name: ");
        String name = input.nextLine();

        System.out.print("Enter price: ");
        double price = input.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        input.nextLine();

        items.add(new item(name, price, quantity));
        System.out.println("Item added.");

    }

    public void sellItem(Scanner input) {
        System.out.print("Enter item name to sell: ");
        String name = input.nextLine();

        for (item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter quantity: ");
                int qty = input.nextInt();
                input.nextLine();

                if (qty <= item.getQuantity()) {
                    item.reduceStock(qty);
                    sales.add(new sale(name, qty, item.getPrice() * qty));
                    System.out.println("Item sold.");

                    if (item.getQuantity() < 5) {
                        System.out.println("⚠ Low stock!");
                    }

                } else {
                    System.out.println("Not enough stock.");
                }
                return;
            }
        }

        System.out.println("Item not found.");
    }

    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("No items in stock.");
            return;
        }

        for (item item : items) {
            System.out.println(item.getName() +
                    " | Price: " + item.getPrice() +
                    " | Qty: " + item.getQuantity());
        }
    }

    public void updateStock(Scanner input) {
        System.out.print("Enter item name: ");
        String name = input.nextLine();

        for (item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter amount to add: ");
                int amount = input.nextInt();
                input.nextLine();

                item.addStock(amount);
                System.out.println("Stock updated. New quantity: " + item.getQuantity());
                return;
            }
        }

        System.out.println("Item not found.");
    }

    public void viewSalesSummary() {
        if (sales.isEmpty()) {
            System.out.println("No sales recorded.");
            return;
        }

        double total = 0;
        for (sale sale : sales) {
            System.out.println(sale.getItemName() +
                    " | Qty: " + sale.getQuantitySold() +
                    " | Revenue: " + sale.getTotalPrice());
            total += sale.getTotalPrice();
        }
        System.out.println("Total Revenue: " + total);
    }
}