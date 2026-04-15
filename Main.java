import java.util.Scanner;
import services.Inventory;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
            System.out.println("\n--- Tuckshop System ---");
            System.out.println("1. Add Item");
            System.out.println("2. Sell Item");
            System.out.println("3. View Stock");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            choice = input.nextInt();
            input.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    inventory.addItem(input);
                    break;
                case 2:
                    inventory.sellItem(input);
                    break;
                case 3:
                    inventory.viewItems();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 4);

        input.close();
    }
}
