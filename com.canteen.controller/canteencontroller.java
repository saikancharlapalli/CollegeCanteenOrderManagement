package com.canteen.controller;

import com.canteen.entity.FoodItem;
import com.canteen.entity.Order;
import com.canteen.entity.Student;
import com.canteen.service.FoodService;
import com.canteen.service.OrderService;
import java.util.List;
import java.util.Scanner;

public class CanteenController {
    private FoodService foodService;
    private OrderService orderService;
    private Scanner scanner = new Scanner(System.in);

    public CanteenController(FoodService foodService, OrderService orderService) {
        this.foodService = foodService;
        this.orderService = orderService;
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n===== College Canteen Order Management =====");
            System.out.println("1. Add Food Item");
            System.out.println("2. View Menu");
            System.out.println("3. Remove Food Item");
            System.out.println("4. Place Order");
            System.out.println("5. View All Orders");
            System.out.println("6. View Orders by Student");
            System.out.println("7. Cancel Order");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = readInt();

            switch (choice) {
                case 1: addFood(); break;
                case 2: viewMenu(); break;
                case 3: removeFood(); break;
                case 4: placeOrder(); break;
                case 5: viewAllOrders(); break;
                case 6: viewStudentOrders(); break;
                case 7: cancelOrder(); break;
                case 0: System.out.println("Thank you! Goodbye."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private void addFood() {
        System.out.print("Food ID: ");
        int id = readInt();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Quantity: ");
        int qty = readInt();
        foodService.addFoodItem(new FoodItem(id, name, price, qty));
    }

    private void viewMenu() {
        List<FoodItem> items = foodService.getAllFoodItems();
        if (items.isEmpty()) {
            System.out.println("Menu is empty.");
            return;
        }
        for (FoodItem f : items) {
            System.out.println(f);
        }
    }

    private void removeFood() {
        System.out.print("Enter Food ID to remove: ");
        int id = readInt();
        if (foodService.removeFoodItem(id)) {
            System.out.println("Food item removed.");
        } else {
            System.out.println("Food item not found.");
        }
    }

    private void placeOrder() {
        System.out.print("Student ID: ");
        int sid = readInt();
        System.out.print("Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Department: ");
        String dept = scanner.nextLine();
        Student student = new Student(sid, name, dept);

        viewMenu();
        System.out.print("Enter Food ID: ");
        int foodId = readInt();
        System.out.print("Enter Quantity: ");
        int qty = readInt();

        Order order = orderService.placeOrder(student, foodId, qty);
        if (order != null) {
            System.out.println("Order placed successfully!");
            System.out.println(order);
        }
    }

    private void viewAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    private void viewStudentOrders() {
        System.out.print("Enter Student ID: ");
        int sid = readInt();
        List<Order> orders = orderService.getOrdersByStudent(sid);
        if (orders.isEmpty()) {
            System.out.println("No orders found for this student.");
            return;
        }
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    private void cancelOrder() {
        System.out.print("Enter Order ID to cancel: ");
        int id = readInt();
        if (orderService.cancelOrder(id)) {
            System.out.println("Order cancelled and stock restored.");
        } else {
            System.out.println("Order not found or already cancelled.");
        }
    }

    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
