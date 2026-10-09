package com.canteen.entity;

public class Order {
    private int orderId;
    private Student student;
    private FoodItem foodItem;
    private int quantity;
    private double totalAmount;
    private String status;

    public Order(int orderId, Student student, FoodItem foodItem, int quantity) {
        this.orderId = orderId;
        this.student = student;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.totalAmount = foodItem.getPrice() * quantity;
        this.status = "PLACED";
    }

    public int getOrderId() { return orderId; }
    public Student getStudent() { return student; }
    public FoodItem getFoodItem() { return foodItem; }
    public int getQuantity() { return quantity; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("Order [ID=%d, Student=%s, Food=%s, Qty=%d, Total=%.2f, Status=%s]",
                orderId, student.getName(), foodItem.getName(), quantity, totalAmount, status);
    }
}
