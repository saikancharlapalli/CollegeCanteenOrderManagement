package com.canteen.service;

import com.canteen.entity.Order;
import com.canteen.entity.Student;
import java.util.List;

public interface OrderService {
    Order placeOrder(Student student, int foodId, int quantity);
    List<Order> getAllOrders();
    List<Order> getOrdersByStudent(int studentId);
    boolean cancelOrder(int orderId);
}
