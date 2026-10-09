package com.canteen.main;

import com.canteen.controller.CanteenController;
import com.canteen.entity.FoodItem;
import com.canteen.repository.FoodRepository;
import com.canteen.repository.OrderRepository;
import com.canteen.service.FoodService;
import com.canteen.service.FoodServiceImpl;
import com.canteen.service.OrderService;
import com.canteen.service.OrderServiceImpl;

public class Main {
    public static void main(String[] args) {
        
        FoodRepository foodRepository = new FoodRepository();
        OrderRepository orderRepository = new OrderRepository();

        
        FoodService foodService = new FoodServiceImpl(foodRepository);
        OrderService orderService = new OrderServiceImpl(orderRepository, foodRepository);

        
        loadSampleFoodItems(foodService);

        
        CanteenController controller = new CanteenController(foodService, orderService);
        controller.start();
    }

    private static void loadSampleFoodItems(FoodService foodService) {
        foodService.addFoodItem(new FoodItem(1, "Samosa", 15.0, 50));
        foodService.addFoodItem(new FoodItem(2, "Veg Sandwich", 40.0, 30));
        foodService.addFoodItem(new FoodItem(3, "Tea", 10.0, 100));
        foodService.addFoodItem(new FoodItem(4, "Coffee", 20.0, 80));
        foodService.addFoodItem(new FoodItem(5, "Veg Burger", 50.0, 25));
        foodService.addFoodItem(new FoodItem(6, "Chole Bhature", 60.0, 20));
        foodService.addFoodItem(new FoodItem(7, "Masala Dosa", 55.0, 25));
        foodService.addFoodItem(new FoodItem(8, "Veg Fried Rice", 70.0, 20));
        foodService.addFoodItem(new FoodItem(9, "Paneer Roll", 45.0, 30));
        foodService.addFoodItem(new FoodItem(10, "Cold Drink", 25.0, 60));
    }
}
