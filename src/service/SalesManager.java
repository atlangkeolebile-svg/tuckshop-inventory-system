package service;

import java.util.ArrayList;
import java.util.List;

import model.Sale;

/*
 * My job is to keep a record of every sale that happens.
 * When someone buys something at the counter, the app tells me
 * to save it here so we can look back at it later.
 *
 * I used an ArrayList because the number of sales keeps growing
 * and we don't know how many we'll get in a day.
 * I return a copy in getAllSales() so nobody outside can
 * accidentally mess up our records.
 */
public class SalesManager {

    private List<Sale> salesHistory;
    private int nextSaleId;

    public SalesManager() {
        salesHistory = new ArrayList<>();
        nextSaleId = 1; // start counting from 1, not 0
    }

    // like pulling out a new receipt and writing the number on top
    public Sale startNewSale() {
        return new Sale(nextSaleId++);
    }

    // only save if it actually has items — no empty sales allowed
    public void recordSale(Sale sale) {
        if (sale == null || sale.getItemCount() == 0) {
            throw new IllegalArgumentException("Can't save an empty sale!");
        }
        salesHistory.add(sale);
    }

    // give back a copy, not the real list. learned this the hard way
    public List<Sale> getAllSales() {
        return new ArrayList<>(salesHistory);
    }

    // add up all the money from every sale
    public double getTotalRevenue() {
        double total = 0;
        for (Sale sale : salesHistory) {
            total += sale.getTotal();
        }
        return total;
    }

    // just how many sales we've recorded
    public int getSaleCount() {
        return salesHistory.size();
    }
}
