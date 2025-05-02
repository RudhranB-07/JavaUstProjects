package com.example.event_manager.controller;

import com.example.event_manager.entity.FoodType;
import com.example.event_manager.service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodTypes")
public class FoodTypeController {

    @Autowired
    private FoodTypeService foodTypeService;

    // Get all food types
    @GetMapping
    public ResponseEntity<List<FoodType>> getAllFoodTypes() {
        List<FoodType> foodTypes = foodTypeService.getAllFoodTypes();
        return ResponseEntity.ok(foodTypes);
    }

    // Get food type by ID
    @GetMapping("/{id}")
    public ResponseEntity<FoodType> getFoodTypeById(@PathVariable Long id) {
        FoodType foodType = foodTypeService.getFoodTypeById(id);
        return ResponseEntity.ok(foodType);
    }

    // Create a new food type
    @PostMapping
    public ResponseEntity<FoodType> createFoodType(@RequestBody FoodType foodType) {
        FoodType createdFoodType = foodTypeService.createFoodType(foodType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFoodType);
    }

    // Update an existing food type
    @PutMapping("/{id}")
    public ResponseEntity<FoodType> updateFoodType(@PathVariable Long id, @RequestBody FoodType updatedFoodType) {
        FoodType foodType = foodTypeService.updateFoodType(id, updatedFoodType);
        return ResponseEntity.ok(foodType);
    }

    // Delete a food type
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoodType(@PathVariable Long id) {
        if (foodTypeService.deleteFoodType(id)) {
            return ResponseEntity.ok("FoodType with id " + id + " was successfully deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FoodType with id " + id + " does not exist.");
        }
    }
}
