package com.example.event_manager.service;

import com.example.event_manager.Repository.FoodTypeRepository;
import com.example.event_manager.entity.FoodType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTypeService {

    @Autowired
    private FoodTypeRepository foodTypeRepository;

    // Retrieve all food types
    public List<FoodType> getAllFoodTypes() {
        return foodTypeRepository.findAll();
    }

    // Retrieve a food type by ID
    public FoodType getFoodTypeById(Long id) {
        return foodTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FoodType not found with id: " + id));
    }

    // Create a new food type
    public FoodType createFoodType(FoodType foodType) {
        return foodTypeRepository.save(foodType);
    }

    // Update a food type
    @Transactional
    public FoodType updateFoodType(Long id, FoodType updatedFoodType) {
        FoodType existingFoodType = foodTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FoodType not found with id: " + id));

        // Update fields
        existingFoodType.setFoodType(updatedFoodType.getFoodType());
        existingFoodType.setPrice(updatedFoodType.getPrice());

        return foodTypeRepository.save(existingFoodType);
    }

    // Delete a food type
    public boolean deleteFoodType(Long id) {
        if (foodTypeRepository.existsById(id)) {
            foodTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
