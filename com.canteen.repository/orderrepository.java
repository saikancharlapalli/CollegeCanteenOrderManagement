package com.canteen.repository;

import com.canteen.entity.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> orderList = new ArrayList<>();

    public void save(Order order) {
        orderList.add(order);
    }

    public Order findById(int id) {
        for (Order o : orderList) {
            if (o.getOrderId() == id) {
                return o;
            }
        }
        return null;
    }

    public List<Order> findAll() {
        return orderList;
    }

    public List<Order> findByStudentId(int studentId) {
        List<Order> result = new ArrayList<>();
        for (Order o : orderList) {
            if (o.getStudent().getStudentId() == studentId) {
                result.add(o);
            }
        }
        return result;
    }
}
