package com.event.p1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.p1.entity.Food;
import com.event.p1.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/all")
    public List<Food> getAllFood() {
        return foodService.getAllFood();
    }

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }

    @PostMapping("/create")
    public Food createFood(@RequestBody Food food) {
        return foodService.saveFood(food);
    }

    @PutMapping("/update/{id}")
    public Food updateFood(@PathVariable Long id, @RequestBody Food newFoodData) {
        return foodService.updateFood(id, newFoodData);
    }

    @DeleteMapping("/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return "Food deleted successfully!";
    }
}
