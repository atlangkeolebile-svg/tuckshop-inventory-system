package model;

import java.util.ArrayList;
import java.util.Scanner;
import model.item;

public class inventory {
    private ArrayList<item> items = new ArrayList<>();

    public void addtem(Scanner input) {
        System.out.print("Enter item name: ");
        String name = input.nextLine();

        System.out.print("Enter price: ");
        double price = input.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        input.nextLine();

        items.add(new Item(name, price, quantity));
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
}