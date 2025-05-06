package com.example.event_manager.service;

import com.example.event_manager.Repository.FoodOrderRepository;
import com.example.event_manager.entity.FoodOrder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodOrderService {

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    // Retrieve all food orders
    public List<FoodOrder> getAllFoodOrders() {
        return foodOrderRepository.findAll();
    }

    // Retrieve a food order by ID
    public FoodOrder getFoodOrderById(Long id) {
        return foodOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FoodOrder not found with id: " + id));
    }

    // Create a new food order
    public FoodOrder createFoodOrder(FoodOrder foodOrder) {
        return foodOrderRepository.save(foodOrder);
    }

    // Update a food order
    @Transactional
    public FoodOrder updateFoodOrder(Long id, FoodOrder updatedFoodOrder) {
        FoodOrder existingFoodOrder = foodOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FoodOrder not found with id: " + id));

        // Update fields
        existingFoodOrder.setFoodType(updatedFoodOrder.getFoodType());
        existingFoodOrder.setQuantity(updatedFoodOrder.getQuantity());
        existingFoodOrder.setPrice(updatedFoodOrder.getPrice());

        return foodOrderRepository.save(existingFoodOrder);
    }

    // Delete a food order
    public boolean deleteFoodOrder(Long id) {
        if (foodOrderRepository.existsById(id)) {
            foodOrderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
