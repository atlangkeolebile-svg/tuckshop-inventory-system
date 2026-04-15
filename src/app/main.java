package app;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Tuckshop System ===");
            System.out.println("1. Add Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Stock");
            System.out.println("4. Record Sale");
            System.out.println("5. View Sales Summary");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Adding item...");
                    break;
                case 2:
                    System.out.println("Displaying inventory...");
                    break;
                case 3:
                    System.out.println("Updating stock...");
                    break;
                case 4:
                    System.out.println("Recording sale...");
                    break;
                case 5:
                    System.out.println("Showing sales summary...");
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
