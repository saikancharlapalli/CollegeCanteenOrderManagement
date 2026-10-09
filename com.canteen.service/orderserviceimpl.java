package com.canteen.service;

import com.canteen.entity.FoodItem;
import com.canteen.entity.Order;
import com.canteen.entity.Student;
import com.canteen.repository.FoodRepository;
import com.canteen.repository.OrderRepository;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private FoodRepository foodRepository;
    private int orderCounter = 1;

    public OrderServiceImpl(OrderRepository orderRepository, FoodRepository foodRepository) {
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public Order placeOrder(Student student, int foodId, int quantity) {
        FoodItem food = foodRepository.findById(foodId);

        if (food == null) {
            System.out.println("Food item not found!");
            return null;
        }
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero!");
            return null;
        }
        if (food.getQuantity() < quantity) {
            System.out.println("Insufficient stock! Available: " + food.getQuantity());
            return null;
        }

        food.setQuantity(food.getQuantity() - quantity);
        Order order = new Order(orderCounter++, student, food, quantity);
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByStudent(int studentId) {
        return orderRepository.findByStudentId(studentId);
    }

    @Override
    public boolean cancelOrder(int orderId) {
        Order order = orderRepository.findById(orderId);
        if (order == null || order.getStatus().equals("CANCELLED")) {
            return false;
        }
        order.setStatus("CANCELLED");
        FoodItem food = order.getFoodItem();
        food.setQuantity(food.getQuantity() + order.getQuantity());
        return true;
    }
}
