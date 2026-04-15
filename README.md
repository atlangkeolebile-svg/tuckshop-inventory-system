# Tuckshop Inventory and Sales Summary System

## Project Overview
This is a Java console application designed to help tuckshop owners:
- Manage inventory (add, update, and display items).
- Record sales transactions.
- Generate sales and inventory summaries.
- Receive alerts when stock is low.

## Group Members
- Katso Lechiile – 202503275  
- Mpendulo Nkambule – 202208761  
- Atlang Keolebile – 202505383  
- Setso Choto – 202507061  
- Klayame Mosutlhelo – 202503781  

## Package Structure
- **app** → `Main.java` (runs the application and menu loop)  
- **model** → `Item.java`, `Inventory.java`, `Sale.java`  
- **service** → `SalesManager.java`, `AlertService.java`  

## How to Run
1. Clone the repository:
    git clone https://github.com/atlangkeolebile-svg/tuckshop-inventory-system.git

2. Navigate into the project folder:
    cd tuckshop-inventory-system

3. Compile the program:
    javac src/app/main.java

4. Run the program:
    java app.main
