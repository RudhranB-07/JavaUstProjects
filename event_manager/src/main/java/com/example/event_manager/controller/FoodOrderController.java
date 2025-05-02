package com.example.event_manager.controller;

import com.example.event_manager.entity.FoodOrder;
import com.example.event_manager.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodOrders")
public class FoodOrderController {

    @Autowired
    private FoodOrderService foodOrderService;

    // Get all food orders
    @GetMapping
    public ResponseEntity<List<FoodOrder>> getAllFoodOrders() {
        List<FoodOrder> foodOrders = foodOrderService.getAllFoodOrders();
        return ResponseEntity.ok(foodOrders);
    }

    // Get food order by ID
    @GetMapping("/{id}")
    public ResponseEntity<FoodOrder> getFoodOrderById(@PathVariable Long id) {
        FoodOrder foodOrder = foodOrderService.getFoodOrderById(id);
        return ResponseEntity.ok(foodOrder);
    }

    // Create a new food order
    @PostMapping
    public ResponseEntity<FoodOrder> createFoodOrder(@RequestBody FoodOrder foodOrder) {
        FoodOrder createdFoodOrder = foodOrderService.createFoodOrder(foodOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFoodOrder);
    }

    // Update an existing food order
    @PutMapping("/{id}")
    public ResponseEntity<FoodOrder> updateFoodOrder(@PathVariable Long id, @RequestBody FoodOrder updatedFoodOrder) {
        FoodOrder foodOrder = foodOrderService.updateFoodOrder(id, updatedFoodOrder);
        return ResponseEntity.ok(foodOrder);
    }

    // Delete a food order
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoodOrder(@PathVariable Long id) {
        if (foodOrderService.deleteFoodOrder(id)) {
            return ResponseEntity.ok("FoodOrder with id " + id + " was successfully deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FoodOrder with id " + id + " does not exist.");
        }
    }
}
