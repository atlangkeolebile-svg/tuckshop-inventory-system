package model;

public interface Stockable {
void addStock(int amount);
void reduceStock(int amount);
boolean isLowStock();
}
