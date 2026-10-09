package com.canteen.repository;

import com.canteen.entity.FoodItem;
import java.util.ArrayList;
import java.util.List;

public class FoodRepository {
    private List<FoodItem> foodList = new ArrayList<>();

    public void save(FoodItem item) {
        foodList.add(item);
    }

    public FoodItem findById(int id) {
        for (FoodItem f : foodList) {
            if (f.getFoodId() == id) {
                return f;
            }
        }
        return null;
    }

    public List<FoodItem> findAll() {
        return foodList;
    }

    public boolean deleteById(int id) {
        FoodItem item = findById(id);
        if (item != null) {
            foodList.remove(item);
            return true;
        }
        return false;
    }
}
