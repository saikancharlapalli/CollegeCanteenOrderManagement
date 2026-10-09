package com.canteen.service;

import com.canteen.entity.FoodItem;
import com.canteen.repository.FoodRepository;
import java.util.List;

public class FoodServiceImpl implements FoodService {
    private FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void addFoodItem(FoodItem item) {
        if (foodRepository.findById(item.getFoodId()) != null) {
            System.out.println("Food ID already exists!");
            return;
        }
        foodRepository.save(item);
        System.out.println("Food item added successfully.");
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        return foodRepository.findAll();
    }

    @Override
    public FoodItem getFoodById(int id) {
        return foodRepository.findById(id);
    }

    @Override
    public boolean removeFoodItem(int id) {
        return foodRepository.deleteById(id);
    }
}
