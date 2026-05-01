package model;
import java.util.ArrayList;
import java.util.Scanner;
import service.AlertService;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Sale> sales = new ArrayList<>();
    private AlertService alertService = new AlertService();

    public void addItem(Scanner input) {
        System.out.print("Enter item name: ");
        String name = input.nextLine();
        System.out.print("Enter price: ");
        double price = input.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        input.nextLine();

        Item item = new Item(name, 0, 0);
        item.setPrice(price);
        item.setQuantity(quantity);

        if (price >= 0 && quantity >= 0) {
            items.add(item);
            System.out.println("Item added.");
        } else {
            System.out.println("Item not added due to invalid input.");
        }
    }

    public void sellItem(Scanner input) {
        System.out.print("Enter item name to sell: ");
        String name = input.nextLine();
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter quantity: ");
                int qty = input.nextInt();
                input.nextLine();
                if (qty <= item.getQuantity()) {
                    item.reduceStock(qty);
                    sales.add(new Sale(name, qty, item.getPrice() * qty));
                    System.out.println("Item sold.");
                    alertService.checkSingleItem(item);
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
        for (Item item : items) {
            System.out.println(item.getName() +
                    " | Price: " + item.getPrice() +
                    " | Qty: " + item.getQuantity());
        }
    }

    public void updateStock(Scanner input) {
        System.out.print("Enter item name: ");
        String name = input.nextLine();
        for (Item item : items) {
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
        for (Sale sale : sales) {
            System.out.println(sale.getItemName() +
                    " | Qty: " + sale.getQuantitySold() +
                    " | Revenue: " + sale.getTotalPrice());
            total += sale.getTotalPrice();
        }
        System.out.println("Total Revenue: " + total);
    }
}
