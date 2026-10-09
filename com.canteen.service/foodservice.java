package com.canteen.service;

import com.canteen.entity.FoodItem;
import java.util.List;

public interface FoodService {
    void addFoodItem(FoodItem item);
    List<FoodItem> getAllFoodItems();
    FoodItem getFoodById(int id);
    boolean removeFoodItem(int id);
}
