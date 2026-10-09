package com.canteen.entity;

public class FoodItem {
    private int foodId;
    private String name;
    private double price;
    private int quantity;

    public FoodItem(int foodId, String name, double price, int quantity) {
        this.foodId = foodId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getFoodId() { return foodId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return String.format("FoodItem [ID=%d, Name=%s, Price=%.2f, Stock=%d]",
                foodId, name, price, quantity);
    }
}
