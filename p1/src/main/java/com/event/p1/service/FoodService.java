package com.event.p1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.event.p1.entity.Food;
import com.event.p1.repository.FoodRepository;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFood() { return foodRepository.findAll(); }
    public Food getFoodById(Long id) { return foodRepository.findById(id).orElse(null); }
    public Food saveFood(Food food) { return foodRepository.save(food); }
    public Food updateFood(Long id, Food newFoodData) {
        Food existingFood = foodRepository.findById(id).orElse(null);
        if (existingFood != null) {
            existingFood.setFoodtype(newFoodData.getFoodtype());
            existingFood.setPrice(newFoodData.getPrice());
            return foodRepository.save(existingFood);
        }
        return null;
    }
    public void deleteFood(Long id) { foodRepository.deleteById(id); }
}
